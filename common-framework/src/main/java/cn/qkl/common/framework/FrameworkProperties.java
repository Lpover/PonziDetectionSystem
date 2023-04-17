package cn.qkl.common.framework;

import cn.qkl.common.framework.response.BaseResult;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "qkl.framework")
public class FrameworkProperties implements InitializingBean {
    private boolean showExceptionDetail = false;

    @Override
    public void afterPropertiesSet() {
        BaseResult.isShowExceptionDetail = this.showExceptionDetail;
        log.info("{}", this);
    }

}
