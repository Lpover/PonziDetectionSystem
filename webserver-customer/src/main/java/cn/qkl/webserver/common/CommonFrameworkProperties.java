package cn.qkl.webserver.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "qkl.framework")
public class CommonFrameworkProperties {
    private String apiPrefix = "/api";

    public String getApiPrefix() {
        if (this.apiPrefix.startsWith("/")) {
            return apiPrefix;
        }
//        return "/" + apiPrefix;
        return "";
    }
}
