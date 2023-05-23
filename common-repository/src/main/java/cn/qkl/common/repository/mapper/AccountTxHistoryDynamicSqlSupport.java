package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AccountTxHistoryDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final AccountTxHistory accountTxHistory = new AccountTxHistory();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = accountTxHistory.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> txHash = accountTxHistory.txHash;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> method = accountTxHistory.method;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> block = accountTxHistory.block;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> txTimestamp = accountTxHistory.txTimestamp;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> from = accountTxHistory.from;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> to = accountTxHistory.to;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> value = accountTxHistory.value;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> txFee = accountTxHistory.txFee;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> chainId = accountTxHistory.chainId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = accountTxHistory.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = accountTxHistory.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class AccountTxHistory extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> txHash = column("tx_hash", JDBCType.VARCHAR);

        public final SqlColumn<String> method = column("`method`", JDBCType.VARCHAR);

        public final SqlColumn<Long> block = column("block", JDBCType.BIGINT);

        public final SqlColumn<Date> txTimestamp = column("tx_timestamp", JDBCType.TIMESTAMP);

        public final SqlColumn<String> from = column("`from`", JDBCType.VARCHAR);

        public final SqlColumn<String> to = column("`to`", JDBCType.VARCHAR);

        public final SqlColumn<String> value = column("`value`", JDBCType.VARCHAR);

        public final SqlColumn<String> txFee = column("tx_fee", JDBCType.VARCHAR);

        public final SqlColumn<Long> chainId = column("chain_id", JDBCType.BIGINT);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public AccountTxHistory() {
            super("account_tx_history");
        }
    }
}