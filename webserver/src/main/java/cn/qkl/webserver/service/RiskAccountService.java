package cn.qkl.webserver.service;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.mapper.AccountDynamicSqlSupport;
import cn.qkl.common.repository.mapper.AccountTxHistoryMapper;
import cn.qkl.webserver.dao.AccountDao;
import cn.qkl.common.repository.model.AccountToAccount;
import cn.qkl.webserver.dao.*;
import cn.qkl.webserver.dto.riskaccount.*;
import cn.qkl.webserver.dto.riskaccount.NetworkAccountQueryDTO;
import cn.qkl.webserver.vo.account.AccountBasicVO;
import cn.qkl.webserver.vo.riskAccount.*;
import cn.qkl.webserver.vo.riskAccount.NetworkAccountAnalysisVO;
import cn.qkl.webserver.vo.riskAccount.NetworkAccountPanelVO;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import org.apache.ibatis.annotations.Case;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.join.EqualTo;
import org.mybatis.dynamic.sql.where.condition.IsBetween;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.*;

import javax.annotation.meta.When;
import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;


/**
 * @title:
 * @Author lpc
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class RiskAccountService {

    @Autowired
    private AccountCheckHistoryDao accountCheckHistoryDao;
    @Autowired
    private PlatformDao platformDao;
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountToAccountDao accountToAccountDao;
    @Autowired
    private AccountTxHistoryDao accountTxHistoryDao;
    @Autowired
    private AtaExportTaskDao ataExportTaskDao;

    //获取分页列表信息
    public PageVO<AccountInfoVO> getAccountInfoList(AccountInfoListQueryDTO dto) {
        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(),
                () -> accountCheckHistoryDao.getAccountInfo(
                        select(Tables.accountCheckHistory.id, Tables.account.accountAddress,Tables.accountCheckHistory.relatedNum,Tables.accountCheckHistory.releaseNum,Tables.accountCheckHistory.riskLevel,
                                Tables.accountCheckHistory.updateTime,Tables.accountCheckHistory.accountId)
                                .from(Tables.accountCheckHistory)
                                .leftJoin(Tables.account).on(Tables.accountCheckHistory.accountId,equalTo(Tables.account.id))
                                .where(Tables.accountCheckHistory.riskLevel, isInWhenPresent(dto.getRiskLevelList()))
                                //数字筛选
                                .and(Tables.accountCheckHistory.relatedNum, isGreaterThanOrEqualToWhenPresent(dto.getRelatedNumMin()))
                                .and(Tables.accountCheckHistory.relatedNum, isLessThanOrEqualToWhenPresent(dto.getRelatedNumMax()))
                                .and(Tables.accountCheckHistory.releaseNum, isGreaterThanOrEqualToWhenPresent(dto.getReleaseNumMin()))
                                .and(Tables.accountCheckHistory.releaseNum, isLessThanOrEqualToWhenPresent(dto.getReleaseNumMax()))
                                .orderBy(Tables.accountCheckHistory.updateTime.descending())
                                .build()
                                .render(RenderingStrategies.MYBATIS3)
                ));
    }


    //    高中低风险账户信息
    // 定义一个 AccountNumVO 类用于存储总的风险账号数量
    public AccountNumVO getAccountNum(AccountNumDTO dto) {

        AccountNumVO accountNumList = platformDao.getAccountNum(
                select(
                        sum(Tables.platform.highAccountNum).as("totalHighAccount"),
                        sum(Tables.platform.midAccountNum).as("totalMiddleAccount"),
                        sum(Tables.platform.lowAccountNum).as("totalLowAccount"))
                        .from(Tables.platform)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return accountNumList;
    }

    public List<AccountBasicVO> getNetworkAccount(NetworkAccountQueryDTO dto) {
        return accountDao.getAccountBasicList(
                select(Tables.account.id.as("accountId"),
                        Tables.account.accountAddress,
                        Tables.account.accountAlias,
                        Tables.account.chainId,
                        Tables.account.updateTime,
                        Tables.chain.chainName
                ).from(Tables.account).leftJoin(Tables.chain).on(Tables.account.chainId,equalTo(Tables.chain.id))
                        .where(Tables.account.chainId,isEqualTo(dto.getChainId()))
                        .and(Tables.account.accountAddress,isEqualTo(dto.getAccountAddress())).build()
                        .render(RenderingStrategies.MYBATIS3)
        );
    }

    public NetworkAccountPanelVO getNetworkAccountPanel(Long accountId) {
        AccountBasicVO accountBasicVO = accountDao.getAccountBasic(
                select(Tables.account.id.as("accountId"),
                        Tables.account.accountAddress,
                        Tables.account.accountAlias,
                        Tables.account.chainId,
                        Tables.account.updateTime,
                        Tables.chain.chainName
                ).from(Tables.account).leftJoin(Tables.chain).on(Tables.account.chainId,equalTo(Tables.chain.id))
                        .where(Tables.account.id,isEqualTo(accountId)).build()
                        .render(RenderingStrategies.MYBATIS3)
        );

        List<NetworkAccountEdgeVO> edges = accountToAccountDao.getNetworkAccountEdge(
                select(Tables.account.id.qualifiedWith("from_account_table").as("from_account_id"),Tables.accountToAccount.from, Tables.account.id.qualifiedWith("to_account_table").as("to_account_id"), Tables.accountToAccount.to, Tables.accountToAccount.fromRiskIndex,
                        Tables.accountToAccount.toRiskIndex, Tables.accountToAccount.note, Tables.accountToAccount.txAmount,
                        Tables.accountToAccount.txNum, Tables.accountToAccount.fromRatio, Tables.accountToAccount.toRatio)
                        .from(Tables.accountToAccount)
                        .leftJoin(Tables.account,"from_account_table").on(Tables.accountToAccount.from,equalTo(Tables.account.accountAddress.qualifiedWith("from_account_table"))).and(Tables.accountToAccount.chainId,equalTo(Tables.account.chainId.qualifiedWith("from_account_table")))
                        .leftJoin(new AccountDynamicSqlSupport.Account(),"to_account_table").on(Tables.accountToAccount.to,equalTo(Tables.account.accountAddress.qualifiedWith("to_account_table"))).and(Tables.accountToAccount.chainId,equalTo(Tables.account.chainId.qualifiedWith("to_account_table")))
                        .where(Tables.accountToAccount.from, isEqualTo(accountBasicVO.getAccountAddress()), or(Tables.accountToAccount.to, isEqualTo(accountBasicVO.getAccountAddress())))
                        .and(Tables.accountToAccount.chainId, isEqualTo(accountBasicVO.getChainId()))
                        .build().render(RenderingStrategies.MYBATIS3)
        );

        HashMap<Long,NetworkAccountNodeVO> hashMap = new HashMap<>();
        for (NetworkAccountEdgeVO edge:edges) {
            NetworkAccountNodeVO toVo = FunctionUtil.apply(new NetworkAccountNodeVO(), it-> {
                it.setId(edge.getToAccountId());
                it.setLabel(edge.getTo());
                it.setRiskIndex(edge.getToRiskIndex());
            });
            if (!hashMap.containsKey(toVo.getId())) {
                hashMap.put(toVo.getId(),toVo);
            }
            NetworkAccountNodeVO fromVo = FunctionUtil.apply(new NetworkAccountNodeVO(), it -> {
                it.setId(edge.getFromAccountId());
                it.setLabel(edge.getFrom());
                it.setRiskIndex(edge.getFromRiskIndex());
            });
            if (!hashMap.containsKey(fromVo.getId())) {
                hashMap.put(fromVo.getId(),fromVo);
            }
        }

        return FunctionUtil.apply(new NetworkAccountPanelVO(),it -> {
            it.setAccountId(accountBasicVO.getAccountId());
            it.setAccountAddress(accountBasicVO.getAccountAddress());
            it.setChainId(accountBasicVO.getChainId());
            it.setChainName(accountBasicVO.getChainName());
            it.setNodes(new ArrayList<>(hashMap.values()));
            it.setEdges(edges);
        });
    }

    public NetworkAccountAnalysisVO getNetworkAccountAnalysis(Long accountId) {
        return accountDao.getAccountAnalysis(select(
                Tables.account.id.as("accountId"), Tables.account.accountAddress, Tables.account.chainId,
                Tables.chain.chainName, Tables.account.actionFeatures, Tables.account.contentTag,
                Tables.account.releaseNum, Tables.account.riskLevel, Tables.account.note,
                Tables.account.riskTxNumIn, Tables.account.riskTxNumOut, Tables.account.riskContentNum,
                Tables.account.recentTxTime
        ).from(Tables.account).leftJoin(Tables.chain)
                .on(Tables.account.chainId, equalTo(Tables.chain.id))
                .where(Tables.account.id,isEqualTo(accountId))
                .build().render(RenderingStrategies.MYBATIS3));
    }

    //智能查找目标地址
    public List<SmartAddressFindVO> getSmartAddress (SmartAddressFindDTO dto){
        //查找方向：1-查去向/2-查来源
        if(dto.getFindDirections()==1) {
            List<SmartAddressFindVO> smartAddressFindVOList = accountToAccountDao.getSmartAddress(
                    select(Tables.accountToAccount.from, Tables.accountToAccount.to, Tables.accountToAccount.fromRiskIndex,
                            Tables.accountToAccount.toRiskIndex, Tables.accountToAccount.note, Tables.accountToAccount.txAmount,
                            Tables.accountToAccount.txNum, Tables.accountToAccount.fromRatio, Tables.accountToAccount.toRatio,
                            Tables.accountToAccount.blockchain)
                            .from(Tables.accountToAccount)
                            .where(Tables.accountToAccount.from, isEqualToWhenPresent(dto.getAddress()))
                            .build()
                            .render(RenderingStrategies.MYBATIS3)
            );
            return smartAddressFindVOList;
        }
        else {
            List<SmartAddressFindVO> smartAddressFindVOList = accountToAccountDao.getSmartAddress(
                    select(Tables.accountToAccount.from, Tables.accountToAccount.to, Tables.accountToAccount.fromRiskIndex,
                            Tables.accountToAccount.toRiskIndex, Tables.accountToAccount.note, Tables.accountToAccount.txAmount,
                            Tables.accountToAccount.txNum, Tables.accountToAccount.fromRatio, Tables.accountToAccount.toRatio,
                            Tables.accountToAccount.blockchain)
                            .from(Tables.accountToAccount)
                            .where(Tables.accountToAccount.to, isEqualToWhenPresent(dto.getAddress()))
                            .build()
                            .render(RenderingStrategies.MYBATIS3)
            );
            return smartAddressFindVOList;
        }
    }

    //根据地址添加备注
    public void changeAddNote(AddNoteDTO dto) {
        accountToAccountDao.update(
                c->c.set(Tables.account.note).equalTo(dto.getNote())
                        .where(Tables.account.accountAddress,isEqualTo(dto.getAccountAddress()))
        );
    }

    //交易导出按钮
    public void doTransactionExport(TransactionExportDTO dto){

    }
    //导出任务显示
    public List<exportTaskVO> getExportTask(exportTaskDTO dto){
        List<exportTaskVO> exportTaskVOList = ataExportTaskDao.getexportTask(
                select(Tables.ataExportTask.address,Tables.ataExportTask.blockchain,Tables.ataExportTask.lowerLimit,
                        Tables.ataExportTask.startTime,Tables.ataExportTask.endTime,Tables.ataExportTask.direction,
                        Tables.ataExportTask.url)
                        .from(Tables.ataExportTask)
                        .orderBy(Tables.ataExportTask.updateTime)
                        .limit(20)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return exportTaskVOList;
    }

    //地址全部交易详情
    public List<TransactionDetailVO> getTransactionDetail(TransactionDetailDTO dto){

        //当address作为from来源的时候，对手地址是to，交易方向是转出
        List<TransactionDetailVO> transactionDetailVOListFrom = accountTxHistoryDao.getTransactionDetail(
                select(Tables.accountTxHistory.txHash,Tables.accountTxHistory.updateTime,Tables.accountTxHistory.value,
                        Tables.accountTxHistory.note,Tables.accountTxHistory.to.as("address"))
                        .from(Tables.accountTxHistory)
                        .where(Tables.accountTxHistory.from,isEqualTo(dto.getAddress()))
                        .where(Tables.accountTxHistory.updateTime,isGreaterThanOrEqualToWhenPresent(dto.getStartTime()))
                        .where(Tables.accountTxHistory.updateTime,isLessThanOrEqualToWhenPresent(dto.getEndTime()))
                        .where(Tables.accountTxHistory.to,isEqualToWhenPresent(dto.getTargetAddress()))
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        //当address作为to转入的时候，对手地址是from，交易方向是转入
        List<TransactionDetailVO> transactionDetailVOListTo = accountTxHistoryDao.getTransactionDetail(
                select(Tables.accountTxHistory.txHash,Tables.accountTxHistory.updateTime,Tables.accountTxHistory.value,
                        Tables.accountTxHistory.note,Tables.accountTxHistory.from.as("address"))
                        .from(Tables.accountTxHistory)
                        .where(Tables.accountTxHistory.to,isEqualTo(dto.getAddress()))
                        .where(Tables.accountTxHistory.updateTime,isGreaterThanOrEqualToWhenPresent(dto.getStartTime()))
                        .where(Tables.accountTxHistory.updateTime,isLessThanOrEqualToWhenPresent(dto.getEndTime()))
                        .where(Tables.accountTxHistory.from,isEqualToWhenPresent(dto.getTargetAddress()))
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );

        // Set txDirection for each list
        for (TransactionDetailVO transactionDetail : transactionDetailVOListFrom) {
            transactionDetail.setTxDirection("转出");
        }
        for (TransactionDetailVO transactionDetail : transactionDetailVOListTo) {
            transactionDetail.setTxDirection("转入");
        }

        // Combine the two lists
        transactionDetailVOListFrom.addAll(transactionDetailVOListTo);
        return transactionDetailVOListTo;
    }

    //地址全部交易备注修改
    public void changeDetailNote(DetailNoteDTO dto) {
        accountTxHistoryDao.update(
                c->c.set(Tables.accountTxHistory.note).equalTo(dto.getNote())
                        .where(Tables.accountTxHistory.txHash,isEqualTo(dto.getTxHash()))
        );
    }

}
