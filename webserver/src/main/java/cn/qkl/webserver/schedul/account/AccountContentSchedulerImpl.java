package cn.qkl.webserver.schedul.account;

import cn.qkl.webserver.schedul.SchedulerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @Author sunxiaen
 * @Date 16:21 2023/5/24
 * @Description 业务定时器 AccountContentSchedulerImpl
 **/
@Component("AccountContentSchedulerImpl")
@Slf4j
public class AccountContentSchedulerImpl extends SchedulerImpl implements DisposableBean {
    public AccountContentSchedulerImpl(int threads, String threadNamePrefix, boolean daemon) {
        super(threads, threadNamePrefix, daemon);
    }

    public AccountContentSchedulerImpl(int threads) {
        super(threads);
    }
    public AccountContentSchedulerImpl() {
        super(1);
    }

    @Override
    public void destroy() throws Exception {
        if (this.isStarted()) {
            this.shutdown();
        }
        log.info("AccountContentSchedulerImpl Destroy!");
    }
}
