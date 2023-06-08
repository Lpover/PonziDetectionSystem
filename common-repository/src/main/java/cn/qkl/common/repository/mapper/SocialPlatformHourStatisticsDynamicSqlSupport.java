package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SocialPlatformHourStatisticsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SocialPlatformHourStatistics socialPlatformHourStatistics = new SocialPlatformHourStatistics();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = socialPlatformHourStatistics.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> socialPlatformId = socialPlatformHourStatistics.socialPlatformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = socialPlatformHourStatistics.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = socialPlatformHourStatistics.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> sensitiveNum = socialPlatformHourStatistics.sensitiveNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> nonSensitiveNum = socialPlatformHourStatistics.nonSensitiveNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> posEmotionNum = socialPlatformHourStatistics.posEmotionNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> negEmotionNum = socialPlatformHourStatistics.negEmotionNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class SocialPlatformHourStatistics extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> socialPlatformId = column("social_platform_id", JDBCType.BIGINT);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> sensitiveNum = column("sensitive_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> nonSensitiveNum = column("non_sensitive_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> posEmotionNum = column("pos_emotion_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> negEmotionNum = column("neg_emotion_num", JDBCType.INTEGER);

        public SocialPlatformHourStatistics() {
            super("social_platform_hour_statistics");
        }
    }
}