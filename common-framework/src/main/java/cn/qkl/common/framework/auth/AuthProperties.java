package cn.qkl.common.framework.auth;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

@Data
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "qkl.framework.auth")
public class AuthProperties implements InitializingBean {
    public static final TimeUnit TIME_UNIT = TimeUnit.DAYS;
    // token到期时间，默认一天
    private long expiration = 1L;
    // token名称
    private String header = "token";
    // token密钥，如果没有配置的话，使用随机生成的默认值
    private String secret = String.format("%09d", new SecureRandom().nextInt(1000000000));

    @Override
    public void afterPropertiesSet() {
        log.info("{}", this);
    }
}
