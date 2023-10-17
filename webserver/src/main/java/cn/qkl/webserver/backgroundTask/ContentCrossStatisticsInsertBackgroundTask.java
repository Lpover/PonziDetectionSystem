//package cn.qkl.webserver.backgroundTask;
//
//import cn.hutool.core.date.DateUtil;
//import cn.qkl.common.framework.initAndBackground.BackgroundTask;
//import cn.qkl.webserver.service.CrossContentDailyStatisticsService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * @title:
// * @Author wang xin
// * @Date: 2022/11/3 15:00
// * @wiki
// */
//@Slf4j
//@Component
//public class ContentCrossStatisticsInsertBackgroundTask implements BackgroundTask {
//
//    @Autowired
//    CrossContentDailyStatisticsService crossContentDailyStatisticsService;
//
//    /**
//     * 间隔1天
//     */
//    @Override
//    public long getPeriod() {
//        return 24 * 60 * 60 * 1000;
//    }
//
//    //从第二天开始每天凌晨1点执行
//    @Override
//    public long getDelay() {
//        //当前服务器时间
//        Date start = new Date();
//        //一天的结束，结果：00:00:00
//        Date end = DateUtil.beginOfDay(start);
//        //当天1：00：00
//        end = DateUtil.offsetHour(end, 1);
//        //第二天1：00：00
//        end = DateUtil.offsetDay(end, 1);
//
//        //延迟至第二天凌晨1点开始执行
//        return end.getTime() - start.getTime();
////        return 10*1000;
//    }
//
//    @Override
//    public String getName() {
//        return ContentCrossStatisticsInsertBackgroundTask.class.getName();
//    }
//
//    @Override
//    public void run() {
//        log.debug("处理content_corss表昨天24小时数据");
//        //处理content_corss表昨天24小时数据
//        crossContentDailyStatisticsService.insertContentCrossDailyStatistics();
//    }
//}
