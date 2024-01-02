package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.MiniappEvidenceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.MiniappEvidence;
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
public interface MiniappEvidenceMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, time, expiredTime, url, userid, preserved);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<MiniappEvidence> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<MiniappEvidence> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MiniappEvidenceResult")
    Optional<MiniappEvidence> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MiniappEvidenceResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="userId", property="userid", jdbcType=JdbcType.BIGINT),
        @Result(column="preserved", property="preserved", jdbcType=JdbcType.INTEGER)
    })
    List<MiniappEvidence> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, miniappEvidence, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, miniappEvidence, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(MiniappEvidence record) {
        return MyBatis3Utils.insert(this::insert, record, miniappEvidence, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(time).toProperty("time")
            .map(expiredTime).toProperty("expiredTime")
            .map(url).toProperty("url")
            .map(userid).toProperty("userid")
            .map(preserved).toProperty("preserved")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<MiniappEvidence> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, miniappEvidence, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(time).toProperty("time")
            .map(expiredTime).toProperty("expiredTime")
            .map(url).toProperty("url")
            .map(userid).toProperty("userid")
            .map(preserved).toProperty("preserved")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(MiniappEvidence record) {
        return MyBatis3Utils.insert(this::insert, record, miniappEvidence, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(time).toPropertyWhenPresent("time", record::getTime)
            .map(expiredTime).toPropertyWhenPresent("expiredTime", record::getExpiredTime)
            .map(url).toPropertyWhenPresent("url", record::getUrl)
            .map(userid).toPropertyWhenPresent("userid", record::getUserid)
            .map(preserved).toPropertyWhenPresent("preserved", record::getPreserved)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<MiniappEvidence> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, miniappEvidence, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<MiniappEvidence> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, miniappEvidence, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<MiniappEvidence> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, miniappEvidence, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<MiniappEvidence> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, miniappEvidence, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(MiniappEvidence record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(time).equalTo(record::getTime)
                .set(expiredTime).equalTo(record::getExpiredTime)
                .set(url).equalTo(record::getUrl)
                .set(userid).equalTo(record::getUserid)
                .set(preserved).equalTo(record::getPreserved);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(MiniappEvidence record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(time).equalToWhenPresent(record::getTime)
                .set(expiredTime).equalToWhenPresent(record::getExpiredTime)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(userid).equalToWhenPresent(record::getUserid)
                .set(preserved).equalToWhenPresent(record::getPreserved);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(MiniappEvidence record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(time).equalTo(record::getTime)
            .set(expiredTime).equalTo(record::getExpiredTime)
            .set(url).equalTo(record::getUrl)
            .set(userid).equalTo(record::getUserid)
            .set(preserved).equalTo(record::getPreserved)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(MiniappEvidence record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(time).equalToWhenPresent(record::getTime)
            .set(expiredTime).equalToWhenPresent(record::getExpiredTime)
            .set(url).equalToWhenPresent(record::getUrl)
            .set(userid).equalToWhenPresent(record::getUserid)
            .set(preserved).equalToWhenPresent(record::getPreserved)
            .where(id, isEqualTo(record::getId))
        );
    }
}