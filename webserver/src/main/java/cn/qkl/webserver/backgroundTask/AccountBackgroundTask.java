package cn.qkl.webserver.backgroundTask;

import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.webserver.service.AccountCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * @title:
 * @Author sunxiaen
 * @Date: 2023/5/25 15:00
 * @wiki
 */
@Slf4j
@Component
public class AccountBackgroundTask implements BackgroundTask {

    @Resource
    AccountCheckService accountCheckService;

    /**
     * 间隔1小时
     */
    @Override
    public long getPeriod() {
        return 1 * 60 * 60 * 1000;
    }

    //每天18点执行
    @Override
    public long getDelay() {
        //当前时间
        Calendar now = Calendar.getInstance();
        Calendar midnight = Calendar.getInstance();
        midnight.set(Calendar.HOUR_OF_DAY, 18);
        midnight.set(Calendar.MINUTE, 0);
        midnight.add(Calendar.DATE, 1);
        return midnight.getTime().getTime() - now.getTime().getTime();
    }

    @Override
    public String getName() {
        return ContentCrossInsertBackgroundTask.class.getName();
    }

    @Override
    public void run() {
        log.debug("check account risk");
        //业务代码

    }
}
