package cn.qkl.common.framework.async;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author sunxiaen
 * @Date 2023/6/12 15:03
 **/
@Configuration
@Data
@ConfigurationProperties(prefix = "qkl.framework.thread.pool.executor")
@Slf4j
public class AsyncProperties implements InitializingBean {
    private Integer corePoolSize;
    private Integer maxPoolSize;
    private Integer queueCapacity;
    private Integer keppAliveSeconds;
    private String prefixName;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("{}",this);
    }
}


