package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.EvidenceOverviewDailyStatistics;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.webserver.dao.EvidenceOverviewDailyStatisticsDao;
import cn.qkl.webserver.dao.EvidenceWebDao;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.dto.evidence.StatisticsEvidenceDTO;
import cn.qkl.webserver.vo.evidence.StatisticsEvidenceVO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @param
 * @return
 */
@Service
@Slf4j
@RefreshScope
public class EvidenceDailyStatisticsService {
    @Autowired
    EvidenceOverviewDailyStatisticsDao evidenceOverviewDailyStatisticsDao;

    @Autowired
    EvidenceWebDao evidenceWebDao;

    public StatisticsEvidenceVO getEvidenceStatistics(StatisticsEvidenceDTO dto) {
        StatisticsEvidenceVO vo = new StatisticsEvidenceVO();
        SelectStatementProvider selectStatementProvider;
        // todo: 需要考虑平台是否监测中
        if (dto.getPlatformType() == 0) {   //全部平台
            selectStatementProvider = select(Tables.platform.name.as("platformName"),
                    sum(Tables.evidenceOverviewDailyStatistics.webEvidenceCount).as("webNum"),
                    sum(Tables.evidenceOverviewDailyStatistics.mobileEvidenceCount).as("mobileNum"),
                    sum(Tables.evidenceOverviewDailyStatistics.reinforceEvidenceCount).as("reinforceNum"))
                    .from(Tables.evidenceOverviewDailyStatistics)
                    .leftJoin(Tables.platform).on(Tables.platform.id, equalTo(Tables.evidenceOverviewDailyStatistics.platformId))
                    .groupBy(Tables.evidenceOverviewDailyStatistics.platformId)
                    .build()
                    .render(RenderingStrategies.MYBATIS3);
        } else {    // nft或web3平台
            selectStatementProvider = select(Tables.platform.name.as("platformName"),
                    sum(Tables.evidenceOverviewDailyStatistics.webEvidenceCount).as("webNum"),
                    sum(Tables.evidenceOverviewDailyStatistics.mobileEvidenceCount).as("mobileNum"),
                    sum(Tables.evidenceOverviewDailyStatistics.reinforceEvidenceCount).as("reinforceNum"))
                    .from(Tables.evidenceOverviewDailyStatistics)
                    .leftJoin(Tables.platform).on(Tables.platform.id, equalTo(Tables.evidenceOverviewDailyStatistics.platformId))
                    .where(Tables.platform.platformType, isEqualTo(dto.getPlatformType() - 1))
                    .groupBy(Tables.evidenceOverviewDailyStatistics.platformId)
                    .build()
                    .render(RenderingStrategies.MYBATIS3);
        }

        List<StatisticsEvidenceVO.PlatformView> platformViewList = evidenceOverviewDailyStatisticsDao.getPlatformView(selectStatementProvider);


        Date date = new Date();
        Date end = DateUtil.endOfDay(date);
        Date start = DateUtil.offsetDay(end, -7);   //默认近7天
        if (dto.getTimeSpan() == 0) {   // 近7天
            start = DateUtil.offsetDay(end, -7);
        } else if (dto.getTimeSpan() == 1) {    // 近30天
            start = DateUtil.offsetDay(end, -30);
        }
        Date finalStart = start;

        List<StatisticsEvidenceVO.TimeView> timeView = evidenceOverviewDailyStatisticsDao.getTimeView(
                select(sum(Tables.evidenceOverviewDailyStatistics.webEvidenceCount).as("webNum"),
                        sum(Tables.evidenceOverviewDailyStatistics.mobileEvidenceCount).as("mobileNum"),
                        sum(Tables.evidenceOverviewDailyStatistics.reinforceEvidenceCount).as("reinforceNum")
                        )
                .from(Tables.evidenceOverviewDailyStatistics)
                .where(Tables.evidenceOverviewDailyStatistics.createTime, isGreaterThanOrEqualToWhenPresent(finalStart))
                .and(Tables.evidenceOverviewDailyStatistics.createTime, isLessThanOrEqualToWhenPresent(end))
                .groupBy(Tables.evidenceOverviewDailyStatistics.createTime)
                .orderBy(Tables.evidenceOverviewDailyStatistics.createTime)
                .build()
                .render(RenderingStrategies.MYBATIS3)
                );

        for (StatisticsEvidenceVO.TimeView item : timeView) {
            item.setDate(finalStart);
            finalStart = DateUtil.offsetDay(finalStart, 1);
        }

        // 统计未删除的数据
        List<Record> res = evidenceWebDao.getReinforceView(
                select(Tables.evidenceWeb.evidenceType, count().as("count"))
                        .from(Tables.evidenceWeb)
                        .where(Tables.evidenceWeb.deleteStatus, isNotEqualTo(1))
                        .and(Tables.evidenceWeb.evidenceType, isNotNull())
                        .groupBy(Tables.evidenceWeb.evidenceType)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );

        StatisticsEvidenceVO.ReinforceView reinforceView = new StatisticsEvidenceVO.ReinforceView();
        reinforceView.setContentMonitorNum(0);
        reinforceView.setReinforceNum(0);
        reinforceView.setWebNum(0);

        for (Record item : res) {
            System.out.println("======" + item.toString());
            if (item.getEvidenceType() == 0) {
                reinforceView.setWebNum(item.getCount());
            } else if (item.getEvidenceType() == 2) {
                reinforceView.setReinforceNum(item.getCount());
            } else if (item.getEvidenceType() == 3) {
                reinforceView.setContentMonitorNum(item.getCount());
            } else {
                log.info(item.toString());
            }
        }

        vo.setPlatformView(platformViewList);
        vo.setTimeView(timeView);
        vo.setReinforceView(reinforceView);
        return vo;
    }

    @Data
    public static class Record {
        private Integer evidenceType;
        private Integer count;
    }

    @Autowired
    private PlatformDao platformDao;

    // 一次性插入EvidenceOverviewDailyStatistics数据
    public void insertDaily() {
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.withHour(0).withMinute(0).withSecond(0);
        Date end = java.sql.Timestamp.valueOf(dateTime);
        Integer before = 40;
        List<EvidenceOverviewDailyStatistics> list = new ArrayList<>();
        Date start = DateUtil.offsetDay(end, -before);
        // 只获取正在监测的平台id
        List<Long> platformIDList= platformDao.select(c -> c.where(Tables.platform.monitor, isEqualTo(1))).stream().map(Platform::getId).collect(Collectors.toList());
        //每天 每个平台插入一条数据
        Random random = new Random();
        for (int i = 0; i < before; i++) {
            for (Long platformId : platformIDList) {
                EvidenceOverviewDailyStatistics evidenceOverviewDailyStatistics = new EvidenceOverviewDailyStatistics();
                evidenceOverviewDailyStatistics.setId(IdUtil.getSnowflakeNextId());
                evidenceOverviewDailyStatistics.setPlatformId(platformId);
                evidenceOverviewDailyStatistics.setCreateTime(start);
                evidenceOverviewDailyStatistics.setUpdateTime(start);
                evidenceOverviewDailyStatistics.setWebEvidenceCount(random.nextInt(100));
                evidenceOverviewDailyStatistics.setReinforceEvidenceCount(random.nextInt(100));
                evidenceOverviewDailyStatistics.setMobileEvidenceCount(random.nextInt(100));
                list.add(evidenceOverviewDailyStatistics);
            }
            start = DateUtil.offsetDay(start, 1);
        }
        evidenceOverviewDailyStatisticsDao.insertMultiple(list);
    }

}
