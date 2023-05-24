package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.RiskContentStatisticsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.RiskContentStatistics;
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
public interface RiskContentStatisticsMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, createTime, lowRiskNum, middleRiskNum, highRiskNum, platformId, updateTime, contentSum);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<RiskContentStatistics> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<RiskContentStatistics> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RiskContentStatisticsResult")
    Optional<RiskContentStatistics> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RiskContentStatisticsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="low_risk_num", property="lowRiskNum", jdbcType=JdbcType.INTEGER),
        @Result(column="middle_risk_num", property="middleRiskNum", jdbcType=JdbcType.INTEGER),
        @Result(column="high_risk_num", property="highRiskNum", jdbcType=JdbcType.INTEGER),
        @Result(column="platform_id", property="platformId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content_sum", property="contentSum", jdbcType=JdbcType.INTEGER)
    })
    List<RiskContentStatistics> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, riskContentStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, riskContentStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(RiskContentStatistics record) {
        return MyBatis3Utils.insert(this::insert, record, riskContentStatistics, c ->
            c.map(id).toProperty("id")
            .map(createTime).toProperty("createTime")
            .map(lowRiskNum).toProperty("lowRiskNum")
            .map(middleRiskNum).toProperty("middleRiskNum")
            .map(highRiskNum).toProperty("highRiskNum")
            .map(platformId).toProperty("platformId")
            .map(updateTime).toProperty("updateTime")
            .map(contentSum).toProperty("contentSum")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<RiskContentStatistics> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, riskContentStatistics, c ->
            c.map(id).toProperty("id")
            .map(createTime).toProperty("createTime")
            .map(lowRiskNum).toProperty("lowRiskNum")
            .map(middleRiskNum).toProperty("middleRiskNum")
            .map(highRiskNum).toProperty("highRiskNum")
            .map(platformId).toProperty("platformId")
            .map(updateTime).toProperty("updateTime")
            .map(contentSum).toProperty("contentSum")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(RiskContentStatistics record) {
        return MyBatis3Utils.insert(this::insert, record, riskContentStatistics, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(lowRiskNum).toPropertyWhenPresent("lowRiskNum", record::getLowRiskNum)
            .map(middleRiskNum).toPropertyWhenPresent("middleRiskNum", record::getMiddleRiskNum)
            .map(highRiskNum).toPropertyWhenPresent("highRiskNum", record::getHighRiskNum)
            .map(platformId).toPropertyWhenPresent("platformId", record::getPlatformId)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(contentSum).toPropertyWhenPresent("contentSum", record::getContentSum)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RiskContentStatistics> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, riskContentStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RiskContentStatistics> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, riskContentStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RiskContentStatistics> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, riskContentStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RiskContentStatistics> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, riskContentStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(RiskContentStatistics record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(lowRiskNum).equalTo(record::getLowRiskNum)
                .set(middleRiskNum).equalTo(record::getMiddleRiskNum)
                .set(highRiskNum).equalTo(record::getHighRiskNum)
                .set(platformId).equalTo(record::getPlatformId)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(contentSum).equalTo(record::getContentSum);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RiskContentStatistics record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(lowRiskNum).equalToWhenPresent(record::getLowRiskNum)
                .set(middleRiskNum).equalToWhenPresent(record::getMiddleRiskNum)
                .set(highRiskNum).equalToWhenPresent(record::getHighRiskNum)
                .set(platformId).equalToWhenPresent(record::getPlatformId)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(contentSum).equalToWhenPresent(record::getContentSum);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(RiskContentStatistics record) {
        return update(c ->
            c.set(createTime).equalTo(record::getCreateTime)
            .set(lowRiskNum).equalTo(record::getLowRiskNum)
            .set(middleRiskNum).equalTo(record::getMiddleRiskNum)
            .set(highRiskNum).equalTo(record::getHighRiskNum)
            .set(platformId).equalTo(record::getPlatformId)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(contentSum).equalTo(record::getContentSum)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(RiskContentStatistics record) {
        return update(c ->
            c.set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(lowRiskNum).equalToWhenPresent(record::getLowRiskNum)
            .set(middleRiskNum).equalToWhenPresent(record::getMiddleRiskNum)
            .set(highRiskNum).equalToWhenPresent(record::getHighRiskNum)
            .set(platformId).equalToWhenPresent(record::getPlatformId)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(contentSum).equalToWhenPresent(record::getContentSum)
            .where(id, isEqualTo(record::getId))
        );
    }
}