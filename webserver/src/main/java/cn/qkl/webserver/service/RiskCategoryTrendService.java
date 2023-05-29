package cn.qkl.webserver.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.dao.RiskContentStatisticsDao;
import cn.qkl.webserver.vo.riskcontentstatistics.RiskContentStatisticDataVO;
import cn.qkl.webserver.vo.riskcontentstatistics.RiskContentStatisticsVO;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
//@Slf4j
@RefreshScope

public class RiskCategoryTrendService  {
    @Autowired
    private RiskContentStatisticsDao riskDao;
    /**
     * 获取风险走势图
     * @return
     */
    public RiskContentStatisticsVO getRiskTrend() {
        //当前服务器时间
        Date end = new Date();
        //全部
        end = DateUtil.beginOfDay(end);
        DateTime start = DateUtil.offsetDay(end, -7);
        List<RiskContentStatisticDataVO> risks = riskDao.getRiskContentStatistics(
                select(sum(Tables.riskContentStatistics.lowRiskNum).as("lowRiskNumber"),
                        sum(Tables.riskContentStatistics.middleRiskNum).as("middleRiskNumber"),
                        sum(Tables.riskContentStatistics.highRiskNum).as("highRiskNumber")
                        )
                        .from(Tables.riskContentStatistics)
                        .where(Tables.platform.updateTime, isGreaterThanOrEqualToWhenPresent(start))
                        .and(Tables.platform.updateTime, isLessThanOrEqualToWhenPresent(end))
                        .groupBy(Tables.riskContentStatistics.updateTime)
                        .orderBy(Tables.riskContentStatistics.updateTime)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return RiskContentStatisticsVO.transform(risks);
    }
}
