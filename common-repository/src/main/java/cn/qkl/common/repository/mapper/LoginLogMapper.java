package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.LoginLogDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.LoginLog;
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
public interface LoginLogMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, userId, ip, apiName, apiRouter, time, detail);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<LoginLog> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<LoginLog> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("LoginLogResult")
    Optional<LoginLog> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="LoginLogResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="api_name", property="apiName", jdbcType=JdbcType.VARCHAR),
        @Result(column="api_router", property="apiRouter", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR)
    })
    List<LoginLog> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, loginLog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, loginLog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(LoginLog record) {
        return MyBatis3Utils.insert(this::insert, record, loginLog, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(ip).toProperty("ip")
            .map(apiName).toProperty("apiName")
            .map(apiRouter).toProperty("apiRouter")
            .map(time).toProperty("time")
            .map(detail).toProperty("detail")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<LoginLog> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, loginLog, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(ip).toProperty("ip")
            .map(apiName).toProperty("apiName")
            .map(apiRouter).toProperty("apiRouter")
            .map(time).toProperty("time")
            .map(detail).toProperty("detail")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(LoginLog record) {
        return MyBatis3Utils.insert(this::insert, record, loginLog, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(ip).toPropertyWhenPresent("ip", record::getIp)
            .map(apiName).toPropertyWhenPresent("apiName", record::getApiName)
            .map(apiRouter).toPropertyWhenPresent("apiRouter", record::getApiRouter)
            .map(time).toPropertyWhenPresent("time", record::getTime)
            .map(detail).toPropertyWhenPresent("detail", record::getDetail)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<LoginLog> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, loginLog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<LoginLog> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, loginLog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<LoginLog> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, loginLog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<LoginLog> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, loginLog, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(LoginLog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(userId).equalTo(record::getUserId)
                .set(ip).equalTo(record::getIp)
                .set(apiName).equalTo(record::getApiName)
                .set(apiRouter).equalTo(record::getApiRouter)
                .set(time).equalTo(record::getTime)
                .set(detail).equalTo(record::getDetail);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(LoginLog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(ip).equalToWhenPresent(record::getIp)
                .set(apiName).equalToWhenPresent(record::getApiName)
                .set(apiRouter).equalToWhenPresent(record::getApiRouter)
                .set(time).equalToWhenPresent(record::getTime)
                .set(detail).equalToWhenPresent(record::getDetail);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(LoginLog record) {
        return update(c ->
            c.set(userId).equalTo(record::getUserId)
            .set(ip).equalTo(record::getIp)
            .set(apiName).equalTo(record::getApiName)
            .set(apiRouter).equalTo(record::getApiRouter)
            .set(time).equalTo(record::getTime)
            .set(detail).equalTo(record::getDetail)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(LoginLog record) {
        return update(c ->
            c.set(userId).equalToWhenPresent(record::getUserId)
            .set(ip).equalToWhenPresent(record::getIp)
            .set(apiName).equalToWhenPresent(record::getApiName)
            .set(apiRouter).equalToWhenPresent(record::getApiRouter)
            .set(time).equalToWhenPresent(record::getTime)
            .set(detail).equalToWhenPresent(record::getDetail)
            .where(id, isEqualTo(record::getId))
        );
    }
}