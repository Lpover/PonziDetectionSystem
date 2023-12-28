package cn.qkl.webserver.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

/**
 * @Author sunxiaen
 * @Date 2023/12/19 14:43
 **/
@Configuration
public class ObjectMapperConfig {
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
