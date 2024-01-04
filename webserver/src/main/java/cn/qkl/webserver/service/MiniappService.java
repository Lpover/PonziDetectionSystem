package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.auth.TokenHandler;
import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.framework.util.OssUtil;
import cn.qkl.common.framework.util.SnowflakeIdUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.MiniappEvidence;
import cn.qkl.webserver.common.enums.MiniappEvidenceEnum;
import cn.qkl.webserver.dao.MiniappEvidenceDao;
import cn.qkl.webserver.dto.miniapp.EvidenceDTO;
import cn.qkl.webserver.dto.miniapp.VideoUploadDTO;
import cn.qkl.webserver.vo.miniapp.EvidenceVO;
import cn.qkl.webserver.vo.miniapp.VideoVO;
import org.mp4parser.boxes.iso14496.part12.MovieBox;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import org.mp4parser.IsoFile;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @Author sunxiaen
 * @Date 2024/1/2 14:09
 **/

@Service
public class MiniappService {

    @Resource
    OssUtil ossUtil;

    @Resource
    MiniappEvidenceDao miniappEvidenceDao;

    public VideoVO videoUpload(VideoUploadDTO dto) throws IOException {
        String ossUrl = ossUtil.uploadMultipartFile(dto.getFile(),dto.getName());
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
}
