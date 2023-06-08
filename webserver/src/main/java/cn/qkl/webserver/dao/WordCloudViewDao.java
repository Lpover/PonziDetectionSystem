package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.ContentRiskDailyStatisticsMapper;
import cn.qkl.webserver.vo.board.WordCloudViewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

@Mapper
public interface WordCloudViewDao extends ContentRiskDailyStatisticsMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<WordCloudViewVO> getWordNum(SelectStatementProvider selectStatementProvider);
}
