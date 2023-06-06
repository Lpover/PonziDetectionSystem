package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.common.repository.model.PlatformDailyStatistics;
import cn.qkl.webserver.dao.PlatformDailyStatisticsDao;
import cn.qkl.webserver.service.CrossContentService;
import cn.qkl.webserver.service.PlatformViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/11/3 15:00
 * @wiki
 */
@Slf4j
@Component
public class PlatformDairyStatisticsInsertBackgroundTask implements BackgroundTask {

    @Autowired
    private PlatformDailyStatisticsDao platformDailyStatisticsDao;
    @Autowired
    private PlatformViewService platformViewService;
    @Override
    public long getPeriod() {
        return 24 * 60 * 60 * 1000;
    }

    //从第二天开始每天凌晨2点执行
    @Override
    public long getDelay() {
        //当前服务器时间
        Date start = new Date();
        //一天的结束，结果：00:00:00
        Date end = DateUtil.beginOfDay(start);
        //当天2：00：00
        end = DateUtil.offsetHour(end, 2);
        //第二天1：00：00
        end = DateUtil.offsetDay(end, 2);

        //延迟至第二天凌晨2点开始执行
        return end.getTime() - start.getTime();
    }

    @Override
    public String getName() {
        return ContentCrossStatisticsInsertBackgroundTask.class.getName();
    }

    @Override
    public void run() {
        log.debug("模拟插入content_corss表数据");
        //每天插入十条数据
        PlatformDailyStatistics platformDailyStatistics = new PlatformDailyStatistics();
        platformDailyStatistics.setId(IdUtil.getSnowflakeNextId());

        //平台风险数量处理
//        platformDailyStatistics = PlatformViewService.class.getName();
        //风险账号处理
//        platformDailyStatistics = acount(platformDailyStatistics);
        //风险内容处理
//        platformDailyStatistics = riks(platformDailyStatistics);

        //风险内容处理
        platformDailyStatisticsDao.insert(platformDailyStatistics);
    }
}
