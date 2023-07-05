package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.SituationReportDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.SituationReport;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface SituationReportMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, platformName, carrierPic, carrierVie, carrierOth, categoryDyn, categorySta, categoryOth, txRatioLow, txRatioMid, txRatioHigh, riskWordMostNum, riskWordMostName, riskWordLeastNum, riskWordLeastName, contentNumRatio, ratioPositive, ratioNegative, platRatioHigh, platRatioMid, platRatioLow, warningNum, top5TopicsContent, top5TopicsSocial, top3Words, updateTime, createTime, monitorNumHigh, monitorNumMid, monitorNumLow, platNameLow, platNameMid, platNameHigh, nftPlatformName, nftPlatformHotness, nftPlatformHotnessChange, web3PlatformName, web3PlatformHotness, web3PlatformHotnessChange, riskNameHigh, riskIndexHigh, riskNameLow, riskIndexLow);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SituationReport> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SituationReport> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SituationReportResult")
    Optional<SituationReport> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SituationReportResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="platform_name", property="platformName", jdbcType=JdbcType.VARCHAR),
        @Result(column="carrier_pic", property="carrierPic", jdbcType=JdbcType.INTEGER),
        @Result(column="carrier_vie", property="carrierVie", jdbcType=JdbcType.INTEGER),
        @Result(column="carrier_oth", property="carrierOth", jdbcType=JdbcType.INTEGER),
        @Result(column="category_dyn", property="categoryDyn", jdbcType=JdbcType.INTEGER),
        @Result(column="category_sta", property="categorySta", jdbcType=JdbcType.INTEGER),
        @Result(column="category_oth", property="categoryOth", jdbcType=JdbcType.INTEGER),
        @Result(column="tx_ratio_low", property="txRatioLow", jdbcType=JdbcType.INTEGER),
        @Result(column="tx_ratio_mid", property="txRatioMid", jdbcType=JdbcType.INTEGER),
        @Result(column="tx_ratio_high", property="txRatioHigh", jdbcType=JdbcType.INTEGER),
        @Result(column="risk_word_most_num", property="riskWordMostNum", jdbcType=JdbcType.INTEGER),
        @Result(column="risk_word_most_name", property="riskWordMostName", jdbcType=JdbcType.VARCHAR),
        @Result(column="risk_word_least_num", property="riskWordLeastNum", jdbcType=JdbcType.BIGINT),
        @Result(column="risk_word_least_name", property="riskWordLeastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="content_num_ratio", property="contentNumRatio", jdbcType=JdbcType.INTEGER),
        @Result(column="ratio_positive", property="ratioPositive", jdbcType=JdbcType.INTEGER),
        @Result(column="ratio_negative", property="ratioNegative", jdbcType=JdbcType.INTEGER),
        @Result(column="plat_ratio_high", property="platRatioHigh", jdbcType=JdbcType.INTEGER),
        @Result(column="plat_ratio_mid", property="platRatioMid", jdbcType=JdbcType.INTEGER),
        @Result(column="plat_ratio_low", property="platRatioLow", jdbcType=JdbcType.INTEGER),
        @Result(column="warning_num", property="warningNum", jdbcType=JdbcType.INTEGER),
        @Result(column="top5_topics_content", property="top5TopicsContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="top5_topics_social", property="top5TopicsSocial", jdbcType=JdbcType.VARCHAR),
        @Result(column="top3_words", property="top3Words", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="monitor_num_high", property="monitorNumHigh", jdbcType=JdbcType.INTEGER),
        @Result(column="monitor_num_mid", property="monitorNumMid", jdbcType=JdbcType.INTEGER),
        @Result(column="monitor_num_low", property="monitorNumLow", jdbcType=JdbcType.INTEGER),
        @Result(column="plat_name_low", property="platNameLow", jdbcType=JdbcType.VARCHAR),
        @Result(column="plat_name_mid", property="platNameMid", jdbcType=JdbcType.VARCHAR),
        @Result(column="plat_name_high", property="platNameHigh", jdbcType=JdbcType.VARCHAR),
        @Result(column="nft_platform_name", property="nftPlatformName", jdbcType=JdbcType.VARCHAR),
        @Result(column="nft_platform_hotness", property="nftPlatformHotness", jdbcType=JdbcType.BIGINT),
        @Result(column="nft_platform_hotness_change", property="nftPlatformHotnessChange", jdbcType=JdbcType.DECIMAL),
        @Result(column="web3_platform_name", property="web3PlatformName", jdbcType=JdbcType.VARCHAR),
        @Result(column="web3_platform_hotness", property="web3PlatformHotness", jdbcType=JdbcType.BIGINT),
        @Result(column="web3_platform_hotness_change", property="web3PlatformHotnessChange", jdbcType=JdbcType.DECIMAL),
        @Result(column="risk_name_high", property="riskNameHigh", jdbcType=JdbcType.VARCHAR),
        @Result(column="risk_index_high", property="riskIndexHigh", jdbcType=JdbcType.INTEGER),
        @Result(column="risk_name_low", property="riskNameLow", jdbcType=JdbcType.VARCHAR),
        @Result(column="risk_index_low", property="riskIndexLow", jdbcType=JdbcType.INTEGER)
    })
    List<SituationReport> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, situationReport, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, situationReport, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SituationReport record) {
        return MyBatis3Utils.insert(this::insert, record, situationReport, c ->
            c.map(id).toProperty("id")
            .map(platformName).toProperty("platformName")
            .map(carrierPic).toProperty("carrierPic")
            .map(carrierVie).toProperty("carrierVie")
            .map(carrierOth).toProperty("carrierOth")
            .map(categoryDyn).toProperty("categoryDyn")
            .map(categorySta).toProperty("categorySta")
            .map(categoryOth).toProperty("categoryOth")
            .map(txRatioLow).toProperty("txRatioLow")
            .map(txRatioMid).toProperty("txRatioMid")
            .map(txRatioHigh).toProperty("txRatioHigh")
            .map(riskWordMostNum).toProperty("riskWordMostNum")
            .map(riskWordMostName).toProperty("riskWordMostName")
            .map(riskWordLeastNum).toProperty("riskWordLeastNum")
            .map(riskWordLeastName).toProperty("riskWordLeastName")
            .map(contentNumRatio).toProperty("contentNumRatio")
            .map(ratioPositive).toProperty("ratioPositive")
            .map(ratioNegative).toProperty("ratioNegative")
            .map(platRatioHigh).toProperty("platRatioHigh")
            .map(platRatioMid).toProperty("platRatioMid")
            .map(platRatioLow).toProperty("platRatioLow")
            .map(warningNum).toProperty("warningNum")
            .map(top5TopicsContent).toProperty("top5TopicsContent")
            .map(top5TopicsSocial).toProperty("top5TopicsSocial")
            .map(top3Words).toProperty("top3Words")
            .map(updateTime).toProperty("updateTime")
            .map(createTime).toProperty("createTime")
            .map(monitorNumHigh).toProperty("monitorNumHigh")
            .map(monitorNumMid).toProperty("monitorNumMid")
            .map(monitorNumLow).toProperty("monitorNumLow")
            .map(platNameLow).toProperty("platNameLow")
            .map(platNameMid).toProperty("platNameMid")
            .map(platNameHigh).toProperty("platNameHigh")
            .map(nftPlatformName).toProperty("nftPlatformName")
            .map(nftPlatformHotness).toProperty("nftPlatformHotness")
            .map(nftPlatformHotnessChange).toProperty("nftPlatformHotnessChange")
            .map(web3PlatformName).toProperty("web3PlatformName")
            .map(web3PlatformHotness).toProperty("web3PlatformHotness")
            .map(web3PlatformHotnessChange).toProperty("web3PlatformHotnessChange")
            .map(riskNameHigh).toProperty("riskNameHigh")
            .map(riskIndexHigh).toProperty("riskIndexHigh")
            .map(riskNameLow).toProperty("riskNameLow")
            .map(riskIndexLow).toProperty("riskIndexLow")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<SituationReport> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, situationReport, c ->
            c.map(id).toProperty("id")
            .map(platformName).toProperty("platformName")
            .map(carrierPic).toProperty("carrierPic")
            .map(carrierVie).toProperty("carrierVie")
            .map(carrierOth).toProperty("carrierOth")
            .map(categoryDyn).toProperty("categoryDyn")
            .map(categorySta).toProperty("categorySta")
            .map(categoryOth).toProperty("categoryOth")
            .map(txRatioLow).toProperty("txRatioLow")
            .map(txRatioMid).toProperty("txRatioMid")
            .map(txRatioHigh).toProperty("txRatioHigh")
            .map(riskWordMostNum).toProperty("riskWordMostNum")
            .map(riskWordMostName).toProperty("riskWordMostName")
            .map(riskWordLeastNum).toProperty("riskWordLeastNum")
            .map(riskWordLeastName).toProperty("riskWordLeastName")
            .map(contentNumRatio).toProperty("contentNumRatio")
            .map(ratioPositive).toProperty("ratioPositive")
            .map(ratioNegative).toProperty("ratioNegative")
            .map(platRatioHigh).toProperty("platRatioHigh")
            .map(platRatioMid).toProperty("platRatioMid")
            .map(platRatioLow).toProperty("platRatioLow")
            .map(warningNum).toProperty("warningNum")
            .map(top5TopicsContent).toProperty("top5TopicsContent")
            .map(top5TopicsSocial).toProperty("top5TopicsSocial")
            .map(top3Words).toProperty("top3Words")
            .map(updateTime).toProperty("updateTime")
            .map(createTime).toProperty("createTime")
            .map(monitorNumHigh).toProperty("monitorNumHigh")
            .map(monitorNumMid).toProperty("monitorNumMid")
            .map(monitorNumLow).toProperty("monitorNumLow")
            .map(platNameLow).toProperty("platNameLow")
            .map(platNameMid).toProperty("platNameMid")
            .map(platNameHigh).toProperty("platNameHigh")
            .map(nftPlatformName).toProperty("nftPlatformName")
            .map(nftPlatformHotness).toProperty("nftPlatformHotness")
            .map(nftPlatformHotnessChange).toProperty("nftPlatformHotnessChange")
            .map(web3PlatformName).toProperty("web3PlatformName")
            .map(web3PlatformHotness).toProperty("web3PlatformHotness")
            .map(web3PlatformHotnessChange).toProperty("web3PlatformHotnessChange")
            .map(riskNameHigh).toProperty("riskNameHigh")
            .map(riskIndexHigh).toProperty("riskIndexHigh")
            .map(riskNameLow).toProperty("riskNameLow")
            .map(riskIndexLow).toProperty("riskIndexLow")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SituationReport record) {
        return MyBatis3Utils.insert(this::insert, record, situationReport, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(platformName).toPropertyWhenPresent("platformName", record::getPlatformName)
            .map(carrierPic).toPropertyWhenPresent("carrierPic", record::getCarrierPic)
            .map(carrierVie).toPropertyWhenPresent("carrierVie", record::getCarrierVie)
            .map(carrierOth).toPropertyWhenPresent("carrierOth", record::getCarrierOth)
            .map(categoryDyn).toPropertyWhenPresent("categoryDyn", record::getCategoryDyn)
            .map(categorySta).toPropertyWhenPresent("categorySta", record::getCategorySta)
            .map(categoryOth).toPropertyWhenPresent("categoryOth", record::getCategoryOth)
            .map(txRatioLow).toPropertyWhenPresent("txRatioLow", record::getTxRatioLow)
            .map(txRatioMid).toPropertyWhenPresent("txRatioMid", record::getTxRatioMid)
            .map(txRatioHigh).toPropertyWhenPresent("txRatioHigh", record::getTxRatioHigh)
            .map(riskWordMostNum).toPropertyWhenPresent("riskWordMostNum", record::getRiskWordMostNum)
            .map(riskWordMostName).toPropertyWhenPresent("riskWordMostName", record::getRiskWordMostName)
            .map(riskWordLeastNum).toPropertyWhenPresent("riskWordLeastNum", record::getRiskWordLeastNum)
            .map(riskWordLeastName).toPropertyWhenPresent("riskWordLeastName", record::getRiskWordLeastName)
            .map(contentNumRatio).toPropertyWhenPresent("contentNumRatio", record::getContentNumRatio)
            .map(ratioPositive).toPropertyWhenPresent("ratioPositive", record::getRatioPositive)
            .map(ratioNegative).toPropertyWhenPresent("ratioNegative", record::getRatioNegative)
            .map(platRatioHigh).toPropertyWhenPresent("platRatioHigh", record::getPlatRatioHigh)
            .map(platRatioMid).toPropertyWhenPresent("platRatioMid", record::getPlatRatioMid)
            .map(platRatioLow).toPropertyWhenPresent("platRatioLow", record::getPlatRatioLow)
            .map(warningNum).toPropertyWhenPresent("warningNum", record::getWarningNum)
            .map(top5TopicsContent).toPropertyWhenPresent("top5TopicsContent", record::getTop5TopicsContent)
            .map(top5TopicsSocial).toPropertyWhenPresent("top5TopicsSocial", record::getTop5TopicsSocial)
            .map(top3Words).toPropertyWhenPresent("top3Words", record::getTop3Words)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(monitorNumHigh).toPropertyWhenPresent("monitorNumHigh", record::getMonitorNumHigh)
            .map(monitorNumMid).toPropertyWhenPresent("monitorNumMid", record::getMonitorNumMid)
            .map(monitorNumLow).toPropertyWhenPresent("monitorNumLow", record::getMonitorNumLow)
            .map(platNameLow).toPropertyWhenPresent("platNameLow", record::getPlatNameLow)
            .map(platNameMid).toPropertyWhenPresent("platNameMid", record::getPlatNameMid)
            .map(platNameHigh).toPropertyWhenPresent("platNameHigh", record::getPlatNameHigh)
            .map(nftPlatformName).toPropertyWhenPresent("nftPlatformName", record::getNftPlatformName)
            .map(nftPlatformHotness).toPropertyWhenPresent("nftPlatformHotness", record::getNftPlatformHotness)
            .map(nftPlatformHotnessChange).toPropertyWhenPresent("nftPlatformHotnessChange", record::getNftPlatformHotnessChange)
            .map(web3PlatformName).toPropertyWhenPresent("web3PlatformName", record::getWeb3PlatformName)
            .map(web3PlatformHotness).toPropertyWhenPresent("web3PlatformHotness", record::getWeb3PlatformHotness)
            .map(web3PlatformHotnessChange).toPropertyWhenPresent("web3PlatformHotnessChange", record::getWeb3PlatformHotnessChange)
            .map(riskNameHigh).toPropertyWhenPresent("riskNameHigh", record::getRiskNameHigh)
            .map(riskIndexHigh).toPropertyWhenPresent("riskIndexHigh", record::getRiskIndexHigh)
            .map(riskNameLow).toPropertyWhenPresent("riskNameLow", record::getRiskNameLow)
            .map(riskIndexLow).toPropertyWhenPresent("riskIndexLow", record::getRiskIndexLow)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SituationReport> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, situationReport, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SituationReport> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, situationReport, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SituationReport> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, situationReport, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SituationReport> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, situationReport, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SituationReport record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(platformName).equalTo(record::getPlatformName)
                .set(carrierPic).equalTo(record::getCarrierPic)
                .set(carrierVie).equalTo(record::getCarrierVie)
                .set(carrierOth).equalTo(record::getCarrierOth)
                .set(categoryDyn).equalTo(record::getCategoryDyn)
                .set(categorySta).equalTo(record::getCategorySta)
                .set(categoryOth).equalTo(record::getCategoryOth)
                .set(txRatioLow).equalTo(record::getTxRatioLow)
                .set(txRatioMid).equalTo(record::getTxRatioMid)
                .set(txRatioHigh).equalTo(record::getTxRatioHigh)
                .set(riskWordMostNum).equalTo(record::getRiskWordMostNum)
                .set(riskWordMostName).equalTo(record::getRiskWordMostName)
                .set(riskWordLeastNum).equalTo(record::getRiskWordLeastNum)
                .set(riskWordLeastName).equalTo(record::getRiskWordLeastName)
                .set(contentNumRatio).equalTo(record::getContentNumRatio)
                .set(ratioPositive).equalTo(record::getRatioPositive)
                .set(ratioNegative).equalTo(record::getRatioNegative)
                .set(platRatioHigh).equalTo(record::getPlatRatioHigh)
                .set(platRatioMid).equalTo(record::getPlatRatioMid)
                .set(platRatioLow).equalTo(record::getPlatRatioLow)
                .set(warningNum).equalTo(record::getWarningNum)
                .set(top5TopicsContent).equalTo(record::getTop5TopicsContent)
                .set(top5TopicsSocial).equalTo(record::getTop5TopicsSocial)
                .set(top3Words).equalTo(record::getTop3Words)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(createTime).equalTo(record::getCreateTime)
                .set(monitorNumHigh).equalTo(record::getMonitorNumHigh)
                .set(monitorNumMid).equalTo(record::getMonitorNumMid)
                .set(monitorNumLow).equalTo(record::getMonitorNumLow)
                .set(platNameLow).equalTo(record::getPlatNameLow)
                .set(platNameMid).equalTo(record::getPlatNameMid)
                .set(platNameHigh).equalTo(record::getPlatNameHigh)
                .set(nftPlatformName).equalTo(record::getNftPlatformName)
                .set(nftPlatformHotness).equalTo(record::getNftPlatformHotness)
                .set(nftPlatformHotnessChange).equalTo(record::getNftPlatformHotnessChange)
                .set(web3PlatformName).equalTo(record::getWeb3PlatformName)
                .set(web3PlatformHotness).equalTo(record::getWeb3PlatformHotness)
                .set(web3PlatformHotnessChange).equalTo(record::getWeb3PlatformHotnessChange)
                .set(riskNameHigh).equalTo(record::getRiskNameHigh)
                .set(riskIndexHigh).equalTo(record::getRiskIndexHigh)
                .set(riskNameLow).equalTo(record::getRiskNameLow)
                .set(riskIndexLow).equalTo(record::getRiskIndexLow);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SituationReport record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(platformName).equalToWhenPresent(record::getPlatformName)
                .set(carrierPic).equalToWhenPresent(record::getCarrierPic)
                .set(carrierVie).equalToWhenPresent(record::getCarrierVie)
                .set(carrierOth).equalToWhenPresent(record::getCarrierOth)
                .set(categoryDyn).equalToWhenPresent(record::getCategoryDyn)
                .set(categorySta).equalToWhenPresent(record::getCategorySta)
                .set(categoryOth).equalToWhenPresent(record::getCategoryOth)
                .set(txRatioLow).equalToWhenPresent(record::getTxRatioLow)
                .set(txRatioMid).equalToWhenPresent(record::getTxRatioMid)
                .set(txRatioHigh).equalToWhenPresent(record::getTxRatioHigh)
                .set(riskWordMostNum).equalToWhenPresent(record::getRiskWordMostNum)
                .set(riskWordMostName).equalToWhenPresent(record::getRiskWordMostName)
                .set(riskWordLeastNum).equalToWhenPresent(record::getRiskWordLeastNum)
                .set(riskWordLeastName).equalToWhenPresent(record::getRiskWordLeastName)
                .set(contentNumRatio).equalToWhenPresent(record::getContentNumRatio)
                .set(ratioPositive).equalToWhenPresent(record::getRatioPositive)
                .set(ratioNegative).equalToWhenPresent(record::getRatioNegative)
                .set(platRatioHigh).equalToWhenPresent(record::getPlatRatioHigh)
                .set(platRatioMid).equalToWhenPresent(record::getPlatRatioMid)
                .set(platRatioLow).equalToWhenPresent(record::getPlatRatioLow)
                .set(warningNum).equalToWhenPresent(record::getWarningNum)
                .set(top5TopicsContent).equalToWhenPresent(record::getTop5TopicsContent)
                .set(top5TopicsSocial).equalToWhenPresent(record::getTop5TopicsSocial)
                .set(top3Words).equalToWhenPresent(record::getTop3Words)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(monitorNumHigh).equalToWhenPresent(record::getMonitorNumHigh)
                .set(monitorNumMid).equalToWhenPresent(record::getMonitorNumMid)
                .set(monitorNumLow).equalToWhenPresent(record::getMonitorNumLow)
                .set(platNameLow).equalToWhenPresent(record::getPlatNameLow)
                .set(platNameMid).equalToWhenPresent(record::getPlatNameMid)
                .set(platNameHigh).equalToWhenPresent(record::getPlatNameHigh)
                .set(nftPlatformName).equalToWhenPresent(record::getNftPlatformName)
                .set(nftPlatformHotness).equalToWhenPresent(record::getNftPlatformHotness)
                .set(nftPlatformHotnessChange).equalToWhenPresent(record::getNftPlatformHotnessChange)
                .set(web3PlatformName).equalToWhenPresent(record::getWeb3PlatformName)
                .set(web3PlatformHotness).equalToWhenPresent(record::getWeb3PlatformHotness)
                .set(web3PlatformHotnessChange).equalToWhenPresent(record::getWeb3PlatformHotnessChange)
                .set(riskNameHigh).equalToWhenPresent(record::getRiskNameHigh)
                .set(riskIndexHigh).equalToWhenPresent(record::getRiskIndexHigh)
                .set(riskNameLow).equalToWhenPresent(record::getRiskNameLow)
                .set(riskIndexLow).equalToWhenPresent(record::getRiskIndexLow);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SituationReport record) {
        return update(c ->
            c.set(platformName).equalTo(record::getPlatformName)
            .set(carrierPic).equalTo(record::getCarrierPic)
            .set(carrierVie).equalTo(record::getCarrierVie)
            .set(carrierOth).equalTo(record::getCarrierOth)
            .set(categoryDyn).equalTo(record::getCategoryDyn)
            .set(categorySta).equalTo(record::getCategorySta)
            .set(categoryOth).equalTo(record::getCategoryOth)
            .set(txRatioLow).equalTo(record::getTxRatioLow)
            .set(txRatioMid).equalTo(record::getTxRatioMid)
            .set(txRatioHigh).equalTo(record::getTxRatioHigh)
            .set(riskWordMostNum).equalTo(record::getRiskWordMostNum)
            .set(riskWordMostName).equalTo(record::getRiskWordMostName)
            .set(riskWordLeastNum).equalTo(record::getRiskWordLeastNum)
            .set(riskWordLeastName).equalTo(record::getRiskWordLeastName)
            .set(contentNumRatio).equalTo(record::getContentNumRatio)
            .set(ratioPositive).equalTo(record::getRatioPositive)
            .set(ratioNegative).equalTo(record::getRatioNegative)
            .set(platRatioHigh).equalTo(record::getPlatRatioHigh)
            .set(platRatioMid).equalTo(record::getPlatRatioMid)
            .set(platRatioLow).equalTo(record::getPlatRatioLow)
            .set(warningNum).equalTo(record::getWarningNum)
            .set(top5TopicsContent).equalTo(record::getTop5TopicsContent)
            .set(top5TopicsSocial).equalTo(record::getTop5TopicsSocial)
            .set(top3Words).equalTo(record::getTop3Words)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(createTime).equalTo(record::getCreateTime)
            .set(monitorNumHigh).equalTo(record::getMonitorNumHigh)
            .set(monitorNumMid).equalTo(record::getMonitorNumMid)
            .set(monitorNumLow).equalTo(record::getMonitorNumLow)
            .set(platNameLow).equalTo(record::getPlatNameLow)
            .set(platNameMid).equalTo(record::getPlatNameMid)
            .set(platNameHigh).equalTo(record::getPlatNameHigh)
            .set(nftPlatformName).equalTo(record::getNftPlatformName)
            .set(nftPlatformHotness).equalTo(record::getNftPlatformHotness)
            .set(nftPlatformHotnessChange).equalTo(record::getNftPlatformHotnessChange)
            .set(web3PlatformName).equalTo(record::getWeb3PlatformName)
            .set(web3PlatformHotness).equalTo(record::getWeb3PlatformHotness)
            .set(web3PlatformHotnessChange).equalTo(record::getWeb3PlatformHotnessChange)
            .set(riskNameHigh).equalTo(record::getRiskNameHigh)
            .set(riskIndexHigh).equalTo(record::getRiskIndexHigh)
            .set(riskNameLow).equalTo(record::getRiskNameLow)
            .set(riskIndexLow).equalTo(record::getRiskIndexLow)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SituationReport record) {
        return update(c ->
            c.set(platformName).equalToWhenPresent(record::getPlatformName)
            .set(carrierPic).equalToWhenPresent(record::getCarrierPic)
            .set(carrierVie).equalToWhenPresent(record::getCarrierVie)
            .set(carrierOth).equalToWhenPresent(record::getCarrierOth)
            .set(categoryDyn).equalToWhenPresent(record::getCategoryDyn)
            .set(categorySta).equalToWhenPresent(record::getCategorySta)
            .set(categoryOth).equalToWhenPresent(record::getCategoryOth)
            .set(txRatioLow).equalToWhenPresent(record::getTxRatioLow)
            .set(txRatioMid).equalToWhenPresent(record::getTxRatioMid)
            .set(txRatioHigh).equalToWhenPresent(record::getTxRatioHigh)
            .set(riskWordMostNum).equalToWhenPresent(record::getRiskWordMostNum)
            .set(riskWordMostName).equalToWhenPresent(record::getRiskWordMostName)
            .set(riskWordLeastNum).equalToWhenPresent(record::getRiskWordLeastNum)
            .set(riskWordLeastName).equalToWhenPresent(record::getRiskWordLeastName)
            .set(contentNumRatio).equalToWhenPresent(record::getContentNumRatio)
            .set(ratioPositive).equalToWhenPresent(record::getRatioPositive)
            .set(ratioNegative).equalToWhenPresent(record::getRatioNegative)
            .set(platRatioHigh).equalToWhenPresent(record::getPlatRatioHigh)
            .set(platRatioMid).equalToWhenPresent(record::getPlatRatioMid)
            .set(platRatioLow).equalToWhenPresent(record::getPlatRatioLow)
            .set(warningNum).equalToWhenPresent(record::getWarningNum)
            .set(top5TopicsContent).equalToWhenPresent(record::getTop5TopicsContent)
            .set(top5TopicsSocial).equalToWhenPresent(record::getTop5TopicsSocial)
            .set(top3Words).equalToWhenPresent(record::getTop3Words)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(monitorNumHigh).equalToWhenPresent(record::getMonitorNumHigh)
            .set(monitorNumMid).equalToWhenPresent(record::getMonitorNumMid)
            .set(monitorNumLow).equalToWhenPresent(record::getMonitorNumLow)
            .set(platNameLow).equalToWhenPresent(record::getPlatNameLow)
            .set(platNameMid).equalToWhenPresent(record::getPlatNameMid)
            .set(platNameHigh).equalToWhenPresent(record::getPlatNameHigh)
            .set(nftPlatformName).equalToWhenPresent(record::getNftPlatformName)
            .set(nftPlatformHotness).equalToWhenPresent(record::getNftPlatformHotness)
            .set(nftPlatformHotnessChange).equalToWhenPresent(record::getNftPlatformHotnessChange)
            .set(web3PlatformName).equalToWhenPresent(record::getWeb3PlatformName)
            .set(web3PlatformHotness).equalToWhenPresent(record::getWeb3PlatformHotness)
            .set(web3PlatformHotnessChange).equalToWhenPresent(record::getWeb3PlatformHotnessChange)
            .set(riskNameHigh).equalToWhenPresent(record::getRiskNameHigh)
            .set(riskIndexHigh).equalToWhenPresent(record::getRiskIndexHigh)
            .set(riskNameLow).equalToWhenPresent(record::getRiskNameLow)
            .set(riskIndexLow).equalToWhenPresent(record::getRiskIndexLow)
            .where(id, isEqualTo(record::getId))
        );
    }
}