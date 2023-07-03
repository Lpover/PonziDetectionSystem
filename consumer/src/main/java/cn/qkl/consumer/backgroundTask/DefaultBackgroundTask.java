package cn.qkl.consumer.backgroundTask;

import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import org.springframework.stereotype.Component;

/**
 * @Author sunxiaen
 * @Date 2023/6/28 18:04
 **/
@Component
public class DefaultBackgroundTask implements BackgroundTask {
    @Override
    public long getPeriod() {
        return 1*60*60*1000L;
    }

    @Override
    public long getDelay() {
        return 0;
    }

    @Override
    public String getName() {
        return "Default";
    }

    @Override
    public void run() {

    }
}
