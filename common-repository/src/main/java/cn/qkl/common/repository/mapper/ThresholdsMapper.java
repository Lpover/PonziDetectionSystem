package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.ThresholdsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.Thresholds;
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
public interface ThresholdsMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, nowIndex, setIndex, updateTime, createTime, on, num);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Thresholds> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Thresholds> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ThresholdsResult")
    Optional<Thresholds> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ThresholdsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="now_index", property="nowIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="set_index", property="setIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="on", property="on", jdbcType=JdbcType.INTEGER),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER)
    })
    List<Thresholds> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, thresholds, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, thresholds, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Thresholds record) {
        return MyBatis3Utils.insert(this::insert, record, thresholds, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(nowIndex).toProperty("nowIndex")
            .map(setIndex).toProperty("setIndex")
            .map(updateTime).toProperty("updateTime")
            .map(createTime).toProperty("createTime")
            .map(on).toProperty("on")
            .map(num).toProperty("num")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Thresholds> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, thresholds, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(nowIndex).toProperty("nowIndex")
            .map(setIndex).toProperty("setIndex")
            .map(updateTime).toProperty("updateTime")
            .map(createTime).toProperty("createTime")
            .map(on).toProperty("on")
            .map(num).toProperty("num")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Thresholds record) {
        return MyBatis3Utils.insert(this::insert, record, thresholds, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(nowIndex).toPropertyWhenPresent("nowIndex", record::getNowIndex)
            .map(setIndex).toPropertyWhenPresent("setIndex", record::getSetIndex)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(on).toPropertyWhenPresent("on", record::getOn)
            .map(num).toPropertyWhenPresent("num", record::getNum)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Thresholds> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, thresholds, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Thresholds> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, thresholds, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Thresholds> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, thresholds, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Thresholds> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, thresholds, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Thresholds record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(nowIndex).equalTo(record::getNowIndex)
                .set(setIndex).equalTo(record::getSetIndex)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(createTime).equalTo(record::getCreateTime)
                .set(on).equalTo(record::getOn)
                .set(num).equalTo(record::getNum);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Thresholds record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(nowIndex).equalToWhenPresent(record::getNowIndex)
                .set(setIndex).equalToWhenPresent(record::getSetIndex)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(on).equalToWhenPresent(record::getOn)
                .set(num).equalToWhenPresent(record::getNum);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Thresholds record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(nowIndex).equalTo(record::getNowIndex)
            .set(setIndex).equalTo(record::getSetIndex)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(createTime).equalTo(record::getCreateTime)
            .set(on).equalTo(record::getOn)
            .set(num).equalTo(record::getNum)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Thresholds record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(nowIndex).equalToWhenPresent(record::getNowIndex)
            .set(setIndex).equalToWhenPresent(record::getSetIndex)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(on).equalToWhenPresent(record::getOn)
            .set(num).equalToWhenPresent(record::getNum)
            .where(id, isEqualTo(record::getId))
        );
    }
}