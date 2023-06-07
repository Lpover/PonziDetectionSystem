package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ContentRiskDailyStatisticsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ContentRiskDailyStatistics contentRiskDailyStatistics = new ContentRiskDailyStatistics();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = contentRiskDailyStatistics.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> categoryId = contentRiskDailyStatistics.categoryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> num = contentRiskDailyStatistics.num;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> platformId = contentRiskDailyStatistics.platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = contentRiskDailyStatistics.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = contentRiskDailyStatistics.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ContentRiskDailyStatistics extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> categoryId = column("category_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> num = column("num", JDBCType.INTEGER);

        public final SqlColumn<Long> platformId = column("platform_id", JDBCType.BIGINT);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public ContentRiskDailyStatistics() {
            super("content_risk_daily_statistics");
        }
    }
}