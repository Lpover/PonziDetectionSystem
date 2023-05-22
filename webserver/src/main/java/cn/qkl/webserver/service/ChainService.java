package cn.qkl.webserver.service;

import cn.qkl.common.repository.model.Chain;
import cn.qkl.webserver.dao.ChainDao;
import cn.qkl.webserver.vo.chain.ChainVO;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static cn.qkl.common.repository.mapper.ChainDynamicSqlSupport.chain;
import static org.mybatis.dynamic.sql.SqlBuilder.select;
/**
 * @Author sunxiaen
 * @Date 2023/5/18 10:33
 **/
@Service
public class ChainService {
    @Resource
    ChainDao chainDao;

    public List<ChainVO> getChainList() {
        SelectStatementProvider selectStatement = select(
                chain.id,
                chain.chainName,
                chain.chainLogoUrl,
                chain.chainCryptoUnit
        ).from(chain)
        .build()
        .render(RenderingStrategies.MYBATIS3);

        List<Chain> chainList = chainDao.selectMany(selectStatement);
        return chainList.stream().map(ChainVO::transformFromChain).collect(Collectors.toList());
    }
}
