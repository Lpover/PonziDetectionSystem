package cn.qkl.common.repository;


import cn.qkl.common.repository.mapper.*;
import cn.qkl.common.repository.model.Chain;

public class Tables {
    public static final UserDynamicSqlSupport.User user = UserDynamicSqlSupport.user;
    public static final AccountDynamicSqlSupport.Account account = AccountDynamicSqlSupport.account;
    public static final AccountCheckHistoryDynamicSqlSupport.AccountCheckHistory accountCheckHistory = AccountCheckHistoryDynamicSqlSupport.accountCheckHistory;
    public static final AccountContentDynamicSqlSupport.AccountContent accountContent = AccountContentDynamicSqlSupport.accountContent;
    public static final AccountTxHistoryDynamicSqlSupport.AccountTxHistory accountTxHistory = AccountTxHistoryDynamicSqlSupport.accountTxHistory;
    public static final AlgorithmDynamicSqlSupport.Algorithm algorithm = AlgorithmDynamicSqlSupport.algorithm;
    public static final ChainDynamicSqlSupport.Chain chain = ChainDynamicSqlSupport.chain;
    public static final ContentDynamicSqlSupport.Content content = ContentDynamicSqlSupport.content;
    public static final ContentCrossDynamicSqlSupport.ContentCross contentCross = ContentCrossDynamicSqlSupport.contentCross;
    public static final ContentRiskDynamicSqlSupport.ContentRisk contentRisk = ContentRiskDynamicSqlSupport.contentRisk;
    public static final ContentTxHistoryDynamicSqlSupport.ContentTxHistory contentTxHistory = ContentTxHistoryDynamicSqlSupport.contentTxHistory;
    public static final DynamicMonitorDynamicSqlSupport.DynamicMonitor dynamicMonitor = DynamicMonitorDynamicSqlSupport.dynamicMonitor;
    public static final PlatformDynamicSqlSupport.Platform platform = PlatformDynamicSqlSupport.platform;
    public static final RiskContentStatisticsDynamicSqlSupport.RiskContentStatistics riskContentStatistics = RiskContentStatisticsDynamicSqlSupport.riskContentStatistics;
    public static final RiskReportDynamicSqlSupport.RiskReport riskReport = RiskReportDynamicSqlSupport.riskReport;
    public static final StatisticDynamicSqlSupport.Statistic statistic = StatisticDynamicSqlSupport.statistic;

}
