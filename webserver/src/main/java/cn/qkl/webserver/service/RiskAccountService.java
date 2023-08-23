package cn.qkl.webserver.service;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.AccountToAccount;
import cn.qkl.webserver.dao.AccountCheckHistoryDao;
import cn.qkl.webserver.dao.AccountToAccountDao;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.dto.riskaccount.AccountInfoListQueryDTO;
import cn.qkl.webserver.dto.riskaccount.AccountNumDTO;
import cn.qkl.webserver.dto.riskaccount.SmartAddressFindDTO;
import cn.qkl.webserver.vo.riskAccount.AccountInfoVO;
import cn.qkl.webserver.vo.riskAccount.AccountNumVO;
import cn.qkl.webserver.vo.riskAccount.AddNoteVO;
import cn.qkl.webserver.vo.riskAccount.SmartAddressFindVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

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
            List<SmartAddressFindVO> smartAddressFindList = accountToAccountDao.getSmartAddress(
                    select(Tables.accountToAccount.from, Tables.accountToAccount.to, Tables.accountToAccount.fromRiskIndex,
                            Tables.accountToAccount.toRiskIndex, Tables.accountToAccount.note, Tables.accountToAccount.txAmount,
                            Tables.accountToAccount.txNum, Tables.accountToAccount.fromRatio, Tables.accountToAccount.toRatio,
                            Tables.accountToAccount.blockchain)
                            .from(Tables.accountToAccount)
                            .where(Tables.accountToAccount.from, isEqualToWhenPresent(dto.getAddress()))
                            .build()
                            .render(RenderingStrategies.MYBATIS3)
            );
            return smartAddressFindList;
        }
        else {
            List<SmartAddressFindVO> smartAddressFindList = accountToAccountDao.getSmartAddress(
                    select(Tables.accountToAccount.from, Tables.accountToAccount.to, Tables.accountToAccount.fromRiskIndex,
                            Tables.accountToAccount.toRiskIndex, Tables.accountToAccount.note, Tables.accountToAccount.txAmount,
                            Tables.accountToAccount.txNum, Tables.accountToAccount.fromRatio, Tables.accountToAccount.toRatio,
                            Tables.accountToAccount.blockchain)
                            .from(Tables.accountToAccount)
                            .where(Tables.accountToAccount.to, isEqualToWhenPresent(dto.getAddress()))
                            .build()
                            .render(RenderingStrategies.MYBATIS3)
            );
            return smartAddressFindList;
        }
    }

    //根据地址添加备注
    public AddNoteVO getAddNote(AccountNumDTO dto) {

        AddNoteVO getAddNote = accountToAccountDao.getAddNote(
                select(
                        sum(Tables.platform.highAccountNum).as("totalHighAccount"),
                        sum(Tables.platform.midAccountNum).as("totalMiddleAccount"),
                        sum(Tables.platform.lowAccountNum).as("totalLowAccount"))
                        .from(Tables.platform)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return getAddNote;
    }

}
