//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.qkl.common.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(
        prefix = "qkl.framework.chainutil"
)
public class ChainProperties implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(ChainProperties.class);
    private String url = "http://47.114.77.180:9090";
    private String skId = "337bcc493804468db01860af65efff69";
    private String sk = "0b20640e701f4aa3923b94bbf52c37c3";

    public void afterPropertiesSet() {
        log.info("{}", this);
    }

    public ChainProperties() {
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSkId() {
        return skId;
    }

    public void setSkId(String skId) {
        this.skId = skId;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }
}
