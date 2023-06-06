package cn.qkl.common.repository.mapper;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SocialPlatformDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SocialPlatform socialPlatform = new SocialPlatform();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = socialPlatform.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = socialPlatform.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> socialPlatformIndex12h = socialPlatform.socialPlatformIndex12h;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> socialPlatformIndex24h = socialPlatform.socialPlatformIndex24h;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class SocialPlatform extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> socialPlatformIndex12h = column("social_platform_index_12h", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> socialPlatformIndex24h = column("social_platform_index_24h", JDBCType.DECIMAL);

        public SocialPlatform() {
            super("social_platform");
        }
    }
}