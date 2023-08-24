package cn.qkl.webserver.service;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.mapper.AccountTxHistoryMapper;
import cn.qkl.common.repository.model.AccountToAccount;
import cn.qkl.webserver.dao.*;
import cn.qkl.webserver.dto.riskaccount.*;
import cn.qkl.webserver.vo.riskAccount.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Case;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.where.condition.IsBetween;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.annotation.meta.When;
import java.util.List;

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
