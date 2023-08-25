package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.AccountTxHistoryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.AccountTxHistory;
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
public interface AccountTxHistoryMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, txHash, method, block, txTimestamp, from, to, value, txFee, chainId, createTime, updateTime, note);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<AccountTxHistory> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<AccountTxHistory> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AccountTxHistoryResult")
    Optional<AccountTxHistory> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AccountTxHistoryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="tx_hash", property="txHash", jdbcType=JdbcType.VARCHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="block", property="block", jdbcType=JdbcType.BIGINT),
        @Result(column="tx_timestamp", property="txTimestamp", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="from", property="from", jdbcType=JdbcType.VARCHAR),
        @Result(column="to", property="to", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="tx_fee", property="txFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="chain_id", property="chainId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<AccountTxHistory> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, accountTxHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, accountTxHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(AccountTxHistory record) {
        return MyBatis3Utils.insert(this::insert, record, accountTxHistory, c ->
            c.map(id).toProperty("id")
            .map(txHash).toProperty("txHash")
            .map(method).toProperty("method")
            .map(block).toProperty("block")
            .map(txTimestamp).toProperty("txTimestamp")
            .map(from).toProperty("from")
            .map(to).toProperty("to")
            .map(value).toProperty("value")
            .map(txFee).toProperty("txFee")
            .map(chainId).toProperty("chainId")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(note).toProperty("note")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<AccountTxHistory> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, accountTxHistory, c ->
            c.map(id).toProperty("id")
            .map(txHash).toProperty("txHash")
            .map(method).toProperty("method")
            .map(block).toProperty("block")
            .map(txTimestamp).toProperty("txTimestamp")
            .map(from).toProperty("from")
            .map(to).toProperty("to")
            .map(value).toProperty("value")
            .map(txFee).toProperty("txFee")
            .map(chainId).toProperty("chainId")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(note).toProperty("note")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(AccountTxHistory record) {
        return MyBatis3Utils.insert(this::insert, record, accountTxHistory, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(txHash).toPropertyWhenPresent("txHash", record::getTxHash)
            .map(method).toPropertyWhenPresent("method", record::getMethod)
            .map(block).toPropertyWhenPresent("block", record::getBlock)
            .map(txTimestamp).toPropertyWhenPresent("txTimestamp", record::getTxTimestamp)
            .map(from).toPropertyWhenPresent("from", record::getFrom)
            .map(to).toPropertyWhenPresent("to", record::getTo)
            .map(value).toPropertyWhenPresent("value", record::getValue)
            .map(txFee).toPropertyWhenPresent("txFee", record::getTxFee)
            .map(chainId).toPropertyWhenPresent("chainId", record::getChainId)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(note).toPropertyWhenPresent("note", record::getNote)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<AccountTxHistory> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, accountTxHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<AccountTxHistory> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, accountTxHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<AccountTxHistory> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, accountTxHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<AccountTxHistory> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, accountTxHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(AccountTxHistory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(txHash).equalTo(record::getTxHash)
                .set(method).equalTo(record::getMethod)
                .set(block).equalTo(record::getBlock)
                .set(txTimestamp).equalTo(record::getTxTimestamp)
                .set(from).equalTo(record::getFrom)
                .set(to).equalTo(record::getTo)
                .set(value).equalTo(record::getValue)
                .set(txFee).equalTo(record::getTxFee)
                .set(chainId).equalTo(record::getChainId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(note).equalTo(record::getNote);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AccountTxHistory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(txHash).equalToWhenPresent(record::getTxHash)
                .set(method).equalToWhenPresent(record::getMethod)
                .set(block).equalToWhenPresent(record::getBlock)
                .set(txTimestamp).equalToWhenPresent(record::getTxTimestamp)
                .set(from).equalToWhenPresent(record::getFrom)
                .set(to).equalToWhenPresent(record::getTo)
                .set(value).equalToWhenPresent(record::getValue)
                .set(txFee).equalToWhenPresent(record::getTxFee)
                .set(chainId).equalToWhenPresent(record::getChainId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(note).equalToWhenPresent(record::getNote);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(AccountTxHistory record) {
        return update(c ->
            c.set(txHash).equalTo(record::getTxHash)
            .set(method).equalTo(record::getMethod)
            .set(block).equalTo(record::getBlock)
            .set(txTimestamp).equalTo(record::getTxTimestamp)
            .set(from).equalTo(record::getFrom)
            .set(to).equalTo(record::getTo)
            .set(value).equalTo(record::getValue)
            .set(txFee).equalTo(record::getTxFee)
            .set(chainId).equalTo(record::getChainId)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(note).equalTo(record::getNote)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(AccountTxHistory record) {
        return update(c ->
            c.set(txHash).equalToWhenPresent(record::getTxHash)
            .set(method).equalToWhenPresent(record::getMethod)
            .set(block).equalToWhenPresent(record::getBlock)
            .set(txTimestamp).equalToWhenPresent(record::getTxTimestamp)
            .set(from).equalToWhenPresent(record::getFrom)
            .set(to).equalToWhenPresent(record::getTo)
            .set(value).equalToWhenPresent(record::getValue)
            .set(txFee).equalToWhenPresent(record::getTxFee)
            .set(chainId).equalToWhenPresent(record::getChainId)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(note).equalToWhenPresent(record::getNote)
            .where(id, isEqualTo(record::getId))
        );
    }
}