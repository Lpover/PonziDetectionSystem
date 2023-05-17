package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ChainDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Chain chain = new Chain();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = chain.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> chainName = chain.chainName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> chainCryptoUnit = chain.chainCryptoUnit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> chainLogoUrl = chain.chainLogoUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = chain.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = chain.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Chain extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> chainName = column("chain_name", JDBCType.VARCHAR);

        public final SqlColumn<String> chainCryptoUnit = column("chain_crypto_unit", JDBCType.VARCHAR);

        public final SqlColumn<String> chainLogoUrl = column("chain_logo_url", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public Chain() {
            super("chain");
        }
    }
}