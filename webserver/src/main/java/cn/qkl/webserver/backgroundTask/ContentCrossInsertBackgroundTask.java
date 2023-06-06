package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.webserver.service.CrossContentService;
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
public class ContentCrossInsertBackgroundTask implements BackgroundTask {


    @Autowired
    CrossContentService crossContentService;

    /**
     * 间隔1天
     */
    @Override
    public long getPeriod() {
        return 24 * 60 * 60 * 1000;
    }

    //每天23点执行
    @Override
    public long getDelay() {
        //当前服务器时间
        Date start = new Date();
        //一天的结束，结果：23:59:59
        Date end = DateUtil.endOfDay(start);
        //当天22：59：59
        end = DateUtil.offsetHour(end, -1);

        //延迟23点开始执行
        return end.getTime() - start.getTime();
    }

    @Override
    public String getName() {
        return ContentCrossInsertBackgroundTask.class.getName();
    }

    @Override
    public void run() {
        log.debug("模拟插入content_corss表数据");
        //每天插入十条数据
        crossContentService.insertContentCross(10);
    }
}
