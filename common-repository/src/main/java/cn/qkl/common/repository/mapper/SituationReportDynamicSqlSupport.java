package cn.qkl.common.repository.mapper;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SituationReportDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SituationReport situationReport = new SituationReport();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = situationReport.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> platformName = situationReport.platformName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> carrierPic = situationReport.carrierPic;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> carrierVie = situationReport.carrierVie;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> carrierOth = situationReport.carrierOth;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> categoryDyn = situationReport.categoryDyn;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> categorySta = situationReport.categorySta;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> categoryOth = situationReport.categoryOth;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> txRatioLow = situationReport.txRatioLow;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> txRatioMid = situationReport.txRatioMid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> txRatioHigh = situationReport.txRatioHigh;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> riskWordMostNum = situationReport.riskWordMostNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> riskWordMostName = situationReport.riskWordMostName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> riskWordLeastNum = situationReport.riskWordLeastNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> riskWordLeastName = situationReport.riskWordLeastName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> contentNumRatio = situationReport.contentNumRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> ratioPositive = situationReport.ratioPositive;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> ratioNegative = situationReport.ratioNegative;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> platRatioHigh = situationReport.platRatioHigh;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> platRatioMid = situationReport.platRatioMid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> platRatioLow = situationReport.platRatioLow;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> warningNum = situationReport.warningNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> top5TopicsContent = situationReport.top5TopicsContent;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> top5TopicsSocial = situationReport.top5TopicsSocial;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> top3Words = situationReport.top3Words;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = situationReport.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = situationReport.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> monitorNumHigh = situationReport.monitorNumHigh;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> monitorNumMid = situationReport.monitorNumMid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> monitorNumLow = situationReport.monitorNumLow;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> platNameLow = situationReport.platNameLow;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> platNameMid = situationReport.platNameMid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> platNameHigh = situationReport.platNameHigh;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> nftPlatformName = situationReport.nftPlatformName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> nftPlatformHotness = situationReport.nftPlatformHotness;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> nftPlatformHotnessChange = situationReport.nftPlatformHotnessChange;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> web3PlatformName = situationReport.web3PlatformName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> web3PlatformHotness = situationReport.web3PlatformHotness;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> web3PlatformHotnessChange = situationReport.web3PlatformHotnessChange;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> riskNameHigh = situationReport.riskNameHigh;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> riskIndexHigh = situationReport.riskIndexHigh;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> riskNameLow = situationReport.riskNameLow;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> riskIndexLow = situationReport.riskIndexLow;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class SituationReport extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> platformName = column("platform_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> carrierPic = column("carrier_pic", JDBCType.INTEGER);

        public final SqlColumn<Integer> carrierVie = column("carrier_vie", JDBCType.INTEGER);

        public final SqlColumn<Integer> carrierOth = column("carrier_oth", JDBCType.INTEGER);

        public final SqlColumn<Integer> categoryDyn = column("category_dyn", JDBCType.INTEGER);

        public final SqlColumn<Integer> categorySta = column("category_sta", JDBCType.INTEGER);

        public final SqlColumn<Integer> categoryOth = column("category_oth", JDBCType.INTEGER);

        public final SqlColumn<Integer> txRatioLow = column("tx_ratio_low", JDBCType.INTEGER);

        public final SqlColumn<Integer> txRatioMid = column("tx_ratio_mid", JDBCType.INTEGER);

        public final SqlColumn<Integer> txRatioHigh = column("tx_ratio_high", JDBCType.INTEGER);

        public final SqlColumn<Integer> riskWordMostNum = column("risk_word_most_num", JDBCType.INTEGER);

        public final SqlColumn<String> riskWordMostName = column("risk_word_most_name", JDBCType.VARCHAR);

        public final SqlColumn<Long> riskWordLeastNum = column("risk_word_least_num", JDBCType.BIGINT);

        public final SqlColumn<String> riskWordLeastName = column("risk_word_least_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> contentNumRatio = column("content_num_ratio", JDBCType.INTEGER);

        public final SqlColumn<Integer> ratioPositive = column("ratio_positive", JDBCType.INTEGER);

        public final SqlColumn<Integer> ratioNegative = column("ratio_negative", JDBCType.INTEGER);

        public final SqlColumn<Integer> platRatioHigh = column("plat_ratio_high", JDBCType.INTEGER);

        public final SqlColumn<Integer> platRatioMid = column("plat_ratio_mid", JDBCType.INTEGER);

        public final SqlColumn<Integer> platRatioLow = column("plat_ratio_low", JDBCType.INTEGER);

        public final SqlColumn<Integer> warningNum = column("warning_num", JDBCType.INTEGER);

        public final SqlColumn<String> top5TopicsContent = column("top5_topics_content", JDBCType.VARCHAR);

        public final SqlColumn<String> top5TopicsSocial = column("top5_topics_social", JDBCType.VARCHAR);

        public final SqlColumn<String> top3Words = column("top3_words", JDBCType.VARCHAR);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> monitorNumHigh = column("monitor_num_high", JDBCType.INTEGER);

        public final SqlColumn<Integer> monitorNumMid = column("monitor_num_mid", JDBCType.INTEGER);

        public final SqlColumn<Integer> monitorNumLow = column("monitor_num_low", JDBCType.INTEGER);

        public final SqlColumn<String> platNameLow = column("plat_name_low", JDBCType.VARCHAR);

        public final SqlColumn<String> platNameMid = column("plat_name_mid", JDBCType.VARCHAR);

        public final SqlColumn<String> platNameHigh = column("plat_name_high", JDBCType.VARCHAR);

        public final SqlColumn<String> nftPlatformName = column("nft_platform_name", JDBCType.VARCHAR);

        public final SqlColumn<Long> nftPlatformHotness = column("nft_platform_hotness", JDBCType.BIGINT);

        public final SqlColumn<BigDecimal> nftPlatformHotnessChange = column("nft_platform_hotness_change", JDBCType.DECIMAL);

        public final SqlColumn<String> web3PlatformName = column("web3_platform_name", JDBCType.VARCHAR);

        public final SqlColumn<Long> web3PlatformHotness = column("web3_platform_hotness", JDBCType.BIGINT);

        public final SqlColumn<BigDecimal> web3PlatformHotnessChange = column("web3_platform_hotness_change", JDBCType.DECIMAL);

        public final SqlColumn<String> riskNameHigh = column("risk_name_high", JDBCType.VARCHAR);

        public final SqlColumn<Integer> riskIndexHigh = column("risk_index_high", JDBCType.INTEGER);

        public final SqlColumn<String> riskNameLow = column("risk_name_low", JDBCType.VARCHAR);

        public final SqlColumn<Integer> riskIndexLow = column("risk_index_low", JDBCType.INTEGER);

        public SituationReport() {
            super("situation_report");
        }
    }
}