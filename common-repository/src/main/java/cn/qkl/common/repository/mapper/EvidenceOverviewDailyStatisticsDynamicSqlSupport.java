package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class EvidenceOverviewDailyStatisticsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final EvidenceOverviewDailyStatistics evidenceOverviewDailyStatistics = new EvidenceOverviewDailyStatistics();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = evidenceOverviewDailyStatistics.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> platformId = evidenceOverviewDailyStatistics.platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> webEvidenceCount = evidenceOverviewDailyStatistics.webEvidenceCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> mobileEvidenceCount = evidenceOverviewDailyStatistics.mobileEvidenceCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> reinforceEvidenceCount = evidenceOverviewDailyStatistics.reinforceEvidenceCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = evidenceOverviewDailyStatistics.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = evidenceOverviewDailyStatistics.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class EvidenceOverviewDailyStatistics extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> platformId = column("platform_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> webEvidenceCount = column("web_evidence_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> mobileEvidenceCount = column("mobile_evidence_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> reinforceEvidenceCount = column("reinforce_evidence_count", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public EvidenceOverviewDailyStatistics() {
            super("evidence_overview_daily_statistics");
        }
    }
}