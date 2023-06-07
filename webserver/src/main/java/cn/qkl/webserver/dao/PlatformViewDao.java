package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.PlatformDailyStatisticsMapper;
import cn.qkl.common.repository.mapper.PlatformMapper;
import cn.qkl.webserver.vo.contentRiskStatictics.RiskCategoryVO;
import cn.qkl.webserver.vo.platform.PlatformContentVO;
import cn.qkl.webserver.vo.platformview.IndexTrendsVO;
import cn.qkl.webserver.vo.platformview.PlatformRiskAccountVO;
import cn.qkl.webserver.vo.platformview.VolumeTrendsVO;
import cn.qkl.webserver.vo.riskAccount.AccountNumVO;
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
public interface PlatformViewDao extends PlatformDailyStatisticsMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<VolumeTrendsVO> getVolumeTrends(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<IndexTrendsVO>  getIndexTrends(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<PlatformRiskAccountVO>  getPlatformRiskAccount(SelectStatementProvider selectStatementProvider);
}
