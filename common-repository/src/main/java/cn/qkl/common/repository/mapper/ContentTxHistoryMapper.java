package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.ContentTxHistoryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.ContentTxHistory;
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
public interface ContentTxHistoryMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, contentId, event, price, from, to, ownerLogo, createTime, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ContentTxHistory> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ContentTxHistory> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ContentTxHistoryResult")
    Optional<ContentTxHistory> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ContentTxHistoryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content_id", property="contentId", jdbcType=JdbcType.BIGINT),
        @Result(column="event", property="event", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.VARCHAR),
        @Result(column="from", property="from", jdbcType=JdbcType.VARCHAR),
        @Result(column="to", property="to", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_logo", property="ownerLogo", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ContentTxHistory> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, contentTxHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, contentTxHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ContentTxHistory record) {
        return MyBatis3Utils.insert(this::insert, record, contentTxHistory, c ->
            c.map(id).toProperty("id")
            .map(contentId).toProperty("contentId")
            .map(event).toProperty("event")
            .map(price).toProperty("price")
            .map(from).toProperty("from")
            .map(to).toProperty("to")
            .map(ownerLogo).toProperty("ownerLogo")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ContentTxHistory> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, contentTxHistory, c ->
            c.map(id).toProperty("id")
            .map(contentId).toProperty("contentId")
            .map(event).toProperty("event")
            .map(price).toProperty("price")
            .map(from).toProperty("from")
            .map(to).toProperty("to")
            .map(ownerLogo).toProperty("ownerLogo")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ContentTxHistory record) {
        return MyBatis3Utils.insert(this::insert, record, contentTxHistory, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(contentId).toPropertyWhenPresent("contentId", record::getContentId)
            .map(event).toPropertyWhenPresent("event", record::getEvent)
            .map(price).toPropertyWhenPresent("price", record::getPrice)
            .map(from).toPropertyWhenPresent("from", record::getFrom)
            .map(to).toPropertyWhenPresent("to", record::getTo)
            .map(ownerLogo).toPropertyWhenPresent("ownerLogo", record::getOwnerLogo)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ContentTxHistory> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, contentTxHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ContentTxHistory> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, contentTxHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ContentTxHistory> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, contentTxHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ContentTxHistory> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, contentTxHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ContentTxHistory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(contentId).equalTo(record::getContentId)
                .set(event).equalTo(record::getEvent)
                .set(price).equalTo(record::getPrice)
                .set(from).equalTo(record::getFrom)
                .set(to).equalTo(record::getTo)
                .set(ownerLogo).equalTo(record::getOwnerLogo)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ContentTxHistory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(contentId).equalToWhenPresent(record::getContentId)
                .set(event).equalToWhenPresent(record::getEvent)
                .set(price).equalToWhenPresent(record::getPrice)
                .set(from).equalToWhenPresent(record::getFrom)
                .set(to).equalToWhenPresent(record::getTo)
                .set(ownerLogo).equalToWhenPresent(record::getOwnerLogo)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ContentTxHistory record) {
        return update(c ->
            c.set(contentId).equalTo(record::getContentId)
            .set(event).equalTo(record::getEvent)
            .set(price).equalTo(record::getPrice)
            .set(from).equalTo(record::getFrom)
            .set(to).equalTo(record::getTo)
            .set(ownerLogo).equalTo(record::getOwnerLogo)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ContentTxHistory record) {
        return update(c ->
            c.set(contentId).equalToWhenPresent(record::getContentId)
            .set(event).equalToWhenPresent(record::getEvent)
            .set(price).equalToWhenPresent(record::getPrice)
            .set(from).equalToWhenPresent(record::getFrom)
            .set(to).equalToWhenPresent(record::getTo)
            .set(ownerLogo).equalToWhenPresent(record::getOwnerLogo)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}