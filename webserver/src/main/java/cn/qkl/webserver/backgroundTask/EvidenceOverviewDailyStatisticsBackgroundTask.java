package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.EvidenceOverviewDailyStatistics;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.webserver.dao.EvidenceOverviewDailyStatisticsDao;
import cn.qkl.webserver.dao.PlatformDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/11/3 15:00
 * @wiki
 */
@Slf4j
@Component
public class EvidenceOverviewDailyStatisticsBackgroundTask implements BackgroundTask {

    @Autowired
    private PlatformDao platformDao;

    @Autowired
    private EvidenceOverviewDailyStatisticsDao evidenceOverviewDailyStatisticsDao;

    /**
     * 间隔1天
     */
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
        end = DateUtil.offsetDay(end, 1);

        //延迟至第二天凌晨2点开始执行
        return end.getTime() - start.getTime();
//        return 0;
    }

    @Override
    public String getName() {
        return EvidenceOverviewDailyStatisticsBackgroundTask.class.getName();
    }

    // todo 添加每日任务
    @Override
    public void run() {
        log.debug("模拟插入evidence_overview_daily_statistics表数据");
        List<EvidenceOverviewDailyStatistics> list = new ArrayList<>();
        // 只获取正在监测的平台id
        List<Long> platformIDList= platformDao.select(c -> c.where(Tables.platform.monitor, isEqualTo(1))).stream().map(Platform::getId).collect(Collectors.toList());
        //每天 每个平台插入一条数据
        for (Long platformId : platformIDList) {
            EvidenceOverviewDailyStatistics evidenceOverviewDailyStatistics = new EvidenceOverviewDailyStatistics();
            insertCommon(evidenceOverviewDailyStatistics, platformId);
            Random random = new Random();
            evidenceOverviewDailyStatistics.setWebEvidenceCount(random.nextInt(1000));
            evidenceOverviewDailyStatistics.setMobileEvidenceCount(random.nextInt(1000));
            evidenceOverviewDailyStatistics.setReinforceEvidenceCount(random.nextInt(1000));
            list.add(evidenceOverviewDailyStatistics);
        }

        evidenceOverviewDailyStatisticsDao.insertMultiple(list);
    }

    private void insertCommon(EvidenceOverviewDailyStatistics evidenceOverviewDailyStatistics, Long platformID){
        Date end = new Date();
        evidenceOverviewDailyStatistics.setId(IdUtil.getSnowflakeNextId());
        evidenceOverviewDailyStatistics.setPlatformId(platformID);
        evidenceOverviewDailyStatistics.setCreateTime(end);
        evidenceOverviewDailyStatistics.setUpdateTime(end);
    }

}
