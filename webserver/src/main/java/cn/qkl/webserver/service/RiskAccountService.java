package cn.qkl.webserver.service;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.dao.AccountCheckHistoryDao;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.dto.riskaccount.AccountInfoListQueryDTO;
import cn.qkl.webserver.dto.riskaccount.AccountNumDTO;
import cn.qkl.webserver.vo.riskAccount.AccountInfoVO;
import cn.qkl.webserver.vo.riskAccount.AccountNumVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

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

}
