package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.DynamicMonitorDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.DynamicMonitor;
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
public interface DynamicMonitorMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, contentId, riskLevel, contentTag, createTime, updateTime, character);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<DynamicMonitor> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<DynamicMonitor> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DynamicMonitorResult")
    Optional<DynamicMonitor> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DynamicMonitorResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content_id", property="contentId", jdbcType=JdbcType.BIGINT),
        @Result(column="risk_level", property="riskLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="content_tag", property="contentTag", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="character", property="character", jdbcType=JdbcType.INTEGER)
    })
    List<DynamicMonitor> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dynamicMonitor, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dynamicMonitor, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(DynamicMonitor record) {
        return MyBatis3Utils.insert(this::insert, record, dynamicMonitor, c ->
            c.map(id).toProperty("id")
            .map(contentId).toProperty("contentId")
            .map(riskLevel).toProperty("riskLevel")
            .map(contentTag).toProperty("contentTag")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(character).toProperty("character")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<DynamicMonitor> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dynamicMonitor, c ->
            c.map(id).toProperty("id")
            .map(contentId).toProperty("contentId")
            .map(riskLevel).toProperty("riskLevel")
            .map(contentTag).toProperty("contentTag")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(character).toProperty("character")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(DynamicMonitor record) {
        return MyBatis3Utils.insert(this::insert, record, dynamicMonitor, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(contentId).toPropertyWhenPresent("contentId", record::getContentId)
            .map(riskLevel).toPropertyWhenPresent("riskLevel", record::getRiskLevel)
            .map(contentTag).toPropertyWhenPresent("contentTag", record::getContentTag)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(character).toPropertyWhenPresent("character", record::getCharacter)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<DynamicMonitor> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dynamicMonitor, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<DynamicMonitor> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dynamicMonitor, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<DynamicMonitor> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dynamicMonitor, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<DynamicMonitor> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dynamicMonitor, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(DynamicMonitor record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(contentId).equalTo(record::getContentId)
                .set(riskLevel).equalTo(record::getRiskLevel)
                .set(contentTag).equalTo(record::getContentTag)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(character).equalTo(record::getCharacter);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DynamicMonitor record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(contentId).equalToWhenPresent(record::getContentId)
                .set(riskLevel).equalToWhenPresent(record::getRiskLevel)
                .set(contentTag).equalToWhenPresent(record::getContentTag)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(character).equalToWhenPresent(record::getCharacter);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(DynamicMonitor record) {
        return update(c ->
            c.set(contentId).equalTo(record::getContentId)
            .set(riskLevel).equalTo(record::getRiskLevel)
            .set(contentTag).equalTo(record::getContentTag)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(character).equalTo(record::getCharacter)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(DynamicMonitor record) {
        return update(c ->
            c.set(contentId).equalToWhenPresent(record::getContentId)
            .set(riskLevel).equalToWhenPresent(record::getRiskLevel)
            .set(contentTag).equalToWhenPresent(record::getContentTag)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(character).equalToWhenPresent(record::getCharacter)
            .where(id, isEqualTo(record::getId))
        );
    }
}