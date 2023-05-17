package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PlatformDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Platform platform = new Platform();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = platform.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> named = platform.named;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> url = platform.url;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> monitor = platform.monitor;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> riskContentNum = platform.riskContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> activation = platform.activation;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> riskLevel = platform.riskLevel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updateTime = platform.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> platformType = platform.platformType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> logo = platform.logo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> location = platform.location;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> frequency = platform.frequency;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> crawlerFile = platform.crawlerFile;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> web3Type = platform.web3Type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> contentNum = platform.contentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> highAccountNum = platform.highAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> midAccountNum = platform.midAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> lowAccountNum = platform.lowAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> highContentNum = platform.highContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> midContentNum = platform.midContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> lowContentNum = platform.lowContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = platform.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updataTime = platform.updataTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Platform extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> named = column("named", JDBCType.VARCHAR);

        public final SqlColumn<String> url = column("url", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> monitor = column("monitor", JDBCType.BIT);

        public final SqlColumn<Long> riskContentNum = column("risk_content_num", JDBCType.BIGINT);

        public final SqlColumn<Boolean> activation = column("activation", JDBCType.BIT);

        public final SqlColumn<Boolean> riskLevel = column("risk_level", JDBCType.BIT);

        public final SqlColumn<Long> updateTime = column("update_time", JDBCType.BIGINT);

        public final SqlColumn<Boolean> platformType = column("platform_type", JDBCType.BIT);

        public final SqlColumn<String> logo = column("logo", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> location = column("location", JDBCType.BIT);

        public final SqlColumn<Boolean> frequency = column("frequency", JDBCType.BIT);

        public final SqlColumn<String> crawlerFile = column("crawler_file", JDBCType.VARCHAR);

        public final SqlColumn<Byte> web3Type = column("web3_type", JDBCType.TINYINT);

        public final SqlColumn<Long> contentNum = column("content_num", JDBCType.BIGINT);

        public final SqlColumn<Integer> highAccountNum = column("high_account_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> midAccountNum = column("mid_account_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> lowAccountNum = column("low_account_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> highContentNum = column("high_content_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> midContentNum = column("mid_content_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> lowContentNum = column("low_content_num", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updataTime = column("updata_time", JDBCType.TIMESTAMP);

        public Platform() {
            super("platform");
        }
    }
}