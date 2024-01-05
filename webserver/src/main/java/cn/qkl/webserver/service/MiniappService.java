package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.auth.TokenHandler;
import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.framework.util.OssUtil;
import cn.qkl.common.framework.util.SnowflakeIdUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.EvidenceWeb;
import cn.qkl.common.repository.model.MiniappEvidence;
import cn.qkl.webserver.common.enums.MiniappEvidenceEnum;
import cn.qkl.webserver.dao.MiniappEvidenceDao;
import cn.qkl.webserver.dto.miniapp.EvidenceDTO;
import cn.qkl.webserver.dto.miniapp.VideoUploadDTO;
import cn.qkl.webserver.vo.miniapp.EvidenceVO;
import cn.qkl.webserver.vo.miniapp.VideoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.mp4parser.boxes.iso14496.part12.MovieBox;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.mp4parser.IsoFile;

import static cn.qkl.common.framework.util.OssUtil.log;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @Author sunxiaen
 * @Date 2024/1/2 14:09
 **/

@Slf4j
@Service
public class MiniappService {

    @Resource
    OssUtil ossUtil;

    @Resource
    MiniappEvidenceDao miniappEvidenceDao;

    public VideoVO videoUpload(VideoUploadDTO dto) throws IOException {
        String ossUrl = ossUtil.uploadMultipartFile(dto.getFile(),dto.getFile().getOriginalFilename());
        MiniappEvidence evidence = new MiniappEvidence();
        evidence.setId(SnowflakeIdUtil.generateId());
        evidence.setName(dto.getName());
        evidence.setUrl(ossUrl);
        evidence.setPreserved(MiniappEvidenceEnum.NonPreserved.getCode());
        Date date = new Date();
        evidence.setTime(date);
        evidence.setExpiredTime(DateUtil.offsetMinute(date,120));
        evidence.setUserid(TokenHandler.getUserId());

        //解析视频数据
        Map<String, Long> result = parseVideo(dto.getFile());
        Long fileSize = result.get("fileSize");
        Long roundedDuration = result.get("durationInSeconds");
        evidence.setVideoSize(fileSize);
        evidence.setVideoTime(roundedDuration);

        miniappEvidenceDao.insert(evidence);
        return FunctionUtil.apply(new VideoVO(), it -> {
            it.setUrl(ossUrl);
        });
    }

    //解析视频
    public Map<String, Long> parseVideo(MultipartFile file) {
        Map<String, Long> result = new HashMap<>();

        try {
            // 将 MultipartFile 转为临时文件
            Path tempFile = Files.createTempFile("temp-video", ".mp4");
            Files.copy(file.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
            // 创建 IsoFile 对象
            IsoFile isoFile = new IsoFile(tempFile.toString());

            // 获取 MovieBox，它包含有关视频的信息
            MovieBox movieBox = isoFile.getMovieBox();

            // 获取文件大小（字节数）
            long fileSize = new RandomAccessFile(tempFile.toFile(), "r").length();

            // 获取视频时长（以秒为单位）
            long durationInSeconds = movieBox.getMovieHeaderBox().getDuration() / movieBox.getMovieHeaderBox().getTimescale();

            // 存储结果到Map
            result.put("fileSize", fileSize);
            result.put("durationInSeconds", durationInSeconds);

            // 打印信息或将其存储到数据库
            System.out.println("文件大小：" + fileSize + " 字节");
            System.out.println("视频时长：" + durationInSeconds + " 秒");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<EvidenceVO> getEvidenceList(EvidenceDTO dto) throws IOException {
        if (dto.getPreserved() == MiniappEvidenceEnum.NonPreserved.getCode()) {
            List<EvidenceVO> voList = miniappEvidenceDao.selectEvidenceList(select(Tables.user.name.as("userName"),
                    Tables.miniappEvidence.name,Tables.miniappEvidence.id,
                    Tables.miniappEvidence.time,Tables.miniappEvidence.expiredTime,
                    Tables.miniappEvidence.videoSize,Tables.miniappEvidence.videoTime).from(Tables.miniappEvidence)
                    .leftJoin(Tables.user).on(Tables.user.id, equalTo(Tables.miniappEvidence.userid))
                    .where(Tables.miniappEvidence.preserved, isEqualTo(MiniappEvidenceEnum.NonPreserved.getCode()))
                    .orderBy(Tables.miniappEvidence.expiredTime).build().render(RenderingStrategies.MYBATIS3));
            for (EvidenceVO vo : voList) {
                vo.calExpiredIn();
            }
            return voList;
        } else if (dto.getPreserved() == MiniappEvidenceEnum.Preserved.getCode()) {
            return null;
        }
        return null;
    }

    public void generateEvidencePack(Long id) throws IOException {
        Optional<MiniappEvidence> miniappEvidence = miniappEvidenceDao.selectOne(c->c
                .where(Tables.miniappEvidence.id, isEqualTo(id)));
        String webOssPath= miniappEvidence.get().getUrl();
        if (webOssPath == null || webOssPath.isEmpty() ) {
            log.error("缺少OSS地址");
            return;
        }

        String ext = "";
        int lastDotIndex = webOssPath.lastIndexOf(".");
        if (lastDotIndex != -1 && lastDotIndex < webOssPath.length() - 1) {
            ext = webOssPath.substring(lastDotIndex + 1);
        }

        String zipFilePath = "pack" + id + ".zip";
        try {
            InputStream webStream = ossUtil.downloadFileByURL(webOssPath);

            try (FileOutputStream fos = new FileOutputStream(zipFilePath);
                 ZipOutputStream zipOut = new ZipOutputStream(fos)) {
                compressPack(webStream, ext, zipOut, id);
            } catch (IOException e) {
                // 处理文件操作过程中的 IO 异常
                e.printStackTrace();
            } finally {
                try {
                    if (webStream != null) {
                        webStream.close();
                    }
                } catch (IOException e) {
                    // 处理关闭流时的异常
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            // 处理其他异常
            e.printStackTrace();
        }

        File zipFile = new File(zipFilePath);
        FileInputStream fileInputStream = null;
        MultipartFile multipartFile = null;
        try {
            fileInputStream = new FileInputStream(zipFile);
            multipartFile = new MockMultipartFile(zipFile.getName(),zipFile.getName(),
                    ContentType.APPLICATION_OCTET_STREAM.toString(),fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String packOssPath = ossUtil.uploadMultipartFile(multipartFile, zipFilePath);
        fileInputStream.close();
        zipFile.delete();
        evidenceWebDao.update(c ->
                c.set(Tables.evidenceWeb.packOssPath).equalTo(packOssPath)
                        .set(Tables.evidenceWeb.updateTime).equalTo(new Date())
                        .set(Tables.evidenceWeb.evidencePhase).equalTo(2)
                        .where(Tables.evidenceWeb.id, isEqualTo(id))
        );
        log.info("生成证据包完成");
    }

    private void compressPack(InputStream webStream, String ext, ZipOutputStream zipOut, Long id) throws IOException {
        zipOut.putNextEntry(new ZipEntry("Vedio" + ext + ".mp4"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = webStream.read(buffer)) > 0) {
            zipOut.write(buffer, 0, len);
        }
        zipOut.closeEntry();

    }
}
