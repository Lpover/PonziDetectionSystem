package cn.qkl.webserver.service;

import cn.qkl.common.framework.util.SnowflakeIdUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.Account;
import cn.qkl.common.repository.model.AccountCheckHistory;
import cn.qkl.webserver.dao.AccountCheckHistoryDao;
import cn.qkl.webserver.dao.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @Author sunxiaen
 * @Date 2023/5/25 17:07
 * @Description 执行定时任务，找到当时的账户数据并插入到记录表中
 **/
@Slf4j
@Service
public class AccountCheckService {
    @Resource
    AccountCheckHistoryDao accountCheckHistoryDao;

    @Resource
    AccountDao accountDao;

    private int calRiskLevel(long relatedNum, long releaseNum) {
        //如何评估风险值
        //todo:怎么衡量风险level，定时任务的时候存啥？
        int riskLevel = 0;
        long riskIndex = releaseNum + relatedNum;
        if (riskIndex > 30) {
            riskLevel = 2;
        } else if (riskIndex > 20) {
            riskLevel = 1;
        }

        return riskLevel;
    }

    public Integer getAccountCheckOnce(Long accountId) throws SQLException {
        Account account = accountDao.selectOne(c -> c.where(Tables.account.id,isEqualTo(accountId))).orElseThrow(() -> new SQLException("[AccountCheckScheduleService] 无效的accountId"));

        Long relatedNum = accountCheckHistoryDao.getAccountCheckOnceRelated(
                select(count(Tables.account.id).as("relatedNum")).
                        from(Tables.accountContent)
                        .join(Tables.account)
                        .on(Tables.account.id, equalTo(Tables.accountContent.accountId))
                        .groupBy(Tables.account.id)
                        .build().render(RenderingStrategies.MYBATIS3)
        );
        Long releaseNum = accountCheckHistoryDao.getAccountCheckOnceRelease(
                select(count(Tables.content.creator).as("releaseNum"))
                        .from(Tables.content)
                        .where(Tables.content.creator,isEqualTo(account.getAccountAddress()))
                        .and(Tables.content.chainId,isEqualTo(account.getChainId()))
                        .groupBy(Tables.content.creator)
                        .build().render(RenderingStrategies.MYBATIS3)
        );


        return accountCheckHistoryDao.insert(new AccountCheckHistory()
                .withId(SnowflakeIdUtil.generateId())
                .withAccountId(accountId)
                .withAccountCheckTime(new Date())
                .withRiskLevel(calRiskLevel(relatedNum,releaseNum))
                .withRelatedNum(Math.toIntExact(relatedNum))
                .withReleaseNum(Math.toIntExact(releaseNum))
                .withCreateTime(new Date())
                .withUpdateTime(new Date())
        );
    }

//    public Integer getAccountCheckMany(Long accountId) throws SQLException {
//        List<Account> account = accountDao.selectMany(select(Tables.account.id,Tables.account.accountAddress,Tables.account.chainId).from(Tables.account).build().render(RenderingStrategies.MYBATIS3));
//    }
}
