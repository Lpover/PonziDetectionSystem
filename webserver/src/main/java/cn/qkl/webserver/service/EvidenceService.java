package cn.qkl.webserver.service;

import cn.qkl.common.framework.exception.BusinessException;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.framework.util.OssUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.EvidenceWeb;
import cn.qkl.webserver.common.BusinessStatus;
import cn.qkl.webserver.common.cert.FreemarkerUtils;
import cn.qkl.webserver.common.enums.EvidenceTypeEnum;
import cn.qkl.webserver.dao.EvidenceWebDao;
import cn.qkl.webserver.dto.evidence.EvidenceDetailDTO;
import cn.qkl.webserver.dto.evidence.EvidenceRecordListDTO;
import cn.qkl.webserver.dto.evidence.ReinforceEvidenceDTO;
import cn.qkl.webserver.dto.evidence.WebEvidenceDTO;
import cn.qkl.webserver.vo.evidence.EvidenceCertParamsVO;
import cn.qkl.webserver.vo.evidence.EvidenceCertVO;
import cn.qkl.webserver.vo.evidence.EvidenceDetailVO;
import cn.qkl.webserver.vo.evidence.EvidencePhaseVO;
import cn.qkl.webserver.vo.evidence.EvidenceRecordItemVO;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.fit.cssbox.demo.ImageRenderer;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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

    public EvidencePhaseVO webEvidence(WebEvidenceDTO dto) throws IOException, URISyntaxException, AWTException {
        EvidenceWeb evidenceWeb = new EvidenceWeb();
        BeanUtil.copyProperties(dto, evidenceWeb);
        evidenceWeb.setId(IdUtil.getSnowflakeNextId());
        evidenceWeb.setInstitution("机构名");
        evidenceWeb.setDepartment("部门名");
        evidenceWeb.setCreateTime(new Date());
        evidenceWeb.setUpdateTime(new Date());
        evidenceWeb.setDeleteStatus(0);
        evidenceWeb.setEvidenceType(0);
        evidenceWeb.setEvidencePhase(0);
        // 网页截图
        try {
            ImageRenderer render = new ImageRenderer();
            String url = dto.getUrl();
            String imagePath = dto.getName()+".png";
            FileOutputStream out = new FileOutputStream(new File(imagePath));
            render.renderURL(url, out, ImageRenderer.Type.PNG);
            File imageFile = new File(imagePath);
            InputStream inputStream = new FileInputStream(imageFile);
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            inputStream.close();
            String fileName = "web"+dto.getId().toString()+".png";
            evidenceWeb.setWebOssPath(ossUtil.uploadImage(bufferedImage, fileName));
            imageFile.delete();     // 删除本地图片
        } catch (Exception e) {
            e.printStackTrace();
        }

        EvidencePhaseVO vo = new EvidencePhaseVO();
        vo.setId(dto.getId());
        vo.setPhase(0);
        return vo;
    }

    public EvidencePhaseVO reinforceEvidence(ReinforceEvidenceDTO dto) throws IOException, TemplateException, ParserConfigurationException, URISyntaxException, FontFormatException, SAXException {
        EvidenceWeb evidenceWeb = new EvidenceWeb();
        BeanUtil.copyProperties(dto, evidenceWeb);

        evidenceWeb.setId(IdUtil.getSnowflakeNextId());
        evidenceWeb.setInstitution("机构名");
        evidenceWeb.setDepartment("部门名");
        evidenceWeb.setCreateTime(new Date());
        evidenceWeb.setUpdateTime(new Date());
        evidenceWeb.setDeleteStatus(0);
        evidenceWeb.setEvidenceType(2);
        evidenceWeb.setEvidencePhase(0);
        evidenceWeb.setWebOssPath(dto.getUrl());
        evidenceWebDao.insert(evidenceWeb);

        // 生成证书并上传oss
        evidenceWeb.setCertOssPath(generateEvidenceCert(dto.getId()));

        EvidencePhaseVO vo = new EvidencePhaseVO();
        vo.setId(dto.getId());
        vo.setPhase(1);
        return vo;
    }

    public EvidenceDetailVO getEvidenceDetail(EvidenceDetailDTO dto) {
        return evidenceWebDao.getEvidenceDetail(select(Tables.evidenceWeb.id.as("evidenceID"), Tables.evidenceWeb.name, Tables.evidenceWeb.riskType,
                Tables.evidenceWeb.introduction, Tables.evidenceWeb.institution, Tables.evidenceWeb.department, Tables.evidenceWeb.personnel,
                Tables.evidenceWeb.url, Tables.platform.name.as("platformName"), Tables.evidenceWeb.evidencePhase)
                .from(Tables.evidenceWeb)
                .leftJoin(Tables.platform).on(Tables.evidenceWeb.platformId, equalTo(Tables.platform.id))
                .where(Tables.evidenceWeb.id, isEqualTo(dto.getEvidenceID()))
                .build()
                .render(RenderingStrategies.MYBATIS3));
    }

    public void downloadEvidencePack(EvidenceDetailDTO dto) {


    }

    public void getEvidencePack(Long id) throws IOException {
        Optional<EvidenceWeb> evidenceWeb = evidenceWebDao.selectOne(c->c
                .where(Tables.evidenceWeb.id, isEqualTo(id)));
        InputStream webStream = ossUtil.downloadFileByURL(evidenceWeb.get().getWebOssPath());
        InputStream certStream = ossUtil.downloadFileByURL(evidenceWeb.get().getCertOssPath());
        String zipFilePath = "pack" + id + ".zip";
        FileOutputStream fos = new FileOutputStream(zipFilePath);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        compressPack(webStream, certStream, zipOut, id);
        fos.close();
        zipOut.close();

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
        evidenceWebDao.update(c->c
                .set(Tables.evidenceWeb.packOssPath).equalTo(packOssPath)
                .where(Tables.evidenceWeb.id, isEqualTo(id)));
        fileInputStream.close();
        zipFile.delete();
    }

    private void compressPack(InputStream webStream, InputStream certStream, ZipOutputStream zipOut, Long id) throws IOException {
        zipOut.putNextEntry(new ZipEntry("web" + id + ".png"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = webStream.read(buffer)) > 0) {
            zipOut.write(buffer, 0, len);
        }
        webStream.close();
        zipOut.closeEntry();

        zipOut.putNextEntry(new ZipEntry("cert" + id + ".png"));
        while ((len = certStream.read(buffer)) > 0) {
            zipOut.write(buffer, 0, len);
        }
        certStream.close();
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
        return new PageVO<>(dto.getPageId(),dto.getPageSize(),()->evidenceWebDao.getRecordList(
                select(Tables.evidenceWeb.id,
                        Tables.evidenceWeb.name,
                        Tables.evidenceWeb.riskType,
                        Tables.evidenceWeb.evidenceType,
                        Tables.evidenceWeb.evidencePhase,
                        Tables.evidenceWeb.packOssPath,
                        Tables.evidenceWeb.url,
                        Tables.evidenceWeb.createTime.as("time"),
                        Tables.platform.name.as("platform_name"),
                        Tables.platform.platformType).from(Tables.evidenceWeb,"ew")
                        .leftJoin(Tables.platform).on(Tables.evidenceWeb.platformId,equalTo(Tables.platform.id))
                        .where(Tables.evidenceWeb.deleteStatus,isEqualTo(0))
                        .orderBy(SimpleSortSpecification.of("time"))
                        .build().render(RenderingStrategies.MYBATIS3)
        ));
    }

    //根据字段生成证书 返回Oss地址
    protected String generateEvidenceCert(Long id) throws TemplateException, IOException, ParserConfigurationException, SAXException, FontFormatException {
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
        mapper.put("url",evidenceCertParamsVO.getUrl());
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
