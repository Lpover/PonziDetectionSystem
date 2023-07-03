package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.AlgorithmDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.Algorithm;
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
public interface AlgorithmMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, version, state, describe, name, recognitionRate, type, createTime, updateTime, fileUrl);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Algorithm> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Algorithm> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AlgorithmResult")
    Optional<Algorithm> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AlgorithmResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="describe", property="describe", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="recognition_rate", property="recognitionRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="file_url", property="fileUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<Algorithm> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, algorithm, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, algorithm, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Algorithm record) {
        return MyBatis3Utils.insert(this::insert, record, algorithm, c ->
            c.map(id).toProperty("id")
            .map(version).toProperty("version")
            .map(state).toProperty("state")
            .map(describe).toProperty("describe")
            .map(name).toProperty("name")
            .map(recognitionRate).toProperty("recognitionRate")
            .map(type).toProperty("type")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(fileUrl).toProperty("fileUrl")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Algorithm> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, algorithm, c ->
            c.map(id).toProperty("id")
            .map(version).toProperty("version")
            .map(state).toProperty("state")
            .map(describe).toProperty("describe")
            .map(name).toProperty("name")
            .map(recognitionRate).toProperty("recognitionRate")
            .map(type).toProperty("type")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(fileUrl).toProperty("fileUrl")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Algorithm record) {
        return MyBatis3Utils.insert(this::insert, record, algorithm, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
            .map(state).toPropertyWhenPresent("state", record::getState)
            .map(describe).toPropertyWhenPresent("describe", record::getDescribe)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(recognitionRate).toPropertyWhenPresent("recognitionRate", record::getRecognitionRate)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(fileUrl).toPropertyWhenPresent("fileUrl", record::getFileUrl)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Algorithm> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, algorithm, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Algorithm> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, algorithm, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Algorithm> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, algorithm, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Algorithm> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, algorithm, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Algorithm record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(version).equalTo(record::getVersion)
                .set(state).equalTo(record::getState)
                .set(describe).equalTo(record::getDescribe)
                .set(name).equalTo(record::getName)
                .set(recognitionRate).equalTo(record::getRecognitionRate)
                .set(type).equalTo(record::getType)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(fileUrl).equalTo(record::getFileUrl);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Algorithm record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(state).equalToWhenPresent(record::getState)
                .set(describe).equalToWhenPresent(record::getDescribe)
                .set(name).equalToWhenPresent(record::getName)
                .set(recognitionRate).equalToWhenPresent(record::getRecognitionRate)
                .set(type).equalToWhenPresent(record::getType)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(fileUrl).equalToWhenPresent(record::getFileUrl);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Algorithm record) {
        return update(c ->
            c.set(version).equalTo(record::getVersion)
            .set(state).equalTo(record::getState)
            .set(describe).equalTo(record::getDescribe)
            .set(name).equalTo(record::getName)
            .set(recognitionRate).equalTo(record::getRecognitionRate)
            .set(type).equalTo(record::getType)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(fileUrl).equalTo(record::getFileUrl)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Algorithm record) {
        return update(c ->
            c.set(version).equalToWhenPresent(record::getVersion)
            .set(state).equalToWhenPresent(record::getState)
            .set(describe).equalToWhenPresent(record::getDescribe)
            .set(name).equalToWhenPresent(record::getName)
            .set(recognitionRate).equalToWhenPresent(record::getRecognitionRate)
            .set(type).equalToWhenPresent(record::getType)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(fileUrl).equalToWhenPresent(record::getFileUrl)
            .where(id, isEqualTo(record::getId))
        );
    }
}