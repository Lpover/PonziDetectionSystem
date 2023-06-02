package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PlatformDailyStatisticsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final PlatformDailyStatistics platformDailyStatistics = new PlatformDailyStatistics();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = platformDailyStatistics.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> platformId = platformDailyStatistics.platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> highRiskNum = platformDailyStatistics.highRiskNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> middleRiskNum = platformDailyStatistics.middleRiskNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> lowRiskNum = platformDailyStatistics.lowRiskNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> contentSum = platformDailyStatistics.contentSum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> contentRiskSum = platformDailyStatistics.contentRiskSum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = platformDailyStatistics.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = platformDailyStatistics.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> highRiskTx = platformDailyStatistics.highRiskTx;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> middleRiskTx = platformDailyStatistics.middleRiskTx;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> lowRiskTx = platformDailyStatistics.lowRiskTx;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> storageRatio = platformDailyStatistics.storageRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> carrierRatio = platformDailyStatistics.carrierRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> categoryRatio = platformDailyStatistics.categoryRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> storageProviderName = platformDailyStatistics.storageProviderName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> carrierName = platformDailyStatistics.carrierName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> categoryName = platformDailyStatistics.categoryName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> riskIndex = platformDailyStatistics.riskIndex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class PlatformDailyStatistics extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> platformId = column("platform_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> highRiskNum = column("high_risk_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> middleRiskNum = column("middle_risk_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> lowRiskNum = column("low_risk_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> contentSum = column("content_sum", JDBCType.INTEGER);

        public final SqlColumn<Integer> contentRiskSum = column("content_risk_sum", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> highRiskTx = column("high_risk_tx", JDBCType.INTEGER);

        public final SqlColumn<Integer> middleRiskTx = column("middle_risk_tx", JDBCType.INTEGER);

        public final SqlColumn<Integer> lowRiskTx = column("low_risk_tx", JDBCType.INTEGER);

        public final SqlColumn<Integer> storageRatio = column("storage_ratio", JDBCType.INTEGER);

        public final SqlColumn<Integer> carrierRatio = column("carrier_ratio", JDBCType.INTEGER);

        public final SqlColumn<Integer> categoryRatio = column("category_ratio", JDBCType.INTEGER);

        public final SqlColumn<String> storageProviderName = column("`storage_ provider_name`", JDBCType.VARCHAR);

        public final SqlColumn<String> carrierName = column("carrier_name", JDBCType.VARCHAR);

        public final SqlColumn<String> categoryName = column("category_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> riskIndex = column("risk_index", JDBCType.INTEGER);

        public PlatformDailyStatistics() {
            super("platform_daily_statistics");
        }
    }
}