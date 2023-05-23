package cn.qkl.webserver.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.mapper.RiskContentStatisticsMapper;
import cn.qkl.common.repository.model.Algorithm;
import cn.qkl.webserver.common.enums.PlatformTypeEnum;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.dao.RiskContentStatisticsDao;
import cn.qkl.webserver.dto.algorithm.AlgorithmListQueryDTO;
import cn.qkl.webserver.dto.platform.PopularPlatformQueryDTO;
import cn.qkl.webserver.vo.algorithm.AlgorithmVO;
import cn.qkl.webserver.vo.platform.PlatformContentVO;
import cn.qkl.webserver.vo.riskcontentstatistics.RiskContentStatisticsVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.SortSpecification;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.constant;

@Service
@Slf4j
@RefreshScope

public class RiskCategoryTrendService  {
    @Autowired
    private RiskContentStatisticsDao riskDao;
    /**
     * 获取风险走势图
     * @return
     */
    public List<RiskContentStatisticsVO> getPopularPlatform() {
        //当前服务器时间
        Date end = new Date();
        //全部
        DateTime start = DateUtil.offsetDay(end, -7);
        List<RiskContentStatisticsVO> risks = riskDao.getRiskContentStatistics(
                select(Tables.riskContentStatistics.id, sum(Tables.riskContentStatistics.lowRiskNum), sum(Tables.riskContentStatistics.middleRiskNum), sum(Tables.riskContentStatistics.highRiskNum), Tables.riskContentStatistics.updateTime)
                        .from(Tables.riskContentStatistics)
                        .groupBy(Tables.riskContentStatistics.updateTime)
                        .orderBy(Tables.riskContentStatistics.updateTime)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return risks;
    }
}
