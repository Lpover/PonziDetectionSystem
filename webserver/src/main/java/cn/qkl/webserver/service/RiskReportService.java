package cn.qkl.webserver.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.qkl.common.repository.model.RiskReport;
import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.dao.ContentRiskStatisticsDao;
import cn.qkl.webserver.dao.PlatformDailyStatisticsDao;
import cn.qkl.webserver.dao.RiskReportDao;
import cn.qkl.webserver.dto.riskreport.RiskReportListQueryDTO;
import cn.qkl.webserver.vo.contentRiskStatictics.RiskCategoryVO;
import cn.qkl.webserver.vo.riskContentStatictics.PlatformReportVO;
import cn.qkl.webserver.vo.riskReport.RiskReportInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SimpleSortSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isInWhenPresent;

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
        DateTime start =  DateUtil.offsetDay(end, -7);
        //每日标签新增
        List<RiskCategoryVO> riskContentStatistics = contentRiskStatisticsDao.getContentRiskStatistic(
                select(Tables.contentRisk.category.as("riskName"), Tables.contentRiskStatistics.num.as("riskNum"))
                        .from(Tables.contentRiskStatistics)
                        .leftJoin(Tables.contentRisk).on(Tables.contentRiskStatistics.categoryId, equalTo(Tables.contentRisk.id))
                        .where(Tables.contentRiskStatistics.createTime, isGreaterThanOrEqualToWhenPresent(start))
                        .and(Tables.contentRiskStatistics.createTime, isLessThanOrEqualToWhenPresent(end))
                        .orderBy(SimpleSortSpecification.of("riskNum").descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        //每日平台新增
        List<PlatformReportVO> contentRiskStatistics =riskContentStatisticsDao.getPlatformReport(
                select(Tables.platformDailyStatistics.contentSum,Tables.platform.name.as("platformName"))
                        .from(Tables.platformDailyStatistics)
                        .leftJoin(Tables.platform).on(Tables.platformDailyStatistics.platformId,equalTo(Tables.platform.id))
                        .orderBy(Tables.platformDailyStatistics.contentSum.descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return RiskReportInfoVO.transform(riskReport,riskContentStatistics,contentRiskStatistics);


    }

}
