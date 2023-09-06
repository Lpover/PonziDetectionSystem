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
    BasicColumn[] selectList = BasicColumn.columnList(id, address, direction, lowerLimit, startTime, endTime, url, createTime, updateTime, chainId);

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
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="direction", property="direction", jdbcType=JdbcType.INTEGER),
        @Result(column="lower_limit", property="lowerLimit", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="chain_id", property="chainId", jdbcType=JdbcType.BIGINT)
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
            .map(address).toProperty("address")
            .map(direction).toProperty("direction")
            .map(lowerLimit).toProperty("lowerLimit")
            .map(startTime).toProperty("startTime")
            .map(endTime).toProperty("endTime")
            .map(url).toProperty("url")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(chainId).toProperty("chainId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<AtaExportTask> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ataExportTask, c ->
            c.map(id).toProperty("id")
            .map(address).toProperty("address")
            .map(direction).toProperty("direction")
            .map(lowerLimit).toProperty("lowerLimit")
            .map(startTime).toProperty("startTime")
            .map(endTime).toProperty("endTime")
            .map(url).toProperty("url")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(chainId).toProperty("chainId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(AtaExportTask record) {
        return MyBatis3Utils.insert(this::insert, record, ataExportTask, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
            .map(direction).toPropertyWhenPresent("direction", record::getDirection)
            .map(lowerLimit).toPropertyWhenPresent("lowerLimit", record::getLowerLimit)
            .map(startTime).toPropertyWhenPresent("startTime", record::getStartTime)
            .map(endTime).toPropertyWhenPresent("endTime", record::getEndTime)
            .map(url).toPropertyWhenPresent("url", record::getUrl)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(chainId).toPropertyWhenPresent("chainId", record::getChainId)
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
                .set(address).equalTo(record::getAddress)
                .set(direction).equalTo(record::getDirection)
                .set(lowerLimit).equalTo(record::getLowerLimit)
                .set(startTime).equalTo(record::getStartTime)
                .set(endTime).equalTo(record::getEndTime)
                .set(url).equalTo(record::getUrl)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(chainId).equalTo(record::getChainId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AtaExportTask record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(address).equalToWhenPresent(record::getAddress)
                .set(direction).equalToWhenPresent(record::getDirection)
                .set(lowerLimit).equalToWhenPresent(record::getLowerLimit)
                .set(startTime).equalToWhenPresent(record::getStartTime)
                .set(endTime).equalToWhenPresent(record::getEndTime)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(chainId).equalToWhenPresent(record::getChainId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(AtaExportTask record) {
        return update(c ->
            c.set(address).equalTo(record::getAddress)
            .set(direction).equalTo(record::getDirection)
            .set(lowerLimit).equalTo(record::getLowerLimit)
            .set(startTime).equalTo(record::getStartTime)
            .set(endTime).equalTo(record::getEndTime)
            .set(url).equalTo(record::getUrl)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(chainId).equalTo(record::getChainId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(AtaExportTask record) {
        return update(c ->
            c.set(address).equalToWhenPresent(record::getAddress)
            .set(direction).equalToWhenPresent(record::getDirection)
            .set(lowerLimit).equalToWhenPresent(record::getLowerLimit)
            .set(startTime).equalToWhenPresent(record::getStartTime)
            .set(endTime).equalToWhenPresent(record::getEndTime)
            .set(url).equalToWhenPresent(record::getUrl)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(chainId).equalToWhenPresent(record::getChainId)
            .where(id, isEqualTo(record::getId))
        );
    }
}