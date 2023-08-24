package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AtaExportTaskDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final AtaExportTask ataExportTask = new AtaExportTask();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = ataExportTask.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> blockchain = ataExportTask.blockchain;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> currencyType = ataExportTask.currencyType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> address = ataExportTask.address;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> direction = ataExportTask.direction;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> lowerLimit = ataExportTask.lowerLimit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> startTime = ataExportTask.startTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> endTime = ataExportTask.endTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class AtaExportTask extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> blockchain = column("blockchain", JDBCType.VARCHAR);

        public final SqlColumn<String> currencyType = column("currency_type", JDBCType.VARCHAR);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<String> direction = column("direction", JDBCType.VARCHAR);

        public final SqlColumn<String> lowerLimit = column("lower_limit", JDBCType.VARCHAR);

        public final SqlColumn<Date> startTime = column("start_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> endTime = column("end_time", JDBCType.TIMESTAMP);

        public AtaExportTask() {
            super("ata_export_task");
        }
    }
}