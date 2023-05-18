package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.ContentCrossMapper;
import cn.qkl.webserver.vo.cross.CrossContentVO;
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
public interface ContentCrossDao extends ContentCrossMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
//    @Result(column = "complete_time", property = "completeTime", typeHandler = DateTypeHandler.class)
    List<CrossContentVO> getCrossContentList(SelectStatementProvider selectStatementProvider);
}
