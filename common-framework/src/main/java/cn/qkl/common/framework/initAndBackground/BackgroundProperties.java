//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.qkl.common.framework.initAndBackground;

import javax.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated
@Configuration
@ConfigurationProperties(
    prefix = "base.framework.background"
)
public class BackgroundProperties implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(BackgroundProperties.class);
    private @Min(1L) int threadNum = 5;

    public void afterPropertiesSet() {
        log.info("{}", this);
    }

    public BackgroundProperties() {
    }

    public int getThreadNum() {
        return this.threadNum;
    }

    public void setThreadNum(final int threadNum) {
        this.threadNum = threadNum;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BackgroundProperties)) {
            return false;
        } else {
            BackgroundProperties other = (BackgroundProperties)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                return this.getThreadNum() == other.getThreadNum();
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BackgroundProperties;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getThreadNum();
        return result;
    }

    public String toString() {
        return "BackgroundProperties(threadNum=" + this.getThreadNum() + ")";
    }
}
