//package cn.qkl.webserver.backgroundTask;
//
//import cn.hutool.core.date.DateUtil;
//import cn.hutool.core.util.IdUtil;
//import cn.qkl.common.framework.initAndBackground.BackgroundTask;
//import cn.qkl.common.repository.Tables;
//import cn.qkl.common.repository.model.Account;
//import cn.qkl.common.repository.model.Platform;
//import cn.qkl.common.repository.model.PlatformDailyStatistics;
//import cn.qkl.webserver.dao.AccountDao;
//import cn.qkl.webserver.dao.PlatformDailyStatisticsDao;
//import cn.qkl.webserver.dao.PlatformDao;
//import cn.qkl.webserver.service.PlatformViewService;
//import cn.qkl.webserver.service.PlatformViewService.AccountGenerator;
//import cn.qkl.webserver.service.RiskNumViewService;
//import cn.qkl.webserver.service.RiskTxViewService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
//
///**
// * @title:
// * @Author wang xin
// * @Date: 2022/11/3 15:00
// * @wiki
// */
//@Slf4j
//@Component
//public class AccountOnetimeBackgroundTask implements BackgroundTask {
//
//    @Autowired
//    private AccountDao accountDao;
//
//    @Autowired
//    private PlatformDao platformDao;
//
//    @Autowired
//    private PlatformViewService platformViewService;
//
//    /**
//     * 间隔1天
//     */
//    @Override
//    public long getPeriod() {
//        return 24 * 60 * 60 * 1000;
//    }
//
//    //从第二天开始每天凌晨2点执行
//    @Override
//    public long getDelay() {
//        //当前服务器时间
//        Date start = new Date();
//        //一天的结束，结果：00:00:00
//        Date end = DateUtil.beginOfDay(start);
//        //当天1：00：00
//        end = DateUtil.offsetHour(end, 1);
//        //第二天1：00：00
//        end = DateUtil.offsetDay(end, 1);
//
//        //延迟至第二天凌晨1点开始执行
//        return end.getTime() - start.getTime();
////        //一次性任务，delay为0
////        return 0;
//    }
//
//    @Override
//    public String getName() {
//        return AccountOnetimeBackgroundTask.class.getName();
//    }
//
//    @Override
//    public void run() {
//        log.debug("模拟插入account表数据，一次性使用，注意修改数据");
//        List<Account> list = new ArrayList<>();
//        // 只获取正在监测的平台id
//        List<Long> platformIDList= platformDao.select(c -> c.where(Tables.platform.monitor, isEqualTo(1))).stream().map(Platform::getId).collect(Collectors.toList());
//        // 每个平台插入一条账号
//
//        for (Long platformId : platformIDList) {
//            Account account = new Account();
//            insertCommon(account, platformId);
//
//            AccountGenerator accountGenerator = new AccountGenerator();
//            accountGenerator.insertAccount(account);//账号内容
//
//            list.add(account);
//        }
//
//        accountDao.insertMultiple(list);
//    }
//
//    private void insertCommon(Account account, Long platformID){
//        Date end = new Date();
//        account.setId(IdUtil.getSnowflakeNextId());
//        account.setPlatformId(platformID);
//        account.setCreateTime(end);
//        account.setUpdateTime(end);
//    }
//
//}
