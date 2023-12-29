package cn.qkl.webserver.service;

import cn.hutool.core.util.IdUtil;
import cn.qkl.webserver.dto.evidence.ReinforceEvidenceDTO;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootTest
class EvidenceServiceTest {

    @Autowired
    EvidenceService evidenceService;

    @Test
    void getResoucePath(){
//        classpath路径：/F:/BackendProject/sa-backend/webserver/target/classes/application.yml
//        项目根路径：/F:/BackendProject/sa-backend/webserver/
//        Resource目录路径：/F:/BackendProject/sa-backend/webserver/target/test-classes/
        ClassLoader classLoader = getClass().getClassLoader();
        String classPath = classLoader.getResource("application.yml").getPath();
        System.out.println("classpath路径：" + classPath);

        String rootPath = getClass().getResource("/").getPath().split("target")[0];
        System.out.println("项目根路径：" + rootPath);

        String resourcePath = this.getClass().getResource("/").getPath();
        System.out.println("Resource目录路径：" + resourcePath);
    }

    @Test
    void generateEvidenceCert() throws TemplateException, IOException, ParserConfigurationException, FontFormatException, SAXException, URISyntaxException {
        System.out.println(evidenceService.generateEvidenceCert(1698522678228054016L));
//        网页截图
//        try {
//            ImageRenderer render = new ImageRenderer();
//            System.out.println("start");
//            String url = "https://developers.weixin.qq.com/miniprogram/dev/component/canvas.html";/*网络链接的html*/
//            FileOutputStream out = new FileOutputStream(new File("D:"+ File.separator+"html.png"));/*生成文件的路径*/
//            render.renderURL(url, out, ImageRenderer.Type.PNG);/*将url网页写入生成文件中*/
//            System.out.println("OK");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Test
    void generateEvidencePack() throws IOException {
        evidenceService.generateEvidencePack(1696800792091766784L);
    }

    @Test
    void reinforceEvidence() {
        ReinforceEvidenceDTO dto = new ReinforceEvidenceDTO();
        dto.setId(IdUtil.getSnowflakeNextId());
        dto.setName("123");
        dto.setUrl("https://digital-content.obs.cn-east-3.myhuaweicloud.com/file");
        dto.setPlatformId(1L);
        dto.setPersonnel("123321");
        dto.setIntroduction("213");
        dto.setRiskType("无");
        evidenceService.reinforceEvidence(dto);
    }

}