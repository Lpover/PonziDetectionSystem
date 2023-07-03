package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.NotifyRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.NotifyRecord;
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
public interface NotifyRecordMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, notifyItemIds, userIds, createTime, updateTime, status);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<NotifyRecord> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<NotifyRecord> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("NotifyRecordResult")
    Optional<NotifyRecord> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="NotifyRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="notify_item_ids", property="notifyItemIds", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_ids", property="userIds", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<NotifyRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, notifyRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, notifyRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(NotifyRecord record) {
        return MyBatis3Utils.insert(this::insert, record, notifyRecord, c ->
            c.map(id).toProperty("id")
            .map(notifyItemIds).toProperty("notifyItemIds")
            .map(userIds).toProperty("userIds")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(status).toProperty("status")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<NotifyRecord> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, notifyRecord, c ->
            c.map(id).toProperty("id")
            .map(notifyItemIds).toProperty("notifyItemIds")
            .map(userIds).toProperty("userIds")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(status).toProperty("status")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(NotifyRecord record) {
        return MyBatis3Utils.insert(this::insert, record, notifyRecord, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(notifyItemIds).toPropertyWhenPresent("notifyItemIds", record::getNotifyItemIds)
            .map(userIds).toPropertyWhenPresent("userIds", record::getUserIds)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<NotifyRecord> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, notifyRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<NotifyRecord> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, notifyRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<NotifyRecord> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, notifyRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<NotifyRecord> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, notifyRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(NotifyRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(notifyItemIds).equalTo(record::getNotifyItemIds)
                .set(userIds).equalTo(record::getUserIds)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(status).equalTo(record::getStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(NotifyRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(notifyItemIds).equalToWhenPresent(record::getNotifyItemIds)
                .set(userIds).equalToWhenPresent(record::getUserIds)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(NotifyRecord record) {
        return update(c ->
            c.set(notifyItemIds).equalTo(record::getNotifyItemIds)
            .set(userIds).equalTo(record::getUserIds)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(NotifyRecord record) {
        return update(c ->
            c.set(notifyItemIds).equalToWhenPresent(record::getNotifyItemIds)
            .set(userIds).equalToWhenPresent(record::getUserIds)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}