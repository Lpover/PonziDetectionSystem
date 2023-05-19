package cn.qkl.webserver.dao;

import cn.qkl.common.framework.util.mybatis.DateTypeHandler;
import cn.qkl.common.repository.mapper.RiskContentStatisticsMapper;
import cn.qkl.webserver.vo.platform.PlatformContentVO;
import cn.qkl.webserver.vo.platform.PlatformListVO;
import cn.qkl.webserver.vo.riskcontentstatistics.RiskContentStatisticsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

/**
 * @title:
 * @Author ly yang
 * @Date: 2022/7/23 17:37
 * @wiki
 */

@Mapper

public interface RiskContentStatisticsDao extends RiskContentStatisticsMapper {

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
//    @Result(column = "start_time", property = "startTime", jdbcType = JdbcType.DATE)
    @Result(column = "start_time", property = "startTime", typeHandler = DateTypeHandler.class)
//    @Result(column = "end_time", property = "endTime", jdbcType = JdbcType.TIMESTAMP)
    @Result(column = "end_time", property = "endTime", typeHandler = DateTypeHandler.class)
    List<RiskContentStatisticsVO> getRiskContentStatistics(SelectStatementProvider selectStatementProvider);
}
