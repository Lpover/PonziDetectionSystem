package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.RiskContentStatisticsMapper;
import cn.qkl.webserver.vo.contentRiskStatictics.RiskCategoryVO;
import cn.qkl.webserver.vo.riskAccount.AccountNumVO;
import cn.qkl.webserver.vo.riskContentStatictics.PlatformReportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import cn.qkl.common.repository.mapper.RiskContentStatisticsMapper;
import cn.qkl.webserver.vo.riskcontentstatistics.RiskContentStatisticsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

/**
 * @title:
 * @Author Wang Xin
 * @Date: 2022/7/23 17:37
 * @wiki
 */
@Mapper
public interface RiskContentStatisticsDao extends RiskContentStatisticsMapper {

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<PlatformReportVO> getPlatformReport(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<AccountNumVO> getAccountNum(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<RiskContentStatisticsVO> getRiskContentStatistics(SelectStatementProvider selectStatementProvider);
}
