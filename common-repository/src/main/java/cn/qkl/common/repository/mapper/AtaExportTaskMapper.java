package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.AtaExportTaskDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.AtaExportTask;
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
public interface AtaExportTaskMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, blockchain, currencyType, address, direction, lowerLimit, startTime, endTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<AtaExportTask> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<AtaExportTask> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AtaExportTaskResult")
    Optional<AtaExportTask> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AtaExportTaskResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="blockchain", property="blockchain", jdbcType=JdbcType.VARCHAR),
        @Result(column="currency_type", property="currencyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="direction", property="direction", jdbcType=JdbcType.VARCHAR),
        @Result(column="lower_limit", property="lowerLimit", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AtaExportTask> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ataExportTask, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ataExportTask, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(AtaExportTask record) {
        return MyBatis3Utils.insert(this::insert, record, ataExportTask, c ->
            c.map(id).toProperty("id")
            .map(blockchain).toProperty("blockchain")
            .map(currencyType).toProperty("currencyType")
            .map(address).toProperty("address")
            .map(direction).toProperty("direction")
            .map(lowerLimit).toProperty("lowerLimit")
            .map(startTime).toProperty("startTime")
            .map(endTime).toProperty("endTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<AtaExportTask> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ataExportTask, c ->
            c.map(id).toProperty("id")
            .map(blockchain).toProperty("blockchain")
            .map(currencyType).toProperty("currencyType")
            .map(address).toProperty("address")
            .map(direction).toProperty("direction")
            .map(lowerLimit).toProperty("lowerLimit")
            .map(startTime).toProperty("startTime")
            .map(endTime).toProperty("endTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(AtaExportTask record) {
        return MyBatis3Utils.insert(this::insert, record, ataExportTask, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(blockchain).toPropertyWhenPresent("blockchain", record::getBlockchain)
            .map(currencyType).toPropertyWhenPresent("currencyType", record::getCurrencyType)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
            .map(direction).toPropertyWhenPresent("direction", record::getDirection)
            .map(lowerLimit).toPropertyWhenPresent("lowerLimit", record::getLowerLimit)
            .map(startTime).toPropertyWhenPresent("startTime", record::getStartTime)
            .map(endTime).toPropertyWhenPresent("endTime", record::getEndTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<AtaExportTask> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ataExportTask, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<AtaExportTask> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ataExportTask, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<AtaExportTask> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ataExportTask, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<AtaExportTask> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ataExportTask, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(AtaExportTask record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(blockchain).equalTo(record::getBlockchain)
                .set(currencyType).equalTo(record::getCurrencyType)
                .set(address).equalTo(record::getAddress)
                .set(direction).equalTo(record::getDirection)
                .set(lowerLimit).equalTo(record::getLowerLimit)
                .set(startTime).equalTo(record::getStartTime)
                .set(endTime).equalTo(record::getEndTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AtaExportTask record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(blockchain).equalToWhenPresent(record::getBlockchain)
                .set(currencyType).equalToWhenPresent(record::getCurrencyType)
                .set(address).equalToWhenPresent(record::getAddress)
                .set(direction).equalToWhenPresent(record::getDirection)
                .set(lowerLimit).equalToWhenPresent(record::getLowerLimit)
                .set(startTime).equalToWhenPresent(record::getStartTime)
                .set(endTime).equalToWhenPresent(record::getEndTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(AtaExportTask record) {
        return update(c ->
            c.set(blockchain).equalTo(record::getBlockchain)
            .set(currencyType).equalTo(record::getCurrencyType)
            .set(address).equalTo(record::getAddress)
            .set(direction).equalTo(record::getDirection)
            .set(lowerLimit).equalTo(record::getLowerLimit)
            .set(startTime).equalTo(record::getStartTime)
            .set(endTime).equalTo(record::getEndTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(AtaExportTask record) {
        return update(c ->
            c.set(blockchain).equalToWhenPresent(record::getBlockchain)
            .set(currencyType).equalToWhenPresent(record::getCurrencyType)
            .set(address).equalToWhenPresent(record::getAddress)
            .set(direction).equalToWhenPresent(record::getDirection)
            .set(lowerLimit).equalToWhenPresent(record::getLowerLimit)
            .set(startTime).equalToWhenPresent(record::getStartTime)
            .set(endTime).equalToWhenPresent(record::getEndTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}