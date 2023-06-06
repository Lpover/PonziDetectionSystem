package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SettingsMonitorRulesDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SettingsMonitorRules settingsMonitorRules = new SettingsMonitorRules();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = settingsMonitorRules.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> type = settingsMonitorRules.type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> monitorFrequency = settingsMonitorRules.monitorFrequency;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> lastMonitorTime = settingsMonitorRules.lastMonitorTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = settingsMonitorRules.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = settingsMonitorRules.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class SettingsMonitorRules extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Integer> type = column("`type`", JDBCType.INTEGER);

        public final SqlColumn<Integer> monitorFrequency = column("monitor_frequency", JDBCType.INTEGER);

        public final SqlColumn<Date> lastMonitorTime = column("last_monitor_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public SettingsMonitorRules() {
            super("settings_monitor_rules");
        }
    }
}