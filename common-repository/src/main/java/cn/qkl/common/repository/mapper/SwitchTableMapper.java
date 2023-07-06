package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.SwitchTableDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.SwitchTable;
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
public interface SwitchTableMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, open, openWeek, startTime, endTime, text);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SwitchTable> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SwitchTable> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SwitchTableResult")
    Optional<SwitchTable> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SwitchTableResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="open", property="open", jdbcType=JdbcType.INTEGER),
        @Result(column="open_week", property="openWeek", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIME),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIME),
        @Result(column="text", property="text", jdbcType=JdbcType.VARCHAR)
    })
    List<SwitchTable> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, switchTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, switchTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SwitchTable record) {
        return MyBatis3Utils.insert(this::insert, record, switchTable, c ->
            c.map(id).toProperty("id")
            .map(open).toProperty("open")
            .map(openWeek).toProperty("openWeek")
            .map(startTime).toProperty("startTime")
            .map(endTime).toProperty("endTime")
            .map(text).toProperty("text")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<SwitchTable> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, switchTable, c ->
            c.map(id).toProperty("id")
            .map(open).toProperty("open")
            .map(openWeek).toProperty("openWeek")
            .map(startTime).toProperty("startTime")
            .map(endTime).toProperty("endTime")
            .map(text).toProperty("text")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SwitchTable record) {
        return MyBatis3Utils.insert(this::insert, record, switchTable, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(open).toPropertyWhenPresent("open", record::getOpen)
            .map(openWeek).toPropertyWhenPresent("openWeek", record::getOpenWeek)
            .map(startTime).toPropertyWhenPresent("startTime", record::getStartTime)
            .map(endTime).toPropertyWhenPresent("endTime", record::getEndTime)
            .map(text).toPropertyWhenPresent("text", record::getText)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SwitchTable> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, switchTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SwitchTable> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, switchTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SwitchTable> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, switchTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SwitchTable> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, switchTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SwitchTable record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(open).equalTo(record::getOpen)
                .set(openWeek).equalTo(record::getOpenWeek)
                .set(startTime).equalTo(record::getStartTime)
                .set(endTime).equalTo(record::getEndTime)
                .set(text).equalTo(record::getText);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SwitchTable record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(open).equalToWhenPresent(record::getOpen)
                .set(openWeek).equalToWhenPresent(record::getOpenWeek)
                .set(startTime).equalToWhenPresent(record::getStartTime)
                .set(endTime).equalToWhenPresent(record::getEndTime)
                .set(text).equalToWhenPresent(record::getText);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SwitchTable record) {
        return update(c ->
            c.set(open).equalTo(record::getOpen)
            .set(openWeek).equalTo(record::getOpenWeek)
            .set(startTime).equalTo(record::getStartTime)
            .set(endTime).equalTo(record::getEndTime)
            .set(text).equalTo(record::getText)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SwitchTable record) {
        return update(c ->
            c.set(open).equalToWhenPresent(record::getOpen)
            .set(openWeek).equalToWhenPresent(record::getOpenWeek)
            .set(startTime).equalToWhenPresent(record::getStartTime)
            .set(endTime).equalToWhenPresent(record::getEndTime)
            .set(text).equalToWhenPresent(record::getText)
            .where(id, isEqualTo(record::getId))
        );
    }
}