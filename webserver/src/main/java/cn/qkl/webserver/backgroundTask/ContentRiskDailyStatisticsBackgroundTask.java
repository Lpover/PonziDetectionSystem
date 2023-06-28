package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.ContentRisk;
import cn.qkl.common.repository.model.ContentRiskDailyStatistics;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.webserver.dao.ContentRiskDao;
import cn.qkl.webserver.dao.ContentRiskStatisticsDao;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.service.WordCloudViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * @param
 * @return
 */
@Slf4j
@Component
public class ContentRiskDailyStatisticsBackgroundTask implements BackgroundTask {
    @Autowired
    private ContentRiskDao contentRiskDao;

    @Autowired
    private ContentRiskStatisticsDao contentRiskStatisticsDao;

    @Autowired
    private PlatformDao platformDao;

    @Autowired
    private WordCloudViewService wordCloudViewService;

    @Override
    public long getPeriod() {
        return 24 * 60 * 60 * 1000;
    }

    //从第二天开始每天凌晨1点执行
    @Override
    public long getDelay() {
        //当前服务器时间
        Date start = new Date();
        //一天的结束，结果：00:00:00
        Date end = DateUtil.beginOfDay(start);
        //当天1：00：00
        end = DateUtil.offsetHour(end, 1);
        //第二天1：00：00
        end = DateUtil.offsetDay(end, 1);

        //延迟至第二天凌晨1点开始执行
        return end.getTime() - start.getTime();
//        return 0;
    }

    @Override
    public String getName() {
        return ContentRiskDailyStatisticsBackgroundTask.class.getName();
    }

    @Override
    public void run() {
        log.debug("添加content_risk_daily_statistics表数据");
        List<ContentRiskDailyStatistics> list = new ArrayList<>();
        Date end = new Date();
        List<Long> categoryIDList = contentRiskDao.select(c->c).stream().map(ContentRisk::getId).collect(Collectors.toList());
        // 只获取正在监测的平台id
        List<Long> platformIDList= platformDao.select(c -> c.where(Tables.platform.monitor, isEqualTo(1))).stream().map(Platform::getId).collect(Collectors.toList());
        for (Long categoryID : categoryIDList)
            for (Long platformID : platformIDList) {
                ContentRiskDailyStatistics contentRiskDailyStatistics = new ContentRiskDailyStatistics();
                wordCloudViewService.insertWordNum(contentRiskDailyStatistics, categoryID, platformID);
                contentRiskDailyStatistics.setCreateTime(end);
                contentRiskDailyStatistics.setUpdateTime(end);
                list.add(contentRiskDailyStatistics);
            }

        contentRiskStatisticsDao.insertMultiple(list);
    }
}
