package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AccountDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Account account = new Account();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = account.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> accountAddress = account.accountAddress;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> chainId = account.chainId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> accountAlias = account.accountAlias;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> image = account.image;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> cryptoBalance = account.cryptoBalance;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> currencyBalance = account.currencyBalance;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> exchangeRate = account.exchangeRate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = account.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = account.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> platformId = account.platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> releaseNum = account.releaseNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> riskLevel = account.riskLevel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> note = account.note;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> inflowAmount = account.inflowAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> actionFeatures = account.actionFeatures;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> contentTag = account.contentTag;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> riskTxNumIn = account.riskTxNumIn;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> riskTxNumOut = account.riskTxNumOut;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> riskContentNum = account.riskContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> recentTxTime = account.recentTxTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Account extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> accountAddress = column("account_address", JDBCType.VARCHAR);

        public final SqlColumn<Long> chainId = column("chain_id", JDBCType.BIGINT);

        public final SqlColumn<String> accountAlias = column("account_alias", JDBCType.VARCHAR);

        public final SqlColumn<String> image = column("image", JDBCType.VARCHAR);

        public final SqlColumn<String> cryptoBalance = column("crypto_balance", JDBCType.VARCHAR);

        public final SqlColumn<String> currencyBalance = column("currency_balance", JDBCType.VARCHAR);

        public final SqlColumn<String> exchangeRate = column("exchange_rate", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> platformId = column("platform_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> releaseNum = column("release_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> riskLevel = column("risk_level", JDBCType.INTEGER);

        public final SqlColumn<String> note = column("note", JDBCType.VARCHAR);

        public final SqlColumn<Long> inflowAmount = column("inflow_amount", JDBCType.BIGINT);

        public final SqlColumn<String> actionFeatures = column("action_features", JDBCType.VARCHAR);

        public final SqlColumn<String> contentTag = column("content_tag", JDBCType.VARCHAR);

        public final SqlColumn<Integer> riskTxNumIn = column("risk_tx_num_in", JDBCType.INTEGER);

        public final SqlColumn<Integer> riskTxNumOut = column("risk_tx_num_out", JDBCType.INTEGER);

        public final SqlColumn<Integer> riskContentNum = column("risk_content_num", JDBCType.INTEGER);

        public final SqlColumn<Date> recentTxTime = column("recent_tx_time", JDBCType.TIMESTAMP);

        public Account() {
            super("account");
        }
    }
}