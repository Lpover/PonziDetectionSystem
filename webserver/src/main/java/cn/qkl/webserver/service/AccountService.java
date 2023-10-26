package cn.qkl.webserver.service;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.Account;
import cn.qkl.common.repository.model.AccountTxHistory;
import cn.qkl.webserver.common.enums.AccountContentTypeEnum;
import cn.qkl.webserver.dao.AccountDao;
import cn.qkl.webserver.dto.account.AccountContentQueryDTO;
import cn.qkl.webserver.dto.account.AccountTxHistoryQueryDTO;
import cn.qkl.webserver.vo.account.AccountBasicVO;
import cn.qkl.webserver.vo.account.AccountCheckHistoryVO;
import cn.qkl.webserver.vo.account.AccountContentVO;
import cn.qkl.webserver.vo.account.AccountTxHistoryVO;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
/**
 * @Author sunxiaen
 * @Date 2023/5/18 17:23
 **/
@Service
public class AccountService {

    @Resource
    AccountDao accountDao;

    public AccountBasicVO getAccountBasic(Long accountId) {
        return accountDao.getAccountBasic(
                select(Tables.account.accountAddress,
                        Tables.account.accountAlias,
                        Tables.account.chainId,
                        Tables.account.updateTime,
                        Tables.account.cryptoBalance,
                        Tables.account.currencyBalance,
                        Tables.account.exchangeRate,
                        Tables.account.image,
                        Tables.chain.chainName
                ).from(Tables.account).leftJoin(Tables.chain).on(Tables.account.chainId,equalTo(Tables.chain.id))
                        .where(Tables.account.id,isEqualTo(accountId))
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
    }

    public List<AccountCheckHistoryVO> getAccountCheckHistory(Long accountId, Long num) {
        return accountDao.getAccountCheckHistory(
                select(
                        Tables.accountCheckHistory.accountCheckTime,
                        Tables.accountCheckHistory.riskLevel,
                        Tables.accountCheckHistory.relatedNum,
                        Tables.accountCheckHistory.releaseNum
                ).from(Tables.accountCheckHistory)
                        .where(Tables.accountCheckHistory.accountId,isEqualTo(accountId))
                        .orderBy(Tables.accountCheckHistory.accountCheckTime.descending())
                        .limit(num)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
    }

    public PageVO<AccountTxHistoryVO> getAccountTxHistory(AccountTxHistoryQueryDTO dto) {
        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(),accountDao.getAccountTxHistory(
                select(
                        Tables.accountTxHistory.txHash,
                        Tables.accountTxHistory.method,
                        Tables.accountTxHistory.block,
                        Tables.accountTxHistory.txTimestamp,
                        Tables.accountTxHistory.from,
                        Tables.accountTxHistory.to,
                        Tables.accountTxHistory.value,
                        Tables.accountTxHistory.txFee
                ).from(Tables.account).join(Tables.accountTxHistory).on(Tables.account.chainId,equalTo(Tables.accountTxHistory.chainId))
                        .where(Tables.account.id,isEqualTo(dto.getAccountId()))
                        .and(Tables.accountTxHistory.to,isEqualTo(Tables.account.accountAddress),or(Tables.accountTxHistory.from,isEqualTo(Tables.account.accountAddress)))
                        .orderBy(Tables.accountTxHistory.txTimestamp.descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        ));
    }

    public PageVO<AccountContentVO> getAccountContent(AccountContentQueryDTO dto) throws SQLException {
        Account account = accountDao.selectOne(c -> c.where(Tables.account.id,isEqualTo(dto.getAccountId()))).orElseThrow(() -> new SQLException("没有这个Account"));
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder builder = null;

        if (dto.getType() == AccountContentTypeEnum.INTERACT.getCode()) {
            builder = select(
                    Tables.accountContent.contentId,
                    Tables.accountContent.sourceType,
                    Tables.content.address,
                    Tables.content.name.as("content_name"),
                    Tables.content.owner,
                    Tables.content.metaUrl,
                    Tables.content.mintTime,
                    Tables.content.dynamicType,
                    Tables.platform.name.as("platform_name"),
                    Tables.chain.chainName
            ).from(Tables.accountContent)
                    .join(Tables.content)
                    .on(Tables.accountContent.contentId, equalTo(Tables.content.id))
                    .join(Tables.chain)
                    .on(Tables.content.chainId, equalTo(Tables.chain.id))
                    .join(Tables.platform)
                    .on(Tables.content.platformId,equalTo(Tables.platform.id))
                    .where(Tables.accountContent.accountId, isEqualTo(dto.getAccountId()));

        }

        if (dto.getType() == AccountContentTypeEnum.CREATOR.getCode()){
            builder = select(
                    Tables.content.id.as("content_id"),
                    Tables.content.address,
                    Tables.content.name.as("content_name"),
                    Tables.content.owner,
                    Tables.content.metaUrl,
                    Tables.content.mintTime,
                    Tables.content.dynamicType,
                    Tables.platform.name.as("platform_name"),
                    Tables.chain.chainName
            ).from(Tables.content)
                    .join(Tables.chain)
                    .on(Tables.content.chainId,equalTo(Tables.chain.id))
                    .join(Tables.platform)
                    .on(Tables.content.platformId,equalTo(Tables.platform.id))
                    .where(Tables.content.owner, isEqualTo(account.getAccountAddress()))
                    .and(Tables.content.chainId, isEqualTo(account.getChainId()));
        }

        if (builder == null) throw new SQLException();

        SelectStatementProvider provider = builder.build().render(RenderingStrategies.MYBATIS3);
        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(),
                () -> accountDao.getAccountContent(provider)
        );

    }
}
