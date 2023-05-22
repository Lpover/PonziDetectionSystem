package cn.qkl.webserver.dao;

import cn.qkl.common.framework.util.mybatis.DateTypeHandler;
import cn.qkl.common.repository.mapper.ContentMapper;
import cn.qkl.webserver.vo.detail.ContentInfoVO;
import cn.qkl.webserver.vo.dynamic.DynamicContentExportVO;
import cn.qkl.webserver.vo.dynamic.DynamicContentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
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
public interface ContentDao extends ContentMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
//    @Result(column = "start_time", property = "startTime", jdbcType = JdbcType.DATE)
    @Result(column = "start_time", property = "startTime", typeHandler = DateTypeHandler.class)
//    @Result(column = "end_time", property = "endTime", jdbcType = JdbcType.TIMESTAMP)
    @Result(column = "end_time", property = "endTime", typeHandler = DateTypeHandler.class)
    List<DynamicContentVO> getDynamicContentList(SelectStatementProvider selectStatementProvider);


    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
//    @Result(column = "start_time", property = "startTime", jdbcType = JdbcType.DATE)
    @Result(column = "start_time", property = "startTime", typeHandler = DateTypeHandler.class)
//    @Result(column = "end_time", property = "endTime", jdbcType = JdbcType.TIMESTAMP)
    @Result(column = "end_time", property = "endTime", typeHandler = DateTypeHandler.class)
    List<DynamicContentExportVO> dynamicContentListExport(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
//    @Result(column = "start_time", property = "startTime", jdbcType = JdbcType.DATE)
    @Result(column = "start_time", property = "startTime", typeHandler = DateTypeHandler.class)
//    @Result(column = "end_time", property = "endTime", jdbcType = JdbcType.TIMESTAMP)
    @Result(column = "end_time", property = "endTime", typeHandler = DateTypeHandler.class)
    ContentInfoVO getContentDetail(SelectStatementProvider selectStatementProvider);
}
