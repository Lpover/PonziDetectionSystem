package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class MiniappEvidenceDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final MiniappEvidence miniappEvidence = new MiniappEvidence();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = miniappEvidence.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = miniappEvidence.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> time = miniappEvidence.time;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> expiredTime = miniappEvidence.expiredTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> url = miniappEvidence.url;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> userid = miniappEvidence.userid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> preserved = miniappEvidence.preserved;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> videoTime = miniappEvidence.videoTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> videoSize = miniappEvidence.videoSize;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> packOssPath = miniappEvidence.packOssPath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> evidencePhase = miniappEvidence.evidencePhase;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class MiniappEvidence extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<Date> time = column("`time`", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> expiredTime = column("expired_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> url = column("url", JDBCType.VARCHAR);

        public final SqlColumn<Long> userid = column("userId", JDBCType.BIGINT);

        public final SqlColumn<Integer> preserved = column("preserved", JDBCType.INTEGER);

        public final SqlColumn<Long> videoTime = column("video_time", JDBCType.BIGINT);

        public final SqlColumn<Long> videoSize = column("video_size", JDBCType.BIGINT);

        public final SqlColumn<String> packOssPath = column("pack_oss_path", JDBCType.VARCHAR);

        public final SqlColumn<Integer> evidencePhase = column("evidence_phase", JDBCType.INTEGER);

        public MiniappEvidence() {
            super("miniapp_evidence");
        }
    }
}