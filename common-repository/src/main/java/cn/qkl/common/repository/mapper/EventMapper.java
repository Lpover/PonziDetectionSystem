package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.EventDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.Event;
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
public interface EventMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, title, abstractText, hotNum12h, hotNum24h);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Event> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Event> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EventResult")
    Optional<Event> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="EventResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="abstract_text", property="abstractText", jdbcType=JdbcType.VARCHAR),
        @Result(column="hot_num_12h", property="hotNum12h", jdbcType=JdbcType.INTEGER),
        @Result(column="hot_num_24h", property="hotNum24h", jdbcType=JdbcType.INTEGER)
    })
    List<Event> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, event, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, event, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Event record) {
        return MyBatis3Utils.insert(this::insert, record, event, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(abstractText).toProperty("abstractText")
            .map(hotNum12h).toProperty("hotNum12h")
            .map(hotNum24h).toProperty("hotNum24h")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Event> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, event, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(abstractText).toProperty("abstractText")
            .map(hotNum12h).toProperty("hotNum12h")
            .map(hotNum24h).toProperty("hotNum24h")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Event record) {
        return MyBatis3Utils.insert(this::insert, record, event, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(abstractText).toPropertyWhenPresent("abstractText", record::getAbstractText)
            .map(hotNum12h).toPropertyWhenPresent("hotNum12h", record::getHotNum12h)
            .map(hotNum24h).toPropertyWhenPresent("hotNum24h", record::getHotNum24h)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Event> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, event, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Event> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, event, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Event> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, event, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Event> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, event, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Event record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(title).equalTo(record::getTitle)
                .set(abstractText).equalTo(record::getAbstractText)
                .set(hotNum12h).equalTo(record::getHotNum12h)
                .set(hotNum24h).equalTo(record::getHotNum24h);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Event record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(abstractText).equalToWhenPresent(record::getAbstractText)
                .set(hotNum12h).equalToWhenPresent(record::getHotNum12h)
                .set(hotNum24h).equalToWhenPresent(record::getHotNum24h);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Event record) {
        return update(c ->
            c.set(title).equalTo(record::getTitle)
            .set(abstractText).equalTo(record::getAbstractText)
            .set(hotNum12h).equalTo(record::getHotNum12h)
            .set(hotNum24h).equalTo(record::getHotNum24h)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Event record) {
        return update(c ->
            c.set(title).equalToWhenPresent(record::getTitle)
            .set(abstractText).equalToWhenPresent(record::getAbstractText)
            .set(hotNum12h).equalToWhenPresent(record::getHotNum12h)
            .set(hotNum24h).equalToWhenPresent(record::getHotNum24h)
            .where(id, isEqualTo(record::getId))
        );
    }
}