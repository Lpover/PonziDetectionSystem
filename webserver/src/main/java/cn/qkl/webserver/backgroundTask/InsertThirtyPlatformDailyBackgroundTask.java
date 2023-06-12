package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.PlatformDailyStatistics;
import cn.qkl.webserver.dao.PlatformDailyStatisticsDao;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.service.PlatformViewService;
import cn.qkl.webserver.service.RiskNumViewService;
import cn.qkl.webserver.service.RiskTxViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cn.qkl.common.repository.model.Platform;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class InsertThirtyPlatformDailyBackgroundTask implements BackgroundTask {
    @Autowired
    private PlatformDailyStatisticsDao platformDailyStatisticsDao;

    @Autowired
    private PlatformDao platformDao;

    @Autowired
    private RiskTxViewService riskTxViewService;

    @Autowired
    private RiskNumViewService riskNumViewService;

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
        end = DateUtil.offsetDay(end, 1);

        //延迟至第二天凌晨2点开始执行
        return end.getTime() - start.getTime();
//        return 0;
    }

    @Override
    public String getName() {
        return PlatformDailyStatisticsInsertBackgroundTask.class.getName();
    }
    @Override
    public void run(){
        log.debug("模拟插入30天platform_daily_statistics表数据");
        List<PlatformDailyStatistics> list = new ArrayList<>();
        // 只获取正在监测的平台id
        List<Long> platformIDList= platformDao.select(c -> c.where(Tables.platform.monitor, isEqualTo(1))).stream().map(Platform::getId).collect(Collectors.toList());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date last = null;
        try {
            last = sdf.parse("2023-06-19 00:00:00");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date start = DateUtil.offsetDay(last, -40);
        for (int delta = 0; delta <= 40; delta++) {
            start = DateUtil.offsetDay(start, 1);
            for (Long platformID : platformIDList) {
                // 不同表需要修改字段插入
                PlatformDailyStatistics platformDailyStatistics = new PlatformDailyStatistics();
                platformDailyStatistics.setId(IdUtil.getSnowflakeNextId());
                platformDailyStatistics.setPlatformId(platformID);
                riskTxViewService.insertRiskTx(platformDailyStatistics);    //风险交易
                riskNumViewService.insertRiskNum(platformDailyStatistics);  //风险内容
                platformViewService.insertPlatformView(platformDailyStatistics);//热门平台每日数据更新
                platformDailyStatistics.setCreateTime(start);
                platformDailyStatistics.setUpdateTime(start);
                list.add(platformDailyStatistics);
            }
        }

        platformDailyStatisticsDao.insertMultiple(list);
    }

}
