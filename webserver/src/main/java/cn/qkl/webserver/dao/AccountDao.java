package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.AccountMapper;
import cn.qkl.webserver.vo.account.*;
import org.apache.ibatis.annotations.*;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

/**
 * @Author sunxiaen
 * @Date 17:48 2023/5/18
 **/
@Mapper
public interface AccountDao extends AccountMapper{

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    AccountBasicVO getAccountBasic(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<AccountCheckHistoryVO> getAccountCheckHistory(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<AccountTxHistoryVO> getAccountTxHistory(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap(value = "AccountContentResultMap")
//    Mybatis结果集映射 对象嵌套对象 数据库查出的部分字段需要包装成"tags":{},对应TagVO
    List<AccountContentVO> getAccountContent(SelectStatementProvider selectStatementProvider);


}
