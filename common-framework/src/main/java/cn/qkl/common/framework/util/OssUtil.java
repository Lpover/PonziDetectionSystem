package cn.qkl.common.framework.util;

import cn.qkl.common.framework.config.OssProperties;
import com.alibaba.excel.util.FileUtils;
import com.obs.services.ObsClient;
import com.obs.services.model.ObsObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @param
 * @return
 */
@Component

public class OssUtil {
    private static final Logger log = LoggerFactory.getLogger(OssUtil.class);
//    @Autowired
    OssProperties ossProperties;
    private final ObsClient obsClient;

    public OssUtil(OssProperties ossProperties) {
        this.ossProperties = ossProperties;
        this.obsClient = this.initOssClient();
    }

    private ObsClient initOssClient() {
        log.info("初始化ossClient");
        return new ObsClient(this.ossProperties.getAk()==null?"MUIBG1CQ5TLHIF5NHER2":this.ossProperties.getAk(),
        this.ossProperties.getSk()==null?"BMNCoYbF4vd9Pv5LCHFCgz0xnFHLp8oUu8mmJXXV":this.ossProperties.getSk(),
        this.ossProperties.getEndPoint()==null?"https://obs.cn-east-3.myhuaweicloud.com":this.ossProperties.getEndPoint());
    }

    public String updateLocalFile(String localFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(localFile);
            // 兼容linux和windows的路径分隔符
            String[] arr = localFile.split("/|\\\\");
            String remoteFile = arr[arr.length - 1];
            obsClient.putObject("digital-content", remoteFile, fileInputStream);
            return "https://digital-content.obs.cn-east-3.myhuaweicloud.com/" + remoteFile;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Upload file failed, File not found:", e);
        }
    }

    public String uploadImage(RenderedImage image, String fileName) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image,"png",os);
        ByteArrayInputStream in = new ByteArrayInputStream(os.toByteArray());
        obsClient.putObject("digital-content", fileName,in);
        return "https://digital-content.obs.cn-east-3.myhuaweicloud.com/" + fileName;
    }

    // 文件对象下载
    public ObsObject downloadFile(String dir, String fileName) {
        ObsObject obsObject = null;
        try {
            obsObject = obsClient.getObject("digital-content", dir + fileName);
            log.info("下载文件ObsObject: " + obsObject);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("OBS下载文件报错Exception: " + e.getMessage());
        }
        return obsObject;
    }

    // 根据访问链接进行文件对象下载
    public InputStream downloadFileByURL(String fileUrl) throws IOException {
        URL url = new URL(fileUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // 获取文件流
        InputStream inputStream = connection.getInputStream();
        // 使用 BufferedInputStream 对文件流进行缓冲
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        return bufferedInputStream;
    }

    public String uploadMultipartFile(MultipartFile file, String fileName) throws IOException {
        byte[] bytes = file.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        obsClient.putObject("digital-content", fileName, in);
        return "https://digital-content.obs.cn-east-3.myhuaweicloud.com/" + fileName;
    }

    //上传文件
    public String uploadFile(File file, String fileName) throws IOException {
        byte[] bytes = FileUtils.readFileToByteArray(file);
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        obsClient.putObject("digital-content", fileName, in);
        return "https://digital-content.obs.cn-east-3.myhuaweicloud.com/" + fileName;
    }

}
