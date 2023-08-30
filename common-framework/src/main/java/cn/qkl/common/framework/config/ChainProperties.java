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
    private String url;
    private String skId;
    private String sk;

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
