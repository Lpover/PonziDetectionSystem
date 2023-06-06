package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.SettingsMonitorRulesDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.SettingsMonitorRules;
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
public interface SettingsMonitorRulesMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, type, monitorFrequency, lastMonitorTime, updateTime, createTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SettingsMonitorRules> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SettingsMonitorRules> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SettingsMonitorRulesResult")
    Optional<SettingsMonitorRules> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SettingsMonitorRulesResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="monitor_frequency", property="monitorFrequency", jdbcType=JdbcType.INTEGER),
        @Result(column="last_monitor_time", property="lastMonitorTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SettingsMonitorRules> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, settingsMonitorRules, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, settingsMonitorRules, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SettingsMonitorRules record) {
        return MyBatis3Utils.insert(this::insert, record, settingsMonitorRules, c ->
            c.map(id).toProperty("id")
            .map(type).toProperty("type")
            .map(monitorFrequency).toProperty("monitorFrequency")
            .map(lastMonitorTime).toProperty("lastMonitorTime")
            .map(updateTime).toProperty("updateTime")
            .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<SettingsMonitorRules> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, settingsMonitorRules, c ->
            c.map(id).toProperty("id")
            .map(type).toProperty("type")
            .map(monitorFrequency).toProperty("monitorFrequency")
            .map(lastMonitorTime).toProperty("lastMonitorTime")
            .map(updateTime).toProperty("updateTime")
            .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SettingsMonitorRules record) {
        return MyBatis3Utils.insert(this::insert, record, settingsMonitorRules, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(monitorFrequency).toPropertyWhenPresent("monitorFrequency", record::getMonitorFrequency)
            .map(lastMonitorTime).toPropertyWhenPresent("lastMonitorTime", record::getLastMonitorTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SettingsMonitorRules> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, settingsMonitorRules, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SettingsMonitorRules> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, settingsMonitorRules, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SettingsMonitorRules> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, settingsMonitorRules, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SettingsMonitorRules> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, settingsMonitorRules, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SettingsMonitorRules record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(type).equalTo(record::getType)
                .set(monitorFrequency).equalTo(record::getMonitorFrequency)
                .set(lastMonitorTime).equalTo(record::getLastMonitorTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(createTime).equalTo(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SettingsMonitorRules record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(type).equalToWhenPresent(record::getType)
                .set(monitorFrequency).equalToWhenPresent(record::getMonitorFrequency)
                .set(lastMonitorTime).equalToWhenPresent(record::getLastMonitorTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SettingsMonitorRules record) {
        return update(c ->
            c.set(type).equalTo(record::getType)
            .set(monitorFrequency).equalTo(record::getMonitorFrequency)
            .set(lastMonitorTime).equalTo(record::getLastMonitorTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(createTime).equalTo(record::getCreateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SettingsMonitorRules record) {
        return update(c ->
            c.set(type).equalToWhenPresent(record::getType)
            .set(monitorFrequency).equalToWhenPresent(record::getMonitorFrequency)
            .set(lastMonitorTime).equalToWhenPresent(record::getLastMonitorTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}