package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.ContentCrossDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.ContentCross;
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
public interface ContentCrossMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, metaurl, chainId, address, hash, tokenId, accountId, startTime, dstChainId, dstAddress, dstHash, dstTokenId, dstAccountId, endTime, bridge, dynamicType, riskLevel, createTime, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ContentCross> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ContentCross> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ContentCrossResult")
    Optional<ContentCross> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ContentCrossResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="metaUrl", property="metaurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="chain_id", property="chainId", jdbcType=JdbcType.BIGINT),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="hash", property="hash", jdbcType=JdbcType.VARCHAR),
        @Result(column="token_id", property="tokenId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="dst_chain_id", property="dstChainId", jdbcType=JdbcType.BIGINT),
        @Result(column="dst_address", property="dstAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="dst_hash", property="dstHash", jdbcType=JdbcType.VARCHAR),
        @Result(column="dst_token_id", property="dstTokenId", jdbcType=JdbcType.VARCHAR),
        @Result(column="dst_account_id", property="dstAccountId", jdbcType=JdbcType.BIGINT),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bridge", property="bridge", jdbcType=JdbcType.INTEGER),
        @Result(column="dynamic_type", property="dynamicType", jdbcType=JdbcType.INTEGER),
        @Result(column="risk_level", property="riskLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ContentCross> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, contentCross, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, contentCross, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ContentCross record) {
        return MyBatis3Utils.insert(this::insert, record, contentCross, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(metaurl).toProperty("metaurl")
            .map(chainId).toProperty("chainId")
            .map(address).toProperty("address")
            .map(hash).toProperty("hash")
            .map(tokenId).toProperty("tokenId")
            .map(accountId).toProperty("accountId")
            .map(startTime).toProperty("startTime")
            .map(dstChainId).toProperty("dstChainId")
            .map(dstAddress).toProperty("dstAddress")
            .map(dstHash).toProperty("dstHash")
            .map(dstTokenId).toProperty("dstTokenId")
            .map(dstAccountId).toProperty("dstAccountId")
            .map(endTime).toProperty("endTime")
            .map(bridge).toProperty("bridge")
            .map(dynamicType).toProperty("dynamicType")
            .map(riskLevel).toProperty("riskLevel")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ContentCross> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, contentCross, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(metaurl).toProperty("metaurl")
            .map(chainId).toProperty("chainId")
            .map(address).toProperty("address")
            .map(hash).toProperty("hash")
            .map(tokenId).toProperty("tokenId")
            .map(accountId).toProperty("accountId")
            .map(startTime).toProperty("startTime")
            .map(dstChainId).toProperty("dstChainId")
            .map(dstAddress).toProperty("dstAddress")
            .map(dstHash).toProperty("dstHash")
            .map(dstTokenId).toProperty("dstTokenId")
            .map(dstAccountId).toProperty("dstAccountId")
            .map(endTime).toProperty("endTime")
            .map(bridge).toProperty("bridge")
            .map(dynamicType).toProperty("dynamicType")
            .map(riskLevel).toProperty("riskLevel")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ContentCross record) {
        return MyBatis3Utils.insert(this::insert, record, contentCross, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(metaurl).toPropertyWhenPresent("metaurl", record::getMetaurl)
            .map(chainId).toPropertyWhenPresent("chainId", record::getChainId)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
            .map(hash).toPropertyWhenPresent("hash", record::getHash)
            .map(tokenId).toPropertyWhenPresent("tokenId", record::getTokenId)
            .map(accountId).toPropertyWhenPresent("accountId", record::getAccountId)
            .map(startTime).toPropertyWhenPresent("startTime", record::getStartTime)
            .map(dstChainId).toPropertyWhenPresent("dstChainId", record::getDstChainId)
            .map(dstAddress).toPropertyWhenPresent("dstAddress", record::getDstAddress)
            .map(dstHash).toPropertyWhenPresent("dstHash", record::getDstHash)
            .map(dstTokenId).toPropertyWhenPresent("dstTokenId", record::getDstTokenId)
            .map(dstAccountId).toPropertyWhenPresent("dstAccountId", record::getDstAccountId)
            .map(endTime).toPropertyWhenPresent("endTime", record::getEndTime)
            .map(bridge).toPropertyWhenPresent("bridge", record::getBridge)
            .map(dynamicType).toPropertyWhenPresent("dynamicType", record::getDynamicType)
            .map(riskLevel).toPropertyWhenPresent("riskLevel", record::getRiskLevel)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ContentCross> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, contentCross, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ContentCross> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, contentCross, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ContentCross> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, contentCross, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ContentCross> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, contentCross, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ContentCross record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(metaurl).equalTo(record::getMetaurl)
                .set(chainId).equalTo(record::getChainId)
                .set(address).equalTo(record::getAddress)
                .set(hash).equalTo(record::getHash)
                .set(tokenId).equalTo(record::getTokenId)
                .set(accountId).equalTo(record::getAccountId)
                .set(startTime).equalTo(record::getStartTime)
                .set(dstChainId).equalTo(record::getDstChainId)
                .set(dstAddress).equalTo(record::getDstAddress)
                .set(dstHash).equalTo(record::getDstHash)
                .set(dstTokenId).equalTo(record::getDstTokenId)
                .set(dstAccountId).equalTo(record::getDstAccountId)
                .set(endTime).equalTo(record::getEndTime)
                .set(bridge).equalTo(record::getBridge)
                .set(dynamicType).equalTo(record::getDynamicType)
                .set(riskLevel).equalTo(record::getRiskLevel)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ContentCross record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(metaurl).equalToWhenPresent(record::getMetaurl)
                .set(chainId).equalToWhenPresent(record::getChainId)
                .set(address).equalToWhenPresent(record::getAddress)
                .set(hash).equalToWhenPresent(record::getHash)
                .set(tokenId).equalToWhenPresent(record::getTokenId)
                .set(accountId).equalToWhenPresent(record::getAccountId)
                .set(startTime).equalToWhenPresent(record::getStartTime)
                .set(dstChainId).equalToWhenPresent(record::getDstChainId)
                .set(dstAddress).equalToWhenPresent(record::getDstAddress)
                .set(dstHash).equalToWhenPresent(record::getDstHash)
                .set(dstTokenId).equalToWhenPresent(record::getDstTokenId)
                .set(dstAccountId).equalToWhenPresent(record::getDstAccountId)
                .set(endTime).equalToWhenPresent(record::getEndTime)
                .set(bridge).equalToWhenPresent(record::getBridge)
                .set(dynamicType).equalToWhenPresent(record::getDynamicType)
                .set(riskLevel).equalToWhenPresent(record::getRiskLevel)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ContentCross record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(metaurl).equalTo(record::getMetaurl)
            .set(chainId).equalTo(record::getChainId)
            .set(address).equalTo(record::getAddress)
            .set(hash).equalTo(record::getHash)
            .set(tokenId).equalTo(record::getTokenId)
            .set(accountId).equalTo(record::getAccountId)
            .set(startTime).equalTo(record::getStartTime)
            .set(dstChainId).equalTo(record::getDstChainId)
            .set(dstAddress).equalTo(record::getDstAddress)
            .set(dstHash).equalTo(record::getDstHash)
            .set(dstTokenId).equalTo(record::getDstTokenId)
            .set(dstAccountId).equalTo(record::getDstAccountId)
            .set(endTime).equalTo(record::getEndTime)
            .set(bridge).equalTo(record::getBridge)
            .set(dynamicType).equalTo(record::getDynamicType)
            .set(riskLevel).equalTo(record::getRiskLevel)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ContentCross record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(metaurl).equalToWhenPresent(record::getMetaurl)
            .set(chainId).equalToWhenPresent(record::getChainId)
            .set(address).equalToWhenPresent(record::getAddress)
            .set(hash).equalToWhenPresent(record::getHash)
            .set(tokenId).equalToWhenPresent(record::getTokenId)
            .set(accountId).equalToWhenPresent(record::getAccountId)
            .set(startTime).equalToWhenPresent(record::getStartTime)
            .set(dstChainId).equalToWhenPresent(record::getDstChainId)
            .set(dstAddress).equalToWhenPresent(record::getDstAddress)
            .set(dstHash).equalToWhenPresent(record::getDstHash)
            .set(dstTokenId).equalToWhenPresent(record::getDstTokenId)
            .set(dstAccountId).equalToWhenPresent(record::getDstAccountId)
            .set(endTime).equalToWhenPresent(record::getEndTime)
            .set(bridge).equalToWhenPresent(record::getBridge)
            .set(dynamicType).equalToWhenPresent(record::getDynamicType)
            .set(riskLevel).equalToWhenPresent(record::getRiskLevel)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}