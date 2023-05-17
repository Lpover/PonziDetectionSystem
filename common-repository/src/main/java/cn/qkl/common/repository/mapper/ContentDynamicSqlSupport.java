package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ContentDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Content content = new Content();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = content.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = content.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> address = content.address;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> tokenid = content.tokenid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> metaUrl = content.metaUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> cryptoPrice = content.cryptoPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> currencyPrice = content.currencyPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> creator = content.creator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> platformId = content.platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> standard = content.standard;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> chainId = content.chainId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> listingTime = content.listingTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> description = content.description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> dynamicType = content.dynamicType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> dynamicAlgorithm = content.dynamicAlgorithm;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> dynamicRecognition = content.dynamicRecognition;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> revised = content.revised;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> riskLevel = content.riskLevel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> contentType = content.contentType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> contentTag = content.contentTag;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> riskType = content.riskType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> owner = content.owner;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> mintTime = content.mintTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> accountId = content.accountId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> thingType = content.thingType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = content.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = content.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Content extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<Integer> tokenid = column("tokenID", JDBCType.INTEGER);

        public final SqlColumn<String> metaUrl = column("meta_url", JDBCType.VARCHAR);

        public final SqlColumn<String> cryptoPrice = column("crypto_price", JDBCType.VARCHAR);

        public final SqlColumn<String> currencyPrice = column("currency_price", JDBCType.VARCHAR);

        public final SqlColumn<String> creator = column("creator", JDBCType.VARCHAR);

        public final SqlColumn<Long> platformId = column("platform_id", JDBCType.BIGINT);

        public final SqlColumn<String> standard = column("standard", JDBCType.VARCHAR);

        public final SqlColumn<Long> chainId = column("chain_id", JDBCType.BIGINT);

        public final SqlColumn<Date> listingTime = column("listing_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<Integer> dynamicType = column("dynamic_type", JDBCType.INTEGER);

        public final SqlColumn<Integer> dynamicAlgorithm = column("dynamic_algorithm", JDBCType.INTEGER);

        public final SqlColumn<Integer> dynamicRecognition = column("dynamic_recognition", JDBCType.INTEGER);

        public final SqlColumn<Integer> revised = column("revised", JDBCType.INTEGER);

        public final SqlColumn<Integer> riskLevel = column("risk_level", JDBCType.INTEGER);

        public final SqlColumn<Integer> contentType = column("content_type", JDBCType.INTEGER);

        public final SqlColumn<String> contentTag = column("content_tag", JDBCType.VARCHAR);

        public final SqlColumn<String> riskType = column("risk_type", JDBCType.VARCHAR);

        public final SqlColumn<String> owner = column("owner", JDBCType.VARCHAR);

        public final SqlColumn<Date> mintTime = column("mint_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> accountId = column("account_id", JDBCType.BIGINT);

        public final SqlColumn<String> thingType = column("thing_type", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public Content() {
            super("content");
        }
    }
}