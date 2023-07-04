package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ThresholdsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Thresholds thresholds = new Thresholds();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = thresholds.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = thresholds.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> nowIndex = thresholds.nowIndex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> setIndex = thresholds.setIndex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = thresholds.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = thresholds.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> on = thresholds.on;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> num = thresholds.num;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Thresholds extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<Integer> nowIndex = column("now_index", JDBCType.INTEGER);

        public final SqlColumn<Integer> setIndex = column("set_index", JDBCType.INTEGER);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> on = column("`on`", JDBCType.INTEGER);

        public final SqlColumn<Integer> num = column("num", JDBCType.INTEGER);

        public Thresholds() {
            super("thresholds");
        }
    }
}