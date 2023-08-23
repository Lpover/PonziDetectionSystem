package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.AccountMapper;
import cn.qkl.webserver.vo.account.AccountBasicVO;
import cn.qkl.webserver.vo.account.AccountCheckHistoryVO;
import cn.qkl.webserver.vo.account.AccountContentVO;
import cn.qkl.webserver.vo.account.AccountTxHistoryVO;
import cn.qkl.webserver.vo.riskAccount.AddNoteVO;
import cn.qkl.webserver.vo.riskAccount.SmartAddressFindVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

/**
 * @Author sunxiaen
 * @Date 17:48 2023/5/18
 **/
@Mapper
public interface AccountToAccountDao extends AccountMapper{

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<SmartAddressFindVO> getSmartAddress(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    AddNoteVO getAddNote(SelectStatementProvider selectStatementProvider);

}
