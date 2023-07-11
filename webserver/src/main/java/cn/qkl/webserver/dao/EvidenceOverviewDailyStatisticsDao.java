package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.EvidenceOverviewDailyStatisticsMapper;
import cn.qkl.webserver.vo.evidence.StatisticsEvidenceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

@Mapper
public interface EvidenceOverviewDailyStatisticsDao extends EvidenceOverviewDailyStatisticsMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<StatisticsEvidenceVO.PlatformView> getPlatformView(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<StatisticsEvidenceVO.TimeView> getTimeView(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    StatisticsEvidenceVO.ReinforceView getReinforceView(SelectStatementProvider selectStatementProvider);
}
