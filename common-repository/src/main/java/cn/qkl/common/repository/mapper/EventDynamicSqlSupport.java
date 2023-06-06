package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class EventDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Event event = new Event();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = event.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> title = event.title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> abstractText = event.abstractText;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> hotNum12h = event.hotNum12h;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> hotNum24h = event.hotNum24h;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Event extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<String> abstractText = column("abstract_text", JDBCType.VARCHAR);

        public final SqlColumn<Integer> hotNum12h = column("hot_num_12h", JDBCType.INTEGER);

        public final SqlColumn<Integer> hotNum24h = column("hot_num_24h", JDBCType.INTEGER);

        public Event() {
            super("event");
        }
    }
}