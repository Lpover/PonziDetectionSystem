package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.AtaExportTaskMapper;
import cn.qkl.webserver.vo.riskAccount.ExportTaskVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

/**
 * @Author sunxiaen
 * @Date 17:48 2023/5/18
 **/
@Mapper
public interface AtaExportTaskDao extends AtaExportTaskMapper {

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<ExportTaskVO> getExportTask(SelectStatementProvider selectStatementProvider);


}
