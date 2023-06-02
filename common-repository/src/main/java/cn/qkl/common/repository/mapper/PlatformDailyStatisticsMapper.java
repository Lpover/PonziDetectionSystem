package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.PlatformDailyStatisticsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.PlatformDailyStatistics;
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
public interface PlatformDailyStatisticsMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, platformId, highRiskNum, middleRiskNum, lowRiskNum, contentSum, contentRiskSum, createTime, updateTime, highRiskTx, middleRiskTx, lowRiskTx, storageRatio, carrierRatio, categoryRatio, storageProviderName, carrierName, categoryName, riskIndex);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<PlatformDailyStatistics> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<PlatformDailyStatistics> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PlatformDailyStatisticsResult")
    Optional<PlatformDailyStatistics> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PlatformDailyStatisticsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="platform_id", property="platformId", jdbcType=JdbcType.BIGINT),
        @Result(column="high_risk_num", property="highRiskNum", jdbcType=JdbcType.INTEGER),
        @Result(column="middle_risk_num", property="middleRiskNum", jdbcType=JdbcType.INTEGER),
        @Result(column="low_risk_num", property="lowRiskNum", jdbcType=JdbcType.INTEGER),
        @Result(column="content_sum", property="contentSum", jdbcType=JdbcType.INTEGER),
        @Result(column="content_risk_sum", property="contentRiskSum", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="high_risk_tx", property="highRiskTx", jdbcType=JdbcType.INTEGER),
        @Result(column="middle_risk_tx", property="middleRiskTx", jdbcType=JdbcType.INTEGER),
        @Result(column="low_risk_tx", property="lowRiskTx", jdbcType=JdbcType.INTEGER),
        @Result(column="storage_ratio", property="storageRatio", jdbcType=JdbcType.INTEGER),
        @Result(column="carrier_ratio", property="carrierRatio", jdbcType=JdbcType.INTEGER),
        @Result(column="category_ratio", property="categoryRatio", jdbcType=JdbcType.INTEGER),
        @Result(column="storage_ provider_name", property="storageProviderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="carrier_name", property="carrierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="risk_index", property="riskIndex", jdbcType=JdbcType.INTEGER)
    })
    List<PlatformDailyStatistics> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, platformDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, platformDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(PlatformDailyStatistics record) {
        return MyBatis3Utils.insert(this::insert, record, platformDailyStatistics, c ->
            c.map(id).toProperty("id")
            .map(platformId).toProperty("platformId")
            .map(highRiskNum).toProperty("highRiskNum")
            .map(middleRiskNum).toProperty("middleRiskNum")
            .map(lowRiskNum).toProperty("lowRiskNum")
            .map(contentSum).toProperty("contentSum")
            .map(contentRiskSum).toProperty("contentRiskSum")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(highRiskTx).toProperty("highRiskTx")
            .map(middleRiskTx).toProperty("middleRiskTx")
            .map(lowRiskTx).toProperty("lowRiskTx")
            .map(storageRatio).toProperty("storageRatio")
            .map(carrierRatio).toProperty("carrierRatio")
            .map(categoryRatio).toProperty("categoryRatio")
            .map(storageProviderName).toProperty("storageProviderName")
            .map(carrierName).toProperty("carrierName")
            .map(categoryName).toProperty("categoryName")
            .map(riskIndex).toProperty("riskIndex")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<PlatformDailyStatistics> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, platformDailyStatistics, c ->
            c.map(id).toProperty("id")
            .map(platformId).toProperty("platformId")
            .map(highRiskNum).toProperty("highRiskNum")
            .map(middleRiskNum).toProperty("middleRiskNum")
            .map(lowRiskNum).toProperty("lowRiskNum")
            .map(contentSum).toProperty("contentSum")
            .map(contentRiskSum).toProperty("contentRiskSum")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(highRiskTx).toProperty("highRiskTx")
            .map(middleRiskTx).toProperty("middleRiskTx")
            .map(lowRiskTx).toProperty("lowRiskTx")
            .map(storageRatio).toProperty("storageRatio")
            .map(carrierRatio).toProperty("carrierRatio")
            .map(categoryRatio).toProperty("categoryRatio")
            .map(storageProviderName).toProperty("storageProviderName")
            .map(carrierName).toProperty("carrierName")
            .map(categoryName).toProperty("categoryName")
            .map(riskIndex).toProperty("riskIndex")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PlatformDailyStatistics record) {
        return MyBatis3Utils.insert(this::insert, record, platformDailyStatistics, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(platformId).toPropertyWhenPresent("platformId", record::getPlatformId)
            .map(highRiskNum).toPropertyWhenPresent("highRiskNum", record::getHighRiskNum)
            .map(middleRiskNum).toPropertyWhenPresent("middleRiskNum", record::getMiddleRiskNum)
            .map(lowRiskNum).toPropertyWhenPresent("lowRiskNum", record::getLowRiskNum)
            .map(contentSum).toPropertyWhenPresent("contentSum", record::getContentSum)
            .map(contentRiskSum).toPropertyWhenPresent("contentRiskSum", record::getContentRiskSum)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(highRiskTx).toPropertyWhenPresent("highRiskTx", record::getHighRiskTx)
            .map(middleRiskTx).toPropertyWhenPresent("middleRiskTx", record::getMiddleRiskTx)
            .map(lowRiskTx).toPropertyWhenPresent("lowRiskTx", record::getLowRiskTx)
            .map(storageRatio).toPropertyWhenPresent("storageRatio", record::getStorageRatio)
            .map(carrierRatio).toPropertyWhenPresent("carrierRatio", record::getCarrierRatio)
            .map(categoryRatio).toPropertyWhenPresent("categoryRatio", record::getCategoryRatio)
            .map(storageProviderName).toPropertyWhenPresent("storageProviderName", record::getStorageProviderName)
            .map(carrierName).toPropertyWhenPresent("carrierName", record::getCarrierName)
            .map(categoryName).toPropertyWhenPresent("categoryName", record::getCategoryName)
            .map(riskIndex).toPropertyWhenPresent("riskIndex", record::getRiskIndex)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PlatformDailyStatistics> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, platformDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PlatformDailyStatistics> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, platformDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PlatformDailyStatistics> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, platformDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PlatformDailyStatistics> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, platformDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(PlatformDailyStatistics record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(platformId).equalTo(record::getPlatformId)
                .set(highRiskNum).equalTo(record::getHighRiskNum)
                .set(middleRiskNum).equalTo(record::getMiddleRiskNum)
                .set(lowRiskNum).equalTo(record::getLowRiskNum)
                .set(contentSum).equalTo(record::getContentSum)
                .set(contentRiskSum).equalTo(record::getContentRiskSum)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(highRiskTx).equalTo(record::getHighRiskTx)
                .set(middleRiskTx).equalTo(record::getMiddleRiskTx)
                .set(lowRiskTx).equalTo(record::getLowRiskTx)
                .set(storageRatio).equalTo(record::getStorageRatio)
                .set(carrierRatio).equalTo(record::getCarrierRatio)
                .set(categoryRatio).equalTo(record::getCategoryRatio)
                .set(storageProviderName).equalTo(record::getStorageProviderName)
                .set(carrierName).equalTo(record::getCarrierName)
                .set(categoryName).equalTo(record::getCategoryName)
                .set(riskIndex).equalTo(record::getRiskIndex);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PlatformDailyStatistics record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(platformId).equalToWhenPresent(record::getPlatformId)
                .set(highRiskNum).equalToWhenPresent(record::getHighRiskNum)
                .set(middleRiskNum).equalToWhenPresent(record::getMiddleRiskNum)
                .set(lowRiskNum).equalToWhenPresent(record::getLowRiskNum)
                .set(contentSum).equalToWhenPresent(record::getContentSum)
                .set(contentRiskSum).equalToWhenPresent(record::getContentRiskSum)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(highRiskTx).equalToWhenPresent(record::getHighRiskTx)
                .set(middleRiskTx).equalToWhenPresent(record::getMiddleRiskTx)
                .set(lowRiskTx).equalToWhenPresent(record::getLowRiskTx)
                .set(storageRatio).equalToWhenPresent(record::getStorageRatio)
                .set(carrierRatio).equalToWhenPresent(record::getCarrierRatio)
                .set(categoryRatio).equalToWhenPresent(record::getCategoryRatio)
                .set(storageProviderName).equalToWhenPresent(record::getStorageProviderName)
                .set(carrierName).equalToWhenPresent(record::getCarrierName)
                .set(categoryName).equalToWhenPresent(record::getCategoryName)
                .set(riskIndex).equalToWhenPresent(record::getRiskIndex);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PlatformDailyStatistics record) {
        return update(c ->
            c.set(platformId).equalTo(record::getPlatformId)
            .set(highRiskNum).equalTo(record::getHighRiskNum)
            .set(middleRiskNum).equalTo(record::getMiddleRiskNum)
            .set(lowRiskNum).equalTo(record::getLowRiskNum)
            .set(contentSum).equalTo(record::getContentSum)
            .set(contentRiskSum).equalTo(record::getContentRiskSum)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(highRiskTx).equalTo(record::getHighRiskTx)
            .set(middleRiskTx).equalTo(record::getMiddleRiskTx)
            .set(lowRiskTx).equalTo(record::getLowRiskTx)
            .set(storageRatio).equalTo(record::getStorageRatio)
            .set(carrierRatio).equalTo(record::getCarrierRatio)
            .set(categoryRatio).equalTo(record::getCategoryRatio)
            .set(storageProviderName).equalTo(record::getStorageProviderName)
            .set(carrierName).equalTo(record::getCarrierName)
            .set(categoryName).equalTo(record::getCategoryName)
            .set(riskIndex).equalTo(record::getRiskIndex)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PlatformDailyStatistics record) {
        return update(c ->
            c.set(platformId).equalToWhenPresent(record::getPlatformId)
            .set(highRiskNum).equalToWhenPresent(record::getHighRiskNum)
            .set(middleRiskNum).equalToWhenPresent(record::getMiddleRiskNum)
            .set(lowRiskNum).equalToWhenPresent(record::getLowRiskNum)
            .set(contentSum).equalToWhenPresent(record::getContentSum)
            .set(contentRiskSum).equalToWhenPresent(record::getContentRiskSum)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(highRiskTx).equalToWhenPresent(record::getHighRiskTx)
            .set(middleRiskTx).equalToWhenPresent(record::getMiddleRiskTx)
            .set(lowRiskTx).equalToWhenPresent(record::getLowRiskTx)
            .set(storageRatio).equalToWhenPresent(record::getStorageRatio)
            .set(carrierRatio).equalToWhenPresent(record::getCarrierRatio)
            .set(categoryRatio).equalToWhenPresent(record::getCategoryRatio)
            .set(storageProviderName).equalToWhenPresent(record::getStorageProviderName)
            .set(carrierName).equalToWhenPresent(record::getCarrierName)
            .set(categoryName).equalToWhenPresent(record::getCategoryName)
            .set(riskIndex).equalToWhenPresent(record::getRiskIndex)
            .where(id, isEqualTo(record::getId))
        );
    }
}