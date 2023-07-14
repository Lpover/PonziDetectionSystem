package cn.qkl.webserver.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.qkl.common.repository.model.RiskReport;
import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.dao.ContentRiskStatisticsDao;
import cn.qkl.webserver.dao.PlatformDailyStatisticsDao;
import cn.qkl.webserver.dao.RiskReportDao;
import cn.qkl.webserver.dto.riskreport.RiskReportListQueryDTO;
import cn.qkl.webserver.dto.riskreport.SituationReportDTO;
import cn.qkl.webserver.vo.contentRiskStatictics.RiskCategoryVO;
import cn.qkl.webserver.vo.platformview.IndexTrendsVO;
import cn.qkl.webserver.vo.riskContentStatictics.PlatformReportVO;
import cn.qkl.webserver.vo.riskReport.RiskReportInfoVO;
import cn.qkl.webserver.vo.riskReport.SituationInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SimpleSortSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @title:
 * @Author lpc
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class RiskReportService {

    @Autowired
    private RiskReportDao reportDao;

    @Autowired
    private ContentRiskStatisticsDao contentRiskStatisticsDao;

    @Autowired
    private PlatformDailyStatisticsDao riskContentStatisticsDao;


    //报表信息
    public RiskReportInfoVO getRiskReportInfo(RiskReportListQueryDTO dto) {
        RiskReport riskReport = reportDao.selectOne(c -> c
                .orderBy(Tables.riskReport.createTime.descending())
                .limit(1)
        ).get();
        //当前服务器时间
        Date end = new Date();
        end = DateUtil.endOfDay(end);
        //昨天,设定的是7天以前，以免没有数据
        DateTime start =  DateUtil.offsetDay(end, -1);
        //每日标签新增
        List<RiskCategoryVO> riskContentStatistics = contentRiskStatisticsDao.getContentRiskStatistic(
                select(Tables.contentRisk.category.as("riskName"), Tables.contentRisk.num.as("riskNum"))
                        .from(Tables.contentRisk)
                        .orderBy(SimpleSortSpecification.of("riskNum").descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        //每日平台新增
        List<PlatformReportVO> contentRiskStatistics =riskContentStatisticsDao.getPlatformReport(
                select(Tables.platformDailyStatistics.contentSum,Tables.platform.name.as("platformName"))
                        .from(Tables.platformDailyStatistics)
                        .leftJoin(Tables.platform).on(Tables.platformDailyStatistics.platformId,equalTo(Tables.platform.id))
                        .where(Tables.platformDailyStatistics.createTime, isGreaterThanOrEqualToWhenPresent(start))
                        .and(Tables.platformDailyStatistics.createTime, isLessThanOrEqualToWhenPresent(end))
                        .orderBy(Tables.platformDailyStatistics.contentSum.descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return RiskReportInfoVO.transform(riskReport,riskContentStatistics,contentRiskStatistics);
    }

    public SituationInfoVO getSituationInfo(SituationReportDTO dto){
        SituationInfoVO SituationInfo = reportDao.getSituationInfo(
                select(Tables.situationReport.platformName,Tables.situationReport.carrierPic,
                        Tables.situationReport.carrierVie,Tables.situationReport.carrierOth,Tables.situationReport.categoryDyn,Tables.situationReport.categoryOth,
                        Tables.situationReport.categorySta,Tables.situationReport.txRatioLow,Tables.situationReport.txRatioMid,Tables.situationReport.txRatioHigh,
                        Tables.situationReport.riskWordMostName,Tables.situationReport.riskWordMostNum,Tables.situationReport.riskWordLeastName,Tables.situationReport.riskWordLeastNum,
                        Tables.situationReport.contentNumRatio,Tables.situationReport.ratioPositive,Tables.situationReport.ratioNegative,Tables.situationReport.platNameLow,
                        Tables.situationReport.platNameMid,Tables.situationReport.platNameHigh,Tables.situationReport.warningNum,Tables.situationReport.top5TopicsContent,
                        Tables.situationReport.top5TopicsSocial,Tables.situationReport.top3Words,Tables.situationReport.monitorNumHigh,Tables.situationReport.monitorNumLow,
                        Tables.situationReport.monitorNumHigh,Tables.situationReport.monitorNumMid,Tables.situationReport.monitorNumLow,Tables.situationReport.platRatioLow,
                        Tables.situationReport.platRatioMid,Tables.situationReport.platRatioLow,Tables.situationReport.platRatioHigh,Tables.situationReport.nftPlatformName,
                        Tables.situationReport.nftPlatformHotness,Tables.situationReport.nftPlatformHotnessChange,Tables.situationReport.web3PlatformHotness,
                        Tables.situationReport.web3PlatformHotnessChange,Tables.situationReport.web3PlatformName,Tables.situationReport.riskNameHigh,
                        Tables.situationReport.riskNameLow,Tables.situationReport.riskIndexLow,Tables.situationReport.riskIndexHigh)
                        .from(Tables.situationReport)
                        .limit(1)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return SituationInfo;
    }


}
