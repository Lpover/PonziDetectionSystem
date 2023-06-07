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

        public Account() {
            super("account");
        }
    }
}