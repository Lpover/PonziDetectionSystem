package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.common.repository.model.PlatformDailyStatistics;
import cn.qkl.webserver.dao.PlatformDailyStatisticsDao;
import cn.qkl.webserver.service.PlatformViewService;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.service.RiskCategoryTrendService;
import cn.qkl.webserver.service.RiskNumViewService;
import cn.qkl.webserver.service.RiskTxViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/11/3 15:00
 * @wiki
 */
@Slf4j
@Component
public class PlatformDailyStatisticsInsertBackgroundTask implements BackgroundTask {

    @Autowired
    private PlatformDailyStatisticsDao platformDailyStatisticsDao;

    @Autowired
    private RiskCategoryTrendService riskCategoryTrendService;

    @Autowired
    private PlatformViewService platformViewService;

    @Autowired
    private PlatformDao platformDao;

    @Autowired
    private RiskTxViewService riskTxViewService;

    @Autowired
    private RiskNumViewService riskNumViewService;

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
        return ContentCrossStatisticsInsertBackgroundTask.class.getName();
    }

    @Override
    public void run() {
        log.debug("模拟插入platform_daily_statistics表数据");
        List<PlatformDailyStatistics> list = new ArrayList<>();

        List<Long> platformIDList= platformDao.select(c -> c).stream().map(Platform::getId).collect(Collectors.toList());
        //每天 每个平台插入一条数据
        for (Long platformId : platformIDList) {
            PlatformDailyStatistics platformDailyStatistics = new PlatformDailyStatistics();
            insertCommon(platformDailyStatistics, platformId);

            riskTxViewService.InsertRiskTx(platformDailyStatistics);
            riskNumViewService.InsertRiskNum(platformDailyStatistics);
            //
            //

            //高中低风险内容处理
            platformDailyStatistics=riskCategoryTrendService.insertRiskNum(platformDailyStatistics);
            //当天监控到的数字内容总数
            platformDailyStatistics=riskCategoryTrendService.insertRiskContentSum(platformDailyStatistics);
            //当天监控到的风险数字内容总数
            platformDailyStatistics=riskCategoryTrendService.insertContentSum(platformDailyStatistics);
            list.add(platformDailyStatistics);
        }

        platformDailyStatisticsDao.insertMultiple(list);
    }

    private void insertCommon(PlatformDailyStatistics platformDailyStatistics, Long platformID){
        Date end = new Date();
        platformDailyStatistics.setId(IdUtil.getSnowflakeNextId());
        platformDailyStatistics.setPlatformId(platformID);
        platformDailyStatistics.setCreateTime(end);
        platformDailyStatistics.setUpdateTime(end);
    }

}
