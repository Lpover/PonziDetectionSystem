package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ContentCrossDailyStatisticsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ContentCrossDailyStatistics contentCrossDailyStatistics = new ContentCrossDailyStatistics();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = contentCrossDailyStatistics.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> chainId = contentCrossDailyStatistics.chainId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> riskAccountNum = contentCrossDailyStatistics.riskAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> txNum = contentCrossDailyStatistics.txNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = contentCrossDailyStatistics.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = contentCrossDailyStatistics.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ContentCrossDailyStatistics extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> chainId = column("chain_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> riskAccountNum = column("risk_account_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> txNum = column("tx_num", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public ContentCrossDailyStatistics() {
            super("content_cross_daily_statistics");
        }
    }
}