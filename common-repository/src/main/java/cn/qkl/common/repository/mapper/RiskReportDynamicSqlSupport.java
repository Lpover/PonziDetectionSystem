package cn.qkl.common.repository.mapper;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RiskReportDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final RiskReport riskReport = new RiskReport();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = riskReport.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> riskContentNum = riskReport.riskContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> evolutionNum = riskReport.evolutionNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> highAccountNum = riskReport.highAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> midAccountNum = riskReport.midAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> lowAccountNum = riskReport.lowAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> nftId = riskReport.nftId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> nftNum = riskReport.nftNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> web3Id = riskReport.web3Id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> web3Num = riskReport.web3Num;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> highContentNum = riskReport.highContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> midContentNum = riskReport.midContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> lowContentNum = riskReport.lowContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> dynNum = riskReport.dynNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> monitorNum = riskReport.monitorNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> highRiskPlat = riskReport.highRiskPlat;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> midRiskPlat = riskReport.midRiskPlat;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> lowRiskPlat = riskReport.lowRiskPlat;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> highRiskPlatPer = riskReport.highRiskPlatPer;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> midRiskPlatPer = riskReport.midRiskPlatPer;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> lowRiskPlatPer = riskReport.lowRiskPlatPer;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> highNamePlat = riskReport.highNamePlat;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> highNumPlat = riskReport.highNumPlat;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = riskReport.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = riskReport.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class RiskReport extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Integer> riskContentNum = column("risk_content_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> evolutionNum = column("evolution_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> highAccountNum = column("high_account_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> midAccountNum = column("mid_account_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> lowAccountNum = column("low_account_num", JDBCType.INTEGER);

        public final SqlColumn<Long> nftId = column("nft_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> nftNum = column("nft_num", JDBCType.INTEGER);

        public final SqlColumn<Long> web3Id = column("web3_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> web3Num = column("web3_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> highContentNum = column("high_content_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> midContentNum = column("mid_content_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> lowContentNum = column("low_content_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> dynNum = column("dyn_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> monitorNum = column("monitor_num", JDBCType.INTEGER);

        public final SqlColumn<String> highRiskPlat = column("high_risk_plat", JDBCType.VARCHAR);

        public final SqlColumn<String> midRiskPlat = column("mid_risk_plat", JDBCType.VARCHAR);

        public final SqlColumn<String> lowRiskPlat = column("low_risk_plat", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> highRiskPlatPer = column("high_risk_plat_per", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> midRiskPlatPer = column("mid_risk_plat_per", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> lowRiskPlatPer = column("low_risk_plat_per", JDBCType.DECIMAL);

        public final SqlColumn<String> highNamePlat = column("high_name_plat", JDBCType.VARCHAR);

        public final SqlColumn<Integer> highNumPlat = column("high_num_plat", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public RiskReport() {
            super("risk_report");
        }
    }
}