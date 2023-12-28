package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.OperationLogMapper;
import cn.qkl.webserver.vo.log.LoginLogVO;
import cn.qkl.webserver.vo.log.OperationLogVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/12/18 19:39
 **/
@Mapper
public interface OperationLogDao extends OperationLogMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<OperationLogVO> getOperationLogVO(SelectStatementProvider selectStatementProvider);
}
