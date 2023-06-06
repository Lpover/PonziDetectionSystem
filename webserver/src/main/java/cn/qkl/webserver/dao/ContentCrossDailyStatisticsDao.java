package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.ContentCrossDailyStatisticsMapper;
import cn.qkl.webserver.vo.board.CrossContentRiskViewVO;
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
public interface ContentCrossDailyStatisticsDao extends ContentCrossDailyStatisticsMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<CrossContentRiskViewVO> getCrossContentRiskView(SelectStatementProvider selectStatementProvider);
}
