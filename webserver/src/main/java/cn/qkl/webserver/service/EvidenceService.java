package cn.qkl.webserver.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.exception.BusinessException;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.framework.util.OssUtil;
import cn.qkl.common.framework.util.SchedulerUtil;
import cn.qkl.common.framework.util.SqlUtil;
import cn.qkl.common.framework.util.UploadToChainUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.ContentRisk;
import cn.qkl.common.repository.model.EvidenceWeb;
import cn.qkl.webserver.common.BusinessStatus;
import cn.qkl.webserver.common.cert.FreemarkerUtils;
import cn.qkl.webserver.common.enums.ChainEnum;
import cn.qkl.webserver.common.enums.EvidenceTypeEnum;
import cn.qkl.webserver.dao.ContentRiskDao;
import cn.qkl.webserver.dao.EvidenceWebDao;
import cn.qkl.webserver.dto.evidence.EvidenceDetailDTO;
import cn.qkl.webserver.dto.evidence.EvidenceRecordListDTO;
import cn.qkl.webserver.dto.evidence.ReinforceEvidenceDTO;
import cn.qkl.webserver.dto.evidence.WebEvidenceDTO;
import cn.qkl.webserver.vo.evidence.*;
import com.alibaba.nacos.common.utils.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.fit.cssbox.demo.ImageRenderer;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SimpleSortSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xhtmlrenderer.context.AWTFontResolver;
import org.xhtmlrenderer.swing.Java2DRenderer;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static java.awt.Font.TRUETYPE_FONT;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @Author sunxiaen
 * @Date 2023/6/29 17:31
 **/

@Slf4j
@Service
public class EvidenceService {

    @Autowired
    EvidenceWebDao evidenceWebDao;

    @Autowired
    OssUtil ossUtil;

    @Autowired
    ContentRiskDao contentRiskDao;

    @Autowired
    UploadToChainUtil uploadToChainUtil;

    public EvidencePhaseVO getEvidencePhase(EvidenceDetailDTO dto) {
        Optional<EvidenceWeb> evidenceWeb = evidenceWebDao.selectOne(c -> c
                .where(Tables.evidenceWeb.id, isEqualTo(dto.getEvidenceID())));
        EvidencePhaseVO vo = new EvidencePhaseVO();
        vo.setPhase(evidenceWeb.get().getEvidencePhase());
        return vo;
    }

    public EvidenceRiskTypeVO getRiskTypeList() {
        List<ContentRisk> riskList = contentRiskDao.select(c -> c);
        EvidenceRiskTypeVO vo = new EvidenceRiskTypeVO();
        vo.setRiskList(riskList.stream()
                .map(ContentRisk::getCategory)
                .collect(Collectors.toList()));
        return vo;
    }

    // 网页截图
    public void webCapture(String url, String name, Long id) {
        File imageFile = null;
        try {
            ImageRenderer render = new ImageRenderer();
            String imagePath = name + ".png";
            FileOutputStream out = new FileOutputStream(new File(imagePath));
            render.renderURL(url, out, ImageRenderer.Type.PNG);
            out.close();
            imageFile = new File(imagePath);
            InputStream inputStream = new FileInputStream(imageFile);
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            inputStream.close();
            String fileName = "web" + id.toString() + ".png";
            String webOssPath = ossUtil.uploadImage(bufferedImage, fileName);
            // 更新webOssPath字段
            evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.webOssPath).equalTo(webOssPath).where(Tables.evidenceWeb.id, isEqualTo(id)));
            evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.updateTime).equalTo(new Date()).where(Tables.evidenceWeb.id,isEqualTo(id)));
            evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.evidencePhase).equalTo(1).where(Tables.evidenceWeb.id,isEqualTo(id)));
            log.info("网页截图完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (imageFile != null && imageFile.exists()) {
                try {
                    imageFile.delete(); // 删除本地图片
//                    log.info("文件删除成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }




    public EvidencePhaseVO webEvidence(WebEvidenceDTO dto) {
        EvidenceWeb evidenceWeb = new EvidenceWeb();
        BeanUtil.copyProperties(dto, evidenceWeb);
        evidenceWeb.setPlatformId(dto.getPlatformId());
        evidenceWeb.setId(IdUtil.getSnowflakeNextId());
        evidenceWeb.setDeleteStatus(0);
        evidenceWeb.setEvidenceType(EvidenceTypeEnum.WEBPAGE.getCode());     // 取证固证来源
        evidenceWeb.setUpdateTime(new Date());
        evidenceWeb.setCreateTime(new Date());
        evidenceWeb.setEvidencePhase(0);

        if (dto.getFrequency() != 0) {  // 定时取证就提早返回
            if (dto.getFrequency() == 1) {
                evidenceWeb.setNextEvidenceTime(dto.getStartTime());
            } else {
                Date currentDate = new Date();
                int dayOfMonth = dto.getDayOfMonth();
                int dayOfWeek = dto.getDayOfWeek();

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dto.getStartTime());

                // 计算下一次操作的时间
                if (dto.getFrequency() == 6) {
                    // 如果dayOfWeek有效，将日历设置为下一个符合条件的星期几
                    calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek + 1);
                    if (currentDate.after(calendar.getTime())) {
                        // 如果当前日期已经超过了目标星期几，就加7天以确保下一个星期几
                        calendar.add(Calendar.DAY_OF_MONTH, 7);
                    }
                } else if (dto.getFrequency() == 7) {
                    // 如果dayOfMonth有效，将日历设置为下一个符合条件的日期
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    if (currentDate.after(calendar.getTime())) {
                        // 如果当前日期已经超过了目标日期，就加一个月以确保下一个目标日期
                        calendar.add(Calendar.MONTH, 1);
                    }
                } else if (dto.getFrequency() == 5) {   // 每天取证
                    if (currentDate.after(calendar.getTime())) {
                        // 如果当前日期已经超过了目标日期，就加一个月以确保下一个目标日期
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                    }
                }
                evidenceWeb.setNextEvidenceTime(calendar.getTime());
            }

            evidenceWebDao.insert(evidenceWeb);
            EvidencePhaseVO vo = new EvidencePhaseVO();
            vo.setId(evidenceWeb.getId());
            return vo;
        }

        CountDownLatch latch = new CountDownLatch(2);

        // 网页截图，上链
        SchedulerUtil.commonScheduler.schedule("generateWebCapture", () -> {
            webCapture(dto.getUrl(), dto.getName(), evidenceWeb.getId());
            String webOss = evidenceWebDao.selectOne(c->c
                    .where(Tables.evidenceWeb.id, isEqualTo(dto.getId()))).get().getWebOssPath();
            InputStream webStream = null;
            try {
                webStream = ossUtil.downloadFileByURL(webOss);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 计算hash并上链
            String digest = null;
            try {
                digest = uploadToChainUtil.calculateHash(webStream, "MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                uploadToChainUtil.uploadToChain(digest);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            evidenceWeb.setPackageHash(digest);                     // 文件hash
            evidenceWeb.setHash(uploadToChainUtil.getTxHash());     // 上链hash
            evidenceWeb.setChainTime(uploadToChainUtil.getTxTime());    // 上链时间
            evidenceWeb.setChainId(ChainEnum.XINZHENG.getCode());
            latch.countDown();
        });
        evidenceWebDao.insert(evidenceWeb);

        // 生成证书并上传oss
        SchedulerUtil.commonScheduler.schedule("generateCert", () -> {
            try {
                String ossPath = generateEvidenceCert(evidenceWeb.getId());
                evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.certOssPath).equalTo(ossPath).where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId())));
                evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.updateTime).equalTo(new Date()).where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId())));
                evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.evidencePhase).equalTo(2).where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId())));
            } catch (TemplateException | ParserConfigurationException | IOException | SAXException |
                     FontFormatException e) {
                throw new RuntimeException(e);
            } finally {
                latch.countDown();
            }
        });

        // 等待计数值变为零
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 生成证据包并上传oss
        SchedulerUtil.commonScheduler.schedule("generateEvidencePack", () -> {
            try {
                generateEvidencePack(evidenceWeb.getId());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        EvidencePhaseVO vo = new EvidencePhaseVO();
        vo.setId(evidenceWeb.getId());
        return vo;
    }

    public void stopRegularEvidence(Long id) {
        evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.frequency).equalTo(0).where(Tables.evidenceWeb.id, isEqualTo(id)));
    }

    public EvidencePhaseVO reinforceEvidence(ReinforceEvidenceDTO dto) {
        EvidenceWeb evidenceWeb = new EvidenceWeb();
        BeanUtil.copyProperties(dto, evidenceWeb);
//        log.info(String.valueOf(dto.getPlatformId()));
        evidenceWeb.setPlatformId(dto.getPlatformId());
        evidenceWeb.setId(IdUtil.getSnowflakeNextId());
        evidenceWeb.setCreateTime(new Date());
        evidenceWeb.setUpdateTime(new Date());
        evidenceWeb.setDeleteStatus(0);
        evidenceWeb.setEvidenceType(EvidenceTypeEnum.MANUAL.getCode());     // 取证固证来源
        evidenceWeb.setEvidencePhase(1);
        evidenceWeb.setWebOssPath(dto.getUrl());

        // 上链
        InputStream webStream = null;
        try {
            webStream = ossUtil.downloadFileByURL(dto.getUrl());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 计算hash并上链
        String digest = null;
        try {
            digest = uploadToChainUtil.calculateHash(webStream, "MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            uploadToChainUtil.uploadToChain(digest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        evidenceWeb.setPackageHash(digest);                     // 文件hash
        evidenceWeb.setHash(uploadToChainUtil.getTxHash());     // 上链hash
        evidenceWeb.setChainTime(uploadToChainUtil.getTxTime());    // 上链时间
        evidenceWeb.setChainId(ChainEnum.XINZHENG.getCode());

        evidenceWebDao.insert(evidenceWeb);

        // 需要设置计数器保证先后关系
        CountDownLatch latch = new CountDownLatch(1);

        // 生成证书并上传oss
        SchedulerUtil.commonScheduler.schedule("generateCert", () -> {
            try {
                String ossPath = generateEvidenceCert(evidenceWeb.getId());
                evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.certOssPath).equalTo(ossPath).where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId())));
                evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.updateTime).equalTo(new Date()).where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId())));
                evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.evidencePhase).equalTo(2).where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId())));
            } catch (TemplateException | ParserConfigurationException | IOException | SAXException |
                     FontFormatException e) {
                throw new RuntimeException(e);
            } finally {
              latch.countDown();
            }
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 生成证据包并上传oss
        SchedulerUtil.commonScheduler.schedule("generateEvidencePack", () -> {
            try {
                generateEvidencePack(evidenceWeb.getId());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        EvidencePhaseVO vo = new EvidencePhaseVO();
        vo.setId(evidenceWeb.getId());
        return vo;
    }

    public EvidenceDetailVO getEvidenceDetail(EvidenceDetailDTO dto) {
        return evidenceWebDao.getEvidenceDetail(select(Tables.evidenceWeb.id.as("evidenceID"), Tables.evidenceWeb.name, Tables.evidenceWeb.riskType,
                Tables.evidenceWeb.introduction, Tables.evidenceWeb.personnel, Tables.evidenceWeb.packOssPath.as("packOssPath"),
                Tables.evidenceWeb.url, Tables.platform.name.as("platformName"), Tables.evidenceWeb.evidencePhase)
                .from(Tables.evidenceWeb)
                .leftJoin(Tables.platform).on(Tables.evidenceWeb.platformId, equalTo(Tables.platform.id))
                .where(Tables.evidenceWeb.id, isEqualTo(dto.getEvidenceID()))
                .build()
                .render(RenderingStrategies.MYBATIS3));
    }

//    public void downloadEvidencePack1(EvidenceDetailDTO dto, HttpServletResponse response) throws IOException {
//        Optional<EvidenceWeb> evidenceWeb = evidenceWebDao.selectOne(c -> c
//                .where(Tables.evidenceWeb.id, isEqualTo(dto.getEvidenceID())));
//        String packOssPath = evidenceWeb.get().getPackOssPath();
//        if (packOssPath == null || packOssPath.equals("")) {
//            log.error("证据包不存在");
//            return;
//        }
//
//        InputStream inputStream = ossUtil.downloadFileByURL(packOssPath);
//        String fileName = "evidencePack_" + evidenceWeb.get().getId() + ".zip";
//
//        response.setContentType("application/zip");
//        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//        StreamUtils.copy(inputStream, response.getOutputStream());
//        inputStream.close();
//    }




    public void downloadEvidencePack(EvidenceDetailDTO dto, HttpServletResponse response) throws IOException {
        Optional<EvidenceWeb> evidenceWeb = evidenceWebDao.selectOne(c -> c
                .where(Tables.evidenceWeb.id, isEqualTo(dto.getEvidenceID())));
        String packOssPath = evidenceWeb.get().getPackOssPath();
        if (packOssPath == null || packOssPath.equals("")) {
            log.error("证据包不存在");
            return;
        }
        URL url = new URL(packOssPath);
//        log.info(url.toString());

//        try (BufferedInputStream is = new BufferedInputStream(url.openStream())) {
        InputStream is = null;
//        FileOutputStream os = null;

        try {
            // 打开连接
            URLConnection con = url.openConnection();
            // 输入流
            is = con.getInputStream();
            log.info(is.toString());
            String[] pathSegments = packOssPath.split("/");
            String fileName = pathSegments[pathSegments.length - 1];

            // 设置下载文件的响应头信息
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentType("application/octet-stream");

            // 将文件内容写入响应输出流
            byte[] buffer = new byte[4096];
            int length = 0;
            int totalLength = 0;
            ServletOutputStream outputStream = response.getOutputStream();
            while ((length = is.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
                totalLength += length;
            }
            outputStream.flush();
            // 设置文件大小
            response.setContentLength(totalLength);
            log.info(String.valueOf(totalLength));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (is != null) {
                is.close();
            }
        }

    }

    public void generateEvidencePack(Long id) throws IOException {
        Optional<EvidenceWeb> evidenceWeb = evidenceWebDao.selectOne(c->c
                .where(Tables.evidenceWeb.id, isEqualTo(id)));
        String webOssPath= evidenceWeb.get().getWebOssPath();
        String certOssPath =  evidenceWeb.get().getCertOssPath();
        if (webOssPath == null || certOssPath == null || webOssPath.isEmpty() || certOssPath.isEmpty()) {
            log.error("缺少webOsspath或certOssPath");
            return;
        }

        String ext = "";
        int lastDotIndex = webOssPath.lastIndexOf(".");
        if (lastDotIndex != -1 && lastDotIndex < webOssPath.length() - 1) {
            ext = webOssPath.substring(lastDotIndex + 1);
        }

        InputStream webStream = ossUtil.downloadFileByURL(webOssPath);
        InputStream certStream = ossUtil.downloadFileByURL(certOssPath);
        String zipFilePath = "pack" + id + ".zip";
        FileOutputStream fos = new FileOutputStream(zipFilePath);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        compressPack(webStream, ext, certStream, zipOut, id);
        fos.close();
//        zipOut.close();
        webStream.close();
        certStream.close();

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
        evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.packOssPath).equalTo(packOssPath).where(Tables.evidenceWeb.id,isEqualTo(id)));
        evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.updateTime).equalTo(new Date()).where(Tables.evidenceWeb.id,isEqualTo(id)));
        evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.evidencePhase).equalTo(2).where(Tables.evidenceWeb.id,isEqualTo(id)));
        log.info("生成证据包完成");
    }

    private void compressPack(InputStream webStream, String ext, InputStream certStream, ZipOutputStream zipOut, Long id) throws IOException {
        zipOut.putNextEntry(new ZipEntry("web" + id + "." + ext));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = webStream.read(buffer)) > 0) {
            zipOut.write(buffer, 0, len);
        }
        zipOut.closeEntry();

        zipOut.putNextEntry(new ZipEntry("cert" + id + ".png"));
        while ((len = certStream.read(buffer)) > 0) {
            zipOut.write(buffer, 0, len);
        }
        zipOut.closeEntry();
    }

    public EvidenceCertVO getEvidenceCert(Long id) throws TemplateException, IOException, ParserConfigurationException, FontFormatException, SAXException {
        //如果没有就要生成
        String certOss = evidenceWebDao.getEvidenceCert(
                select(Tables.evidenceWeb.certOssPath).from(Tables.evidenceWeb)
                        .where(Tables.evidenceWeb.id,isEqualTo(id))
                        .build().render(RenderingStrategies.MYBATIS3)
        );
        if (certOss == null || certOss.isEmpty()) {
            certOss = generateEvidenceCert(id);
            String finalCertOss = certOss;
            int status = evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.certOssPath).equalTo(finalCertOss).where(Tables.evidenceWeb.id,isEqualTo(id)));
        }
        EvidenceCertVO vo = new EvidenceCertVO();
        vo.setUrl(certOss);
        return vo;
    }

    public void markDeleteEvidence(Long id) {
        if(evidenceWebDao.markDeleteEvidence(
                update(Tables.evidenceWeb).set(Tables.evidenceWeb.deleteStatus).equalTo(1).set(Tables.evidenceWeb.updateTime).equalTo(new Date())
                        .where(Tables.evidenceWeb.id,isEqualTo(id))
                        .and(Tables.evidenceWeb.deleteStatus,isEqualTo(0))
                        .build().render(RenderingStrategies.MYBATIS3)
        )== 0 ) {
            throw new BusinessException(BusinessStatus.DELETE_FAILED);
        }
    }

    public PageVO<EvidenceRecordItemVO> getRecordList(EvidenceRecordListDTO dto) {
        QueryExpressionDSL<org.mybatis.dynamic.sql.select.SelectModel>.QueryExpressionWhereBuilder builder = select(Tables.evidenceWeb.id,
                Tables.evidenceWeb.name,
                Tables.evidenceWeb.riskType,
                Tables.evidenceWeb.evidenceType,
                Tables.evidenceWeb.evidencePhase,
                Tables.evidenceWeb.packOssPath,
                Tables.evidenceWeb.url,
                Tables.evidenceWeb.frequency,
                Tables.evidenceWeb.createTime.as("time"),
                Tables.platform.name.as("platform_name"),
                Tables.platform.platformType).from(Tables.evidenceWeb, "ew")
                .leftJoin(Tables.platform).on(Tables.evidenceWeb.platformId, equalTo(Tables.platform.id))
                .where(Tables.evidenceWeb.deleteStatus, isEqualTo(0));


        if (dto.getEvidenceName() != null) {
            builder = builder.and(Tables.evidenceWeb.name, isLike(SqlUtil.allLike(dto.getEvidenceName())));
        }
        if (dto.getRiskType() != null){
            builder = builder.and(Tables.evidenceWeb.riskType, isLike(SqlUtil.allLike(dto.getRiskType())));
        }
        if (dto.getEvidenceType() != null) {
            builder = builder.and(Tables.evidenceWeb.evidenceType, isEqualTo(dto.getEvidenceType()));
        }
        if (dto.getPlatformId() != null) {
            builder = builder.and(Tables.evidenceWeb.platformId, isEqualTo(dto.getPlatformId()));
        }
        if (dto.getStartTime() != null) {
            builder = builder.and(Tables.evidenceWeb.createTime, isGreaterThanOrEqualTo(dto.getStartTime()));
        }
        if (dto.getEndTime() != null) {
            builder = builder.and(Tables.evidenceWeb.createTime, isLessThanOrEqualTo(dto.getEndTime()));
        }

        QueryExpressionDSL<org.mybatis.dynamic.sql.select.SelectModel>.QueryExpressionWhereBuilder finalBuilder = builder;
        return new PageVO<>(dto.getPageId(),dto.getPageSize(),()->evidenceWebDao.getRecordList(
                finalBuilder
                .orderBy(SimpleSortSpecification.of("time").descending())
                .build().render(RenderingStrategies.MYBATIS3)
        ));
    }

    //根据字段生成证书 返回Oss地址
    public String generateEvidenceCert(Long id) throws TemplateException, IOException, ParserConfigurationException, SAXException, FontFormatException {
        //H5模板,填入参数
        EvidenceCertParamsVO evidenceCertParamsVO = evidenceWebDao.getEvidenceCertParams(select(
                    Tables.evidenceWeb.personnel,
                    Tables.platform.name.as("platform_name"),
                    Tables.evidenceWeb.evidenceType,
                    Tables.evidenceWeb.url,
                    Tables.evidenceWeb.packageHash,
                    Tables.evidenceWeb.hash,
                    Tables.chain.chainName,
                    Tables.evidenceWeb.createTime.as("timestamp")
                ).from(Tables.evidenceWeb)
                .leftJoin(Tables.platform).on(Tables.platform.id,equalTo(Tables.evidenceWeb.platformId))
                .leftJoin(Tables.chain).on(Tables.chain.id,equalTo(Tables.evidenceWeb.chainId))
                .where(Tables.evidenceWeb.id,isEqualTo(id))
                .build().render(RenderingStrategies.MYBATIS3)

        );

        Map<String,Object> mapper = new HashMap<>();
        mapper.put("who",evidenceCertParamsVO.getPersonnel());
        mapper.put("platform",evidenceCertParamsVO.getPlatformName());
        mapper.put("type", EvidenceTypeEnum.valueOf(Math.toIntExact(evidenceCertParamsVO.getEvidenceType())));
//        mapper.put("packagehash",evidenceCertParamsVO.getPackageHash());
        mapper.put("url", StringUtils.replace(evidenceCertParamsVO.getUrl(),"&","&amp;"));
        mapper.put("packagehash",evidenceCertParamsVO.getPackageHash());
        mapper.put("txhash",evidenceCertParamsVO.getHash());
        mapper.put("chain",evidenceCertParamsVO.getChainName());
        mapper.put("timestamp",evidenceCertParamsVO.getTimestamp());

        String html = FreemarkerUtils.getTemplate("cert.ftl",mapper);
        System.out.println(html);
        byte[] bytes = html.getBytes(StandardCharsets.UTF_8);
        ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(bin);
        //加载自定义字体，解决生成图片title处汉字展示不正常问题
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("font/PingFangSC-Regular.ttf");
        BufferedImage img;
        if (inputStream != null){
            Font font = Font.createFont(TRUETYPE_FONT, inputStream);
            AWTFontResolver awtFontResolver = new AWTFontResolver();
            awtFontResolver.setFontMapping("Serif", font);
            Java2DRenderer renderer = new Java2DRenderer(document, 559, 839);
            renderer.getSharedContext().setFontResolver(awtFontResolver);
            img = renderer.getImage();
        } else {
            throw new RuntimeException("no Font in classpath:font/PingFangSC-Regular.ttf");
        }

        //并上传到oss
        String fileName = "cert"+id.toString()+".png";
        return ossUtil.uploadImage(img.getSubimage(8,8,551,831),fileName);
    }
}
