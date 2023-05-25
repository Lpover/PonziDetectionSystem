package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.AccountCheckHistoryMapper;
import cn.qkl.webserver.vo.riskAccount.AccountInfoVO;
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
public interface AccountCheckHistoryDao extends AccountCheckHistoryMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<AccountInfoVO> getAccountInfo(SelectStatementProvider selectStatementProvider);
}
