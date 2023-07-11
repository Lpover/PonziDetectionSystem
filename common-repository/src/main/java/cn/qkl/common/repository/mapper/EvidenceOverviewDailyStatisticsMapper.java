package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.EvidenceOverviewDailyStatisticsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.EvidenceOverviewDailyStatistics;
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
public interface EvidenceOverviewDailyStatisticsMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, platformId, webEvidenceCount, mobileEvidenceCount, reinforceEvidenceCount, createTime, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<EvidenceOverviewDailyStatistics> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<EvidenceOverviewDailyStatistics> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EvidenceOverviewDailyStatisticsResult")
    Optional<EvidenceOverviewDailyStatistics> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="EvidenceOverviewDailyStatisticsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="platform_id", property="platformId", jdbcType=JdbcType.BIGINT),
        @Result(column="web_evidence_count", property="webEvidenceCount", jdbcType=JdbcType.INTEGER),
        @Result(column="mobile_evidence_count", property="mobileEvidenceCount", jdbcType=JdbcType.INTEGER),
        @Result(column="reinforce_evidence_count", property="reinforceEvidenceCount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EvidenceOverviewDailyStatistics> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, evidenceOverviewDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, evidenceOverviewDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(EvidenceOverviewDailyStatistics record) {
        return MyBatis3Utils.insert(this::insert, record, evidenceOverviewDailyStatistics, c ->
            c.map(id).toProperty("id")
            .map(platformId).toProperty("platformId")
            .map(webEvidenceCount).toProperty("webEvidenceCount")
            .map(mobileEvidenceCount).toProperty("mobileEvidenceCount")
            .map(reinforceEvidenceCount).toProperty("reinforceEvidenceCount")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<EvidenceOverviewDailyStatistics> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, evidenceOverviewDailyStatistics, c ->
            c.map(id).toProperty("id")
            .map(platformId).toProperty("platformId")
            .map(webEvidenceCount).toProperty("webEvidenceCount")
            .map(mobileEvidenceCount).toProperty("mobileEvidenceCount")
            .map(reinforceEvidenceCount).toProperty("reinforceEvidenceCount")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(EvidenceOverviewDailyStatistics record) {
        return MyBatis3Utils.insert(this::insert, record, evidenceOverviewDailyStatistics, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(platformId).toPropertyWhenPresent("platformId", record::getPlatformId)
            .map(webEvidenceCount).toPropertyWhenPresent("webEvidenceCount", record::getWebEvidenceCount)
            .map(mobileEvidenceCount).toPropertyWhenPresent("mobileEvidenceCount", record::getMobileEvidenceCount)
            .map(reinforceEvidenceCount).toPropertyWhenPresent("reinforceEvidenceCount", record::getReinforceEvidenceCount)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<EvidenceOverviewDailyStatistics> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, evidenceOverviewDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<EvidenceOverviewDailyStatistics> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, evidenceOverviewDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<EvidenceOverviewDailyStatistics> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, evidenceOverviewDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<EvidenceOverviewDailyStatistics> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, evidenceOverviewDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(EvidenceOverviewDailyStatistics record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(platformId).equalTo(record::getPlatformId)
                .set(webEvidenceCount).equalTo(record::getWebEvidenceCount)
                .set(mobileEvidenceCount).equalTo(record::getMobileEvidenceCount)
                .set(reinforceEvidenceCount).equalTo(record::getReinforceEvidenceCount)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(EvidenceOverviewDailyStatistics record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(platformId).equalToWhenPresent(record::getPlatformId)
                .set(webEvidenceCount).equalToWhenPresent(record::getWebEvidenceCount)
                .set(mobileEvidenceCount).equalToWhenPresent(record::getMobileEvidenceCount)
                .set(reinforceEvidenceCount).equalToWhenPresent(record::getReinforceEvidenceCount)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(EvidenceOverviewDailyStatistics record) {
        return update(c ->
            c.set(platformId).equalTo(record::getPlatformId)
            .set(webEvidenceCount).equalTo(record::getWebEvidenceCount)
            .set(mobileEvidenceCount).equalTo(record::getMobileEvidenceCount)
            .set(reinforceEvidenceCount).equalTo(record::getReinforceEvidenceCount)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(EvidenceOverviewDailyStatistics record) {
        return update(c ->
            c.set(platformId).equalToWhenPresent(record::getPlatformId)
            .set(webEvidenceCount).equalToWhenPresent(record::getWebEvidenceCount)
            .set(mobileEvidenceCount).equalToWhenPresent(record::getMobileEvidenceCount)
            .set(reinforceEvidenceCount).equalToWhenPresent(record::getReinforceEvidenceCount)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}