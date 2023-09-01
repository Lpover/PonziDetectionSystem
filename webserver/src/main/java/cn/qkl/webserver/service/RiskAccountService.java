package cn.qkl.webserver.service;

import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.AtaExportTask;
import cn.qkl.webserver.dao.*;
import cn.qkl.webserver.dto.riskaccount.*;
import cn.qkl.webserver.vo.riskAccount.*;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SimpleSortSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private AccountDao accountDao;

    //获取分页列表信息
    public PageVO<AccountInfoVO> getAccountInfoList(AccountInfoListQueryDTO dto) {
        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(),
                () -> accountCheckHistoryDao.getAccountInfo(
                        select(Tables.accountCheckHistory.id, Tables.account.accountAddress, Tables.accountCheckHistory.relatedNum, Tables.accountCheckHistory.releaseNum, Tables.accountCheckHistory.riskLevel,
                                Tables.accountCheckHistory.updateTime, Tables.accountCheckHistory.accountId)
                                .from(Tables.accountCheckHistory)
                                .leftJoin(Tables.account).on(Tables.accountCheckHistory.accountId, equalTo(Tables.account.id))
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

    //智能查找目标地址-地址表
    public List<SmartAddressFindVO> getSmartAddress(SmartAddressFindDTO dto) {
        //查找方向：1-查去向/2-查来源
        // 1-去向，目标地址是from,返回的地址是to
        if (dto.getFindDirections() == 1) {
            List<SmartAddressFindVO> smartAddressFindVOList = accountToAccountDao.getSmartAddress(
                    select(Tables.accountToAccount.id, Tables.accountToAccount.to.as("address"),
                            Tables.accountToAccount.toRiskIndex.as("riskIndex"), Tables.accountToAccount.note,
                            Tables.accountToAccount.toAmount.as("fromAmount"))
                            .from(Tables.accountToAccount)
                            .where(Tables.accountToAccount.from, isEqualToWhenPresent(dto.getAddress()))
                            .and(Tables.accountToAccount.chainId, isEqualToWhenPresent(dto.getChainID()))
                            .and(Tables.accountToAccount.toRiskIndex, isEqualToWhenPresent(dto.getRiskIndex()))
                            .build()
                            .render(RenderingStrategies.MYBATIS3)
            );
            return smartAddressFindVOList;
        }
        // 2-来源，目标地址是to,返回的地址是from
        else {
            List<SmartAddressFindVO> smartAddressFindVOList = accountToAccountDao.getSmartAddress(
                    select(Tables.accountToAccount.id, Tables.accountToAccount.from.as("address"),
                            Tables.accountToAccount.fromRiskIndex.as("riskIndex"), Tables.accountToAccount.note,
                            Tables.accountToAccount.fromAmount.as("fromAmount"))
                            .from(Tables.accountToAccount)
                            .where(Tables.accountToAccount.to, isEqualToWhenPresent(dto.getAddress()))
                            .and(Tables.accountToAccount.chainId, isEqualToWhenPresent(dto.getChainID()))
                            .and(Tables.accountToAccount.fromRiskIndex, isEqualToWhenPresent(dto.getRiskIndex()))
                            .build()
                            .render(RenderingStrategies.MYBATIS3)
            );
            return smartAddressFindVOList;
        }
    }

    //智能查找目标地址-交易表
    public List<SmartTranscationFindVO> getSmartTransaction(SmartAddressFindDTO dto) {
        //查找方向：1-查去向/2-查来源
        // 1-去向，目标地址是from,返回的地址是to
        if (dto.getFindDirections() == 1) {
            List<SmartTranscationFindVO> smartTranscationFindVOListTo = accountToAccountDao.getSmartTransaction(
                    select(Tables.accountToAccount.id, Tables.accountToAccount.from, Tables.accountToAccount.to,
                            Tables.accountToAccount.fromRiskIndex, Tables.accountToAccount.toRiskIndex, Tables.accountToAccount.toAmount,
                            Tables.accountToAccount.txAmount, Tables.accountToAccount.txNum, Tables.accountToAccount.fromRatio, Tables.accountToAccount.toRatio,
                            Tables.chain.chainName)
                            .from(Tables.accountToAccount)
                            .leftJoin(Tables.chain).on(Tables.accountToAccount.chainId, equalTo(Tables.chain.id))
                            .where(Tables.accountToAccount.from, isEqualToWhenPresent(dto.getAddress()))
                            .build()
                            .render(RenderingStrategies.MYBATIS3)
            );
            return smartTranscationFindVOListTo;
        }
        // 2-来源，目标地址是to,返回的地址是from
        else {
            List<SmartTranscationFindVO> smartAddressFindVOListFrom = accountToAccountDao.getSmartTransaction(
                    select(Tables.accountToAccount.id, Tables.accountToAccount.from, Tables.accountToAccount.to,
                            Tables.accountToAccount.fromRiskIndex, Tables.accountToAccount.toRiskIndex, Tables.accountToAccount.fromAmount,
                            Tables.accountToAccount.txAmount, Tables.accountToAccount.txNum, Tables.accountToAccount.fromRatio, Tables.accountToAccount.toRatio,
                            Tables.chain.chainName)
                            .from(Tables.accountToAccount)
                            .leftJoin(Tables.chain).on(Tables.accountToAccount.chainId, equalTo(Tables.chain.id))
                            .where(Tables.accountToAccount.to, isEqualToWhenPresent(dto.getAddress()))
                            .build()
                            .render(RenderingStrategies.MYBATIS3)
            );
            return smartAddressFindVOListFrom;
        }
    }

    //根据地址添加备注
    public void changeAddNote(AddNoteDTO dto) {
        accountDao.update(
                c -> c.set(Tables.account.note).equalTo(dto.getNote())
                        .where(Tables.account.accountAddress, isEqualTo(dto.getAccountAddress()))
        );
    }

    //交易导出按钮
    public String doTransactionExport(TransactionExportDTO dto) {

        List<AtaExportTask> list = new ArrayList<>();
        AtaExportTask ataExportTask = new AtaExportTask();

        List<exportCSVVO> csvData = getCsvData(dto);
        String csvFileUrl = exportToCsv(csvData);

        insertTransactionExport(ataExportTask, dto, csvFileUrl);
        list.add(ataExportTask);
        ataExportTaskDao.insertMultiple(list);
        
        return csvFileUrl;

    }

    //    生成本地csv文件
    public List<exportCSVVO> getCsvData(TransactionExportDTO dto) {

        //查转入,自己的地址是from,此时address为表中的to
        List<exportCSVVO> exportCSVVOListTO = accountToAccountDao.getCsvData(
                select(Tables.chain.chainName, Tables.accountToAccount.protocols, Tables.account.currencyBalance,
                        Tables.accountToAccount.label, Tables.accountToAccount.note, Tables.accountToAccount.updateTime,
                        Tables.accountToAccount.createTime, Tables.accountToAccount.toAmount, Tables.accountToAccount.fromAmount,
                        Tables.accountToAccount.toNum, Tables.accountToAccount.fromNum, Tables.accountToAccount.toCounter,
                        Tables.accountToAccount.fromCounter, Tables.accountToAccount.to.as("address"))
                        .from(Tables.accountToAccount)
                        .leftJoin(Tables.account).on(Tables.accountToAccount.to, equalTo(Tables.account.accountAddress))
                        .leftJoin(Tables.chain).on(Tables.accountToAccount.chainId, equalTo(Tables.chain.id))
                        .where(Tables.accountToAccount.from, isEqualToWhenPresent(dto.getAddress()))
                        .and(Tables.accountToAccount.createTime, isGreaterThanOrEqualToWhenPresent(dto.getStartTime()))
                        .and(Tables.accountToAccount.createTime, isLessThanOrEqualToWhenPresent(dto.getEndTime()))
                        .and(Tables.accountToAccount.toAmount, isGreaterThanOrEqualToWhenPresent(dto.getLowerLimit()))
                        .and(Tables.accountToAccount.chainId, isEqualToWhenPresent(dto.getChainID()))
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );

        //查转出,自己的地址是to,此时address为表中的from
        List<exportCSVVO> exportCSVVOListFrom = accountToAccountDao.getCsvData(
                select(Tables.chain.chainName, Tables.accountToAccount.protocols, Tables.account.currencyBalance,
                        Tables.accountToAccount.label, Tables.accountToAccount.note, Tables.accountToAccount.updateTime,
                        Tables.accountToAccount.createTime, Tables.accountToAccount.toAmount, Tables.accountToAccount.fromAmount,
                        Tables.accountToAccount.toNum, Tables.accountToAccount.fromNum, Tables.accountToAccount.toCounter,
                        Tables.accountToAccount.fromCounter, Tables.accountToAccount.from.as("address"))
                        .from(Tables.accountToAccount)
                        .leftJoin(Tables.account).on(Tables.accountToAccount.from, equalTo(Tables.account.accountAddress))
                        .leftJoin(Tables.chain).on(Tables.accountToAccount.chainId, equalTo(Tables.chain.id))
                        .where(Tables.accountToAccount.to, isEqualToWhenPresent(dto.getAddress()))
                        .and(Tables.accountToAccount.createTime, isGreaterThanOrEqualToWhenPresent(dto.getStartTime()))
                        .and(Tables.accountToAccount.createTime, isLessThanOrEqualToWhenPresent(dto.getEndTime()))
                        .and(Tables.accountToAccount.toAmount, isGreaterThanOrEqualToWhenPresent(dto.getLowerLimit()))
                        .and(Tables.accountToAccount.chainId, isEqualToWhenPresent(dto.getChainID()))
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );

        if (dto.getDirection() == 3) return exportCSVVOListFrom;//转出
        if (dto.getDirection() == 2) return exportCSVVOListTO;//转入
        //如果是全部，将两次查询合并返回
        exportCSVVOListTO.addAll(exportCSVVOListFrom);
        return exportCSVVOListTO;

    }

    public String exportToCsv(List<exportCSVVO> exportTaskVOList) {
        // 创建文件夹
        String folderPath = "AtaTask";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdir();
        }

        // 构建文件路径，使用当前时间作为文件名
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = folderPath + "/" + timeStamp + ".csv";

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            // 写 CSV 表头
            //String header = "address,blockchain,lowerLimit,startTime,endTime,direction,url\n";
            String header = "区块链,协议,目标地址,余额,标签,备注,首次交易时间,最近交易时间,转入总金额,转出总金额,转入笔数,转出笔数,转入对手,转出对手\n";
            fileWriter.write(header);

            // 写查询结果到 CSV
            for (exportCSVVO task : exportTaskVOList) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedUpdateTime = dateFormat.format(task.getUpdateTime());
                String formattedCreateTime = dateFormat.format(task.getCreateTime());

                String row = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%d,%d,%d,%d,%d,%d\n",
                        task.getChainName(), task.getProtocols(), task.getAddress(),
                        task.getCurrencyBalance(), task.getLabel(), task.getNote(),
                        formattedUpdateTime, formattedCreateTime, task.getFromAmount(),
                        task.getToAmount(), task.getFromNum(), task.getToNum(),
                        task.getFromCounter(), task.getToCounter());
                fileWriter.write(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 构建文件的URL并返回
        try {
            URL fileUrl = new File(filePath).toURI().toURL();
            return fileUrl.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //交易导出插入新任务
    public void insertTransactionExport(AtaExportTask ataExportTask, TransactionExportDTO dto, String csvFileUrl) {

        Date end = new Date();

        ataExportTask.setId(IdUtil.getSnowflakeNextId());
        ataExportTask.setAddress(dto.getAddress());
        ataExportTask.setChainId(dto.getChainID());
        ataExportTask.setLowerLimit(dto.getLowerLimit());
        ataExportTask.setStartTime(dto.getStartTime());
        ataExportTask.setEndTime(dto.getEndTime());
        ataExportTask.setDirection(dto.getDirection());
        ataExportTask.setCreateTime(end);
        ataExportTask.setUpdateTime(end);
        ataExportTask.setUrl(csvFileUrl);

    }

    //导出任务显示
    public List<exportTaskVO> getExportTask(exportTaskDTO dto) {
        List<exportTaskVO> exportTaskVOList = ataExportTaskDao.getExportTask(
                select(Tables.ataExportTask.id, Tables.ataExportTask.address, Tables.ataExportTask.lowerLimit,
                        Tables.ataExportTask.startTime, Tables.ataExportTask.endTime, Tables.ataExportTask.direction,
                        Tables.ataExportTask.url, Tables.chain.chainName)
                        .from(Tables.ataExportTask, "ata")
                        .leftJoin(Tables.chain).on(Tables.ataExportTask.chainId, equalTo(Tables.chain.id))
                        .orderBy(SimpleSortSpecification.of("ata.update_time").descending())
                        .limit(20)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return exportTaskVOList;
    }

    //地址全部交易详情
    public List<TransactionDetailVO> getTransactionDetail(TransactionDetailDTO dto) {

        //当address作为from来源的时候，对手地址是to，交易方向是转出
        List<TransactionDetailVO> transactionDetailVOListFrom = accountTxHistoryDao.getTransactionDetail(
                select(Tables.accountTxHistory.id, Tables.accountTxHistory.txHash, Tables.accountTxHistory.updateTime, Tables.accountTxHistory.value,
                        Tables.accountTxHistory.note, Tables.accountTxHistory.to.as("addressTarget"))
                        .from(Tables.accountTxHistory)
                        .where(Tables.accountTxHistory.from, isEqualTo(dto.getAddress()))
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        //当address作为to转入的时候，对手地址是from，交易方向是转入
        List<TransactionDetailVO> transactionDetailVOListTo = accountTxHistoryDao.getTransactionDetail(
                select(Tables.accountTxHistory.id, Tables.accountTxHistory.txHash, Tables.accountTxHistory.updateTime, Tables.accountTxHistory.value,
                        Tables.accountTxHistory.note, Tables.accountTxHistory.from.as("addressTarget"))
                        .from(Tables.accountTxHistory)
                        .where(Tables.accountTxHistory.to, isEqualTo(dto.getAddress()))
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
        return transactionDetailVOListFrom;
    }

    //地址全部交易备注修改
    public void changeDetailNote(DetailNoteDTO dto) {
        accountTxHistoryDao.update(
                c -> c.set(Tables.accountTxHistory.note).equalTo(dto.getNote())
                        .where(Tables.accountTxHistory.txHash, isEqualTo(dto.getTxHash()))
        );
    }

}
