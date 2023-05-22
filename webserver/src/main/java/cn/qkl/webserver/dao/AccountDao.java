package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.AccountMapper;
import cn.qkl.webserver.vo.account.AccountBasicVO;
import cn.qkl.webserver.vo.account.AccountCheckHistoryVO;
import cn.qkl.webserver.vo.account.AccountContentVO;
import cn.qkl.webserver.vo.account.AccountTxHistoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
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
    List<AccountBasicVO> getAccountBasic(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<AccountCheckHistoryVO> getAccountCheckHistory(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<AccountTxHistoryVO> getAccountTxHistory(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id="AnimalDataResult",value = {
            @Result(column="id", property="contentId", id=true),
            @Result(column = "content_id", property = "contentId",id = true)
    })
    List<AccountContentVO> getAccountContent(SelectStatementProvider selectStatementProvider);
}
