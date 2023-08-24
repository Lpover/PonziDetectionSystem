package cn.qkl.common.repository.mapper;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AccountToAccountDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final AccountToAccount accountToAccount = new AccountToAccount();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = accountToAccount.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> from = accountToAccount.from;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> to = accountToAccount.to;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> fromRiskIndex = accountToAccount.fromRiskIndex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> toRiskIndex = accountToAccount.toRiskIndex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> txAmount = accountToAccount.txAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> txNum = accountToAccount.txNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> fromRatio = accountToAccount.fromRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> toRatio = accountToAccount.toRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> blockchain = accountToAccount.blockchain;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> currencyType = accountToAccount.currencyType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> note = accountToAccount.note;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = accountToAccount.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = accountToAccount.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> protocols = accountToAccount.protocols;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> wContract = accountToAccount.wContract;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> wTransaction = accountToAccount.wTransaction;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> wWallet = accountToAccount.wWallet;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> wHybrid = accountToAccount.wHybrid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> label = accountToAccount.label;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> toAmount = accountToAccount.toAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> fromAmount = accountToAccount.fromAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> toNum = accountToAccount.toNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> fromNum = accountToAccount.fromNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> toCounter = accountToAccount.toCounter;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> fromCounter = accountToAccount.fromCounter;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class AccountToAccount extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> from = column("`from`", JDBCType.VARCHAR);

        public final SqlColumn<String> to = column("`to`", JDBCType.VARCHAR);

        public final SqlColumn<Integer> fromRiskIndex = column("from_risk_index", JDBCType.INTEGER);

        public final SqlColumn<Integer> toRiskIndex = column("to_risk_index", JDBCType.INTEGER);

        public final SqlColumn<Long> txAmount = column("tx_amount", JDBCType.BIGINT);

        public final SqlColumn<Long> txNum = column("tx_num", JDBCType.BIGINT);

        public final SqlColumn<BigDecimal> fromRatio = column("from_ratio", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> toRatio = column("to_ratio", JDBCType.DECIMAL);

        public final SqlColumn<String> blockchain = column("blockchain", JDBCType.VARCHAR);

        public final SqlColumn<String> currencyType = column("currency_type", JDBCType.VARCHAR);

        public final SqlColumn<String> note = column("note", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> protocols = column("protocols", JDBCType.VARCHAR);

        public final SqlColumn<String> wContract = column("w_contract", JDBCType.VARCHAR);

        public final SqlColumn<String> wTransaction = column("w_transaction", JDBCType.VARCHAR);

        public final SqlColumn<String> wWallet = column("w_wallet", JDBCType.VARCHAR);

        public final SqlColumn<String> wHybrid = column("w_hybrid", JDBCType.VARCHAR);

        public final SqlColumn<String> label = column("`label`", JDBCType.VARCHAR);

        public final SqlColumn<Long> toAmount = column("to_amount", JDBCType.BIGINT);

        public final SqlColumn<Long> fromAmount = column("from_amount", JDBCType.BIGINT);

        public final SqlColumn<Long> toNum = column("to_num", JDBCType.BIGINT);

        public final SqlColumn<Long> fromNum = column("from_num", JDBCType.BIGINT);

        public final SqlColumn<Long> toCounter = column("to_counter", JDBCType.BIGINT);

        public final SqlColumn<Long> fromCounter = column("from_counter", JDBCType.BIGINT);

        public AccountToAccount() {
            super("account_to_account");
        }
    }
}