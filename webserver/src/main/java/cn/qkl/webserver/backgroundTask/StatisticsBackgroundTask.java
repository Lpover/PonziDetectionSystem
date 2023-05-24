package cn.qkl.webserver.backgroundTask;

import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/11/3 15:00
 * @wiki
 */
@Slf4j
@Component
public class StatisticsBackgroundTask implements BackgroundTask {


    /**
     * 间隔1天
     */
    @Override
    public long getPeriod() {
        return 24 * 60 * 60 * 1000;
    }

    //每天凌晨1点执行
    @Override
    public long getDelay() {
        //当前时间
        Calendar now = Calendar.getInstance();
        //凌晨十二点
        Calendar midnight = Calendar.getInstance();
        midnight.set(Calendar.HOUR_OF_DAY, 1);
        midnight.set(Calendar.MINUTE, 0);
        midnight.add(Calendar.DATE, 1);
        return midnight.getTime().getTime() - now.getTime().getTime();
    }

    @Override
    public String getName() {
        return StatisticsBackgroundTask.class.getName();
    }

    @Override
    public void run() {
        log.debug("刷新用户兑换次数");
        //业务代码
        //xxx
    }
}
