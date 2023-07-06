package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.RiskReportMapper;
import cn.qkl.webserver.vo.platformview.IndexTrendsVO;
import cn.qkl.webserver.vo.riskReport.SituationInfoVO;
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
public interface RiskReportDao extends RiskReportMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    SituationInfoVO getSituationInfo(SelectStatementProvider selectStatementProvider);
}
