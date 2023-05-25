package cn.qkl.common.framework.util;

import cn.qkl.common.framework.config.OssProperties;
import com.obs.services.ObsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
        return new ObsClient(this.ossProperties.getAk(), this.ossProperties.getSk(), this.ossProperties.getEndPoint());
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

}
