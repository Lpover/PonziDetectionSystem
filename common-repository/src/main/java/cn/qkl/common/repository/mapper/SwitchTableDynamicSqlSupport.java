package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SwitchTableDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SwitchTable switchTable = new SwitchTable();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = switchTable.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> open = switchTable.open;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> openWeek = switchTable.openWeek;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> startTime = switchTable.startTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> endTime = switchTable.endTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> text = switchTable.text;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class SwitchTable extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Integer> open = column("`open`", JDBCType.INTEGER);

        public final SqlColumn<Integer> openWeek = column("open_week", JDBCType.INTEGER);

        public final SqlColumn<Date> startTime = column("start_time", JDBCType.TIME);

        public final SqlColumn<Date> endTime = column("end_time", JDBCType.TIME);

        public final SqlColumn<String> text = column("`text`", JDBCType.VARCHAR);

        public SwitchTable() {
            super("switch_table");
        }
    }
}