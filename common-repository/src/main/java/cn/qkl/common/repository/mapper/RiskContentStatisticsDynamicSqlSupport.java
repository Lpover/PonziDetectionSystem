package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RiskContentStatisticsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final RiskContentStatistics riskContentStatistics = new RiskContentStatistics();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = riskContentStatistics.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = riskContentStatistics.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> lowRiskNum = riskContentStatistics.lowRiskNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> middleRiskNum = riskContentStatistics.middleRiskNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> highRiskNum = riskContentStatistics.highRiskNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> platformId = riskContentStatistics.platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = riskContentStatistics.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> contentSum = riskContentStatistics.contentSum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class RiskContentStatistics extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> lowRiskNum = column("low_risk_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> middleRiskNum = column("middle_risk_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> highRiskNum = column("high_risk_num", JDBCType.INTEGER);

        public final SqlColumn<Long> platformId = column("platform_id", JDBCType.BIGINT);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> contentSum = column("content_sum", JDBCType.INTEGER);

        public RiskContentStatistics() {
            super("risk_content_statistics");
        }
    }
}