package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class EvidenceWebDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final EvidenceWeb evidenceWeb = new EvidenceWeb();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = evidenceWeb.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = evidenceWeb.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> riskType = evidenceWeb.riskType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> introduction = evidenceWeb.introduction;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> personnel = evidenceWeb.personnel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> url = evidenceWeb.url;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> platformId = evidenceWeb.platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> institution = evidenceWeb.institution;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> department = evidenceWeb.department;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> webOssPath = evidenceWeb.webOssPath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> certOssPath = evidenceWeb.certOssPath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> packOssPath = evidenceWeb.packOssPath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> evidencePhase = evidenceWeb.evidencePhase;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> evidenceType = evidenceWeb.evidenceType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> hash = evidenceWeb.hash;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> chainTime = evidenceWeb.chainTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = evidenceWeb.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = evidenceWeb.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> deleteStatus = evidenceWeb.deleteStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> packageHash = evidenceWeb.packageHash;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> chainId = evidenceWeb.chainId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> frequency = evidenceWeb.frequency;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> startTime = evidenceWeb.startTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> endTime = evidenceWeb.endTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> dayOfWeek = evidenceWeb.dayOfWeek;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> dayOfMonth = evidenceWeb.dayOfMonth;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> contentId = evidenceWeb.contentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> nextEvidenceTime = evidenceWeb.nextEvidenceTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class EvidenceWeb extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<String> riskType = column("risk_type", JDBCType.VARCHAR);

        public final SqlColumn<String> introduction = column("introduction", JDBCType.VARCHAR);

        public final SqlColumn<String> personnel = column("personnel", JDBCType.VARCHAR);

        public final SqlColumn<String> url = column("url", JDBCType.VARCHAR);

        public final SqlColumn<Long> platformId = column("platform_id", JDBCType.BIGINT);

        public final SqlColumn<String> institution = column("institution", JDBCType.VARCHAR);

        public final SqlColumn<String> department = column("department", JDBCType.VARCHAR);

        public final SqlColumn<String> webOssPath = column("web_oss_path", JDBCType.VARCHAR);

        public final SqlColumn<String> certOssPath = column("cert_oss_path", JDBCType.VARCHAR);

        public final SqlColumn<String> packOssPath = column("pack_oss_path", JDBCType.VARCHAR);

        public final SqlColumn<Integer> evidencePhase = column("evidence_phase", JDBCType.INTEGER);

        public final SqlColumn<Integer> evidenceType = column("evidence_type", JDBCType.INTEGER);

        public final SqlColumn<String> hash = column("hash", JDBCType.VARCHAR);

        public final SqlColumn<Date> chainTime = column("chain_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> deleteStatus = column("delete_status", JDBCType.INTEGER);

        public final SqlColumn<String> packageHash = column("package_hash", JDBCType.VARCHAR);

        public final SqlColumn<Long> chainId = column("chain_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> frequency = column("frequency", JDBCType.INTEGER);

        public final SqlColumn<Date> startTime = column("start_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> endTime = column("end_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> dayOfWeek = column("day_of_week", JDBCType.INTEGER);

        public final SqlColumn<Integer> dayOfMonth = column("day_of_month", JDBCType.INTEGER);

        public final SqlColumn<Long> contentId = column("content_id", JDBCType.BIGINT);

        public final SqlColumn<Date> nextEvidenceTime = column("next_evidence_time", JDBCType.TIMESTAMP);

        public EvidenceWeb() {
            super("evidence_web");
        }
    }
}