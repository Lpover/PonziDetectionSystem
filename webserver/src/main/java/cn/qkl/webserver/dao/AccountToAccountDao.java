package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.AccountMapper;
import cn.qkl.common.repository.mapper.AccountToAccountMapper;
import cn.qkl.webserver.vo.riskAccount.SmartAddressFindVO;
import cn.qkl.webserver.vo.riskAccount.TransactionDetailVO;
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
public interface AccountToAccountDao extends AccountToAccountMapper {

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<SmartAddressFindVO> getSmartAddress(SelectStatementProvider selectStatementProvider);


}
