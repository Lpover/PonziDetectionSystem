package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.StorageDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.Storage;
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
public interface StorageMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, platformId, storageNumber, storageType, updateTime, createTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Storage> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Storage> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("StorageResult")
    Optional<Storage> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="StorageResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="platform_id", property="platformId", jdbcType=JdbcType.BIGINT),
        @Result(column="storage_number", property="storageNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="storage_type", property="storageType", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Storage> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, storage, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, storage, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Storage record) {
        return MyBatis3Utils.insert(this::insert, record, storage, c ->
            c.map(id).toProperty("id")
            .map(platformId).toProperty("platformId")
            .map(storageNumber).toProperty("storageNumber")
            .map(storageType).toProperty("storageType")
            .map(updateTime).toProperty("updateTime")
            .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Storage> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, storage, c ->
            c.map(id).toProperty("id")
            .map(platformId).toProperty("platformId")
            .map(storageNumber).toProperty("storageNumber")
            .map(storageType).toProperty("storageType")
            .map(updateTime).toProperty("updateTime")
            .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Storage record) {
        return MyBatis3Utils.insert(this::insert, record, storage, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(platformId).toPropertyWhenPresent("platformId", record::getPlatformId)
            .map(storageNumber).toPropertyWhenPresent("storageNumber", record::getStorageNumber)
            .map(storageType).toPropertyWhenPresent("storageType", record::getStorageType)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Storage> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, storage, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Storage> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, storage, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Storage> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, storage, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Storage> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, storage, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Storage record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(platformId).equalTo(record::getPlatformId)
                .set(storageNumber).equalTo(record::getStorageNumber)
                .set(storageType).equalTo(record::getStorageType)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(createTime).equalTo(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Storage record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(platformId).equalToWhenPresent(record::getPlatformId)
                .set(storageNumber).equalToWhenPresent(record::getStorageNumber)
                .set(storageType).equalToWhenPresent(record::getStorageType)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Storage record) {
        return update(c ->
            c.set(platformId).equalTo(record::getPlatformId)
            .set(storageNumber).equalTo(record::getStorageNumber)
            .set(storageType).equalTo(record::getStorageType)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(createTime).equalTo(record::getCreateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Storage record) {
        return update(c ->
            c.set(platformId).equalToWhenPresent(record::getPlatformId)
            .set(storageNumber).equalToWhenPresent(record::getStorageNumber)
            .set(storageType).equalToWhenPresent(record::getStorageType)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}