package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ContentTxHistoryDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ContentTxHistory contentTxHistory = new ContentTxHistory();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = contentTxHistory.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> contentId = contentTxHistory.contentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> event = contentTxHistory.event;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> price = contentTxHistory.price;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> from = contentTxHistory.from;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> to = contentTxHistory.to;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> ownerLogo = contentTxHistory.ownerLogo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = contentTxHistory.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = contentTxHistory.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ContentTxHistory extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> contentId = column("content_id", JDBCType.BIGINT);

        public final SqlColumn<Boolean> event = column("event", JDBCType.BIT);

        public final SqlColumn<String> price = column("price", JDBCType.VARCHAR);

        public final SqlColumn<String> from = column("from", JDBCType.VARCHAR);

        public final SqlColumn<String> to = column("to", JDBCType.VARCHAR);

        public final SqlColumn<String> ownerLogo = column("owner_logo", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public ContentTxHistory() {
            super("content_tx_history");
        }
    }
}