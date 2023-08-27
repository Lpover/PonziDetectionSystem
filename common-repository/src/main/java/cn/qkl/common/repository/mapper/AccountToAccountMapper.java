package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.AccountToAccountDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.AccountToAccount;
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
public interface AccountToAccountMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, from, to, fromRiskIndex, toRiskIndex, txAmount, txNum, fromRatio, toRatio, blockchain, currencyType, note, createTime, updateTime, protocols, label, toAmount, fromAmount, toNum, fromNum, toCounter, fromCounter, chainId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<AccountToAccount> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<AccountToAccount> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AccountToAccountResult")
    Optional<AccountToAccount> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AccountToAccountResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="from", property="from", jdbcType=JdbcType.VARCHAR),
        @Result(column="to", property="to", jdbcType=JdbcType.VARCHAR),
        @Result(column="from_risk_index", property="fromRiskIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="to_risk_index", property="toRiskIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="tx_amount", property="txAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="tx_num", property="txNum", jdbcType=JdbcType.BIGINT),
        @Result(column="from_ratio", property="fromRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="to_ratio", property="toRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="blockchain", property="blockchain", jdbcType=JdbcType.VARCHAR),
        @Result(column="currency_type", property="currencyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="protocols", property="protocols", jdbcType=JdbcType.VARCHAR),
        @Result(column="label", property="label", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_amount", property="toAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="from_amount", property="fromAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="to_num", property="toNum", jdbcType=JdbcType.BIGINT),
        @Result(column="from_num", property="fromNum", jdbcType=JdbcType.BIGINT),
        @Result(column="to_counter", property="toCounter", jdbcType=JdbcType.BIGINT),
        @Result(column="from_counter", property="fromCounter", jdbcType=JdbcType.BIGINT),
        @Result(column="chain_id", property="chainId", jdbcType=JdbcType.BIGINT)
    })
    List<AccountToAccount> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, accountToAccount, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, accountToAccount, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(AccountToAccount record) {
        return MyBatis3Utils.insert(this::insert, record, accountToAccount, c ->
            c.map(id).toProperty("id")
            .map(from).toProperty("from")
            .map(to).toProperty("to")
            .map(fromRiskIndex).toProperty("fromRiskIndex")
            .map(toRiskIndex).toProperty("toRiskIndex")
            .map(txAmount).toProperty("txAmount")
            .map(txNum).toProperty("txNum")
            .map(fromRatio).toProperty("fromRatio")
            .map(toRatio).toProperty("toRatio")
            .map(blockchain).toProperty("blockchain")
            .map(currencyType).toProperty("currencyType")
            .map(note).toProperty("note")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(protocols).toProperty("protocols")
            .map(label).toProperty("label")
            .map(toAmount).toProperty("toAmount")
            .map(fromAmount).toProperty("fromAmount")
            .map(toNum).toProperty("toNum")
            .map(fromNum).toProperty("fromNum")
            .map(toCounter).toProperty("toCounter")
            .map(fromCounter).toProperty("fromCounter")
            .map(chainId).toProperty("chainId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<AccountToAccount> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, accountToAccount, c ->
            c.map(id).toProperty("id")
            .map(from).toProperty("from")
            .map(to).toProperty("to")
            .map(fromRiskIndex).toProperty("fromRiskIndex")
            .map(toRiskIndex).toProperty("toRiskIndex")
            .map(txAmount).toProperty("txAmount")
            .map(txNum).toProperty("txNum")
            .map(fromRatio).toProperty("fromRatio")
            .map(toRatio).toProperty("toRatio")
            .map(blockchain).toProperty("blockchain")
            .map(currencyType).toProperty("currencyType")
            .map(note).toProperty("note")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(protocols).toProperty("protocols")
            .map(label).toProperty("label")
            .map(toAmount).toProperty("toAmount")
            .map(fromAmount).toProperty("fromAmount")
            .map(toNum).toProperty("toNum")
            .map(fromNum).toProperty("fromNum")
            .map(toCounter).toProperty("toCounter")
            .map(fromCounter).toProperty("fromCounter")
            .map(chainId).toProperty("chainId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(AccountToAccount record) {
        return MyBatis3Utils.insert(this::insert, record, accountToAccount, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(from).toPropertyWhenPresent("from", record::getFrom)
            .map(to).toPropertyWhenPresent("to", record::getTo)
            .map(fromRiskIndex).toPropertyWhenPresent("fromRiskIndex", record::getFromRiskIndex)
            .map(toRiskIndex).toPropertyWhenPresent("toRiskIndex", record::getToRiskIndex)
            .map(txAmount).toPropertyWhenPresent("txAmount", record::getTxAmount)
            .map(txNum).toPropertyWhenPresent("txNum", record::getTxNum)
            .map(fromRatio).toPropertyWhenPresent("fromRatio", record::getFromRatio)
            .map(toRatio).toPropertyWhenPresent("toRatio", record::getToRatio)
            .map(blockchain).toPropertyWhenPresent("blockchain", record::getBlockchain)
            .map(currencyType).toPropertyWhenPresent("currencyType", record::getCurrencyType)
            .map(note).toPropertyWhenPresent("note", record::getNote)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(protocols).toPropertyWhenPresent("protocols", record::getProtocols)
            .map(label).toPropertyWhenPresent("label", record::getLabel)
            .map(toAmount).toPropertyWhenPresent("toAmount", record::getToAmount)
            .map(fromAmount).toPropertyWhenPresent("fromAmount", record::getFromAmount)
            .map(toNum).toPropertyWhenPresent("toNum", record::getToNum)
            .map(fromNum).toPropertyWhenPresent("fromNum", record::getFromNum)
            .map(toCounter).toPropertyWhenPresent("toCounter", record::getToCounter)
            .map(fromCounter).toPropertyWhenPresent("fromCounter", record::getFromCounter)
            .map(chainId).toPropertyWhenPresent("chainId", record::getChainId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<AccountToAccount> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, accountToAccount, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<AccountToAccount> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, accountToAccount, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<AccountToAccount> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, accountToAccount, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<AccountToAccount> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, accountToAccount, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(AccountToAccount record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(from).equalTo(record::getFrom)
                .set(to).equalTo(record::getTo)
                .set(fromRiskIndex).equalTo(record::getFromRiskIndex)
                .set(toRiskIndex).equalTo(record::getToRiskIndex)
                .set(txAmount).equalTo(record::getTxAmount)
                .set(txNum).equalTo(record::getTxNum)
                .set(fromRatio).equalTo(record::getFromRatio)
                .set(toRatio).equalTo(record::getToRatio)
                .set(blockchain).equalTo(record::getBlockchain)
                .set(currencyType).equalTo(record::getCurrencyType)
                .set(note).equalTo(record::getNote)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(protocols).equalTo(record::getProtocols)
                .set(label).equalTo(record::getLabel)
                .set(toAmount).equalTo(record::getToAmount)
                .set(fromAmount).equalTo(record::getFromAmount)
                .set(toNum).equalTo(record::getToNum)
                .set(fromNum).equalTo(record::getFromNum)
                .set(toCounter).equalTo(record::getToCounter)
                .set(fromCounter).equalTo(record::getFromCounter)
                .set(chainId).equalTo(record::getChainId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AccountToAccount record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(from).equalToWhenPresent(record::getFrom)
                .set(to).equalToWhenPresent(record::getTo)
                .set(fromRiskIndex).equalToWhenPresent(record::getFromRiskIndex)
                .set(toRiskIndex).equalToWhenPresent(record::getToRiskIndex)
                .set(txAmount).equalToWhenPresent(record::getTxAmount)
                .set(txNum).equalToWhenPresent(record::getTxNum)
                .set(fromRatio).equalToWhenPresent(record::getFromRatio)
                .set(toRatio).equalToWhenPresent(record::getToRatio)
                .set(blockchain).equalToWhenPresent(record::getBlockchain)
                .set(currencyType).equalToWhenPresent(record::getCurrencyType)
                .set(note).equalToWhenPresent(record::getNote)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(protocols).equalToWhenPresent(record::getProtocols)
                .set(label).equalToWhenPresent(record::getLabel)
                .set(toAmount).equalToWhenPresent(record::getToAmount)
                .set(fromAmount).equalToWhenPresent(record::getFromAmount)
                .set(toNum).equalToWhenPresent(record::getToNum)
                .set(fromNum).equalToWhenPresent(record::getFromNum)
                .set(toCounter).equalToWhenPresent(record::getToCounter)
                .set(fromCounter).equalToWhenPresent(record::getFromCounter)
                .set(chainId).equalToWhenPresent(record::getChainId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(AccountToAccount record) {
        return update(c ->
            c.set(from).equalTo(record::getFrom)
            .set(to).equalTo(record::getTo)
            .set(fromRiskIndex).equalTo(record::getFromRiskIndex)
            .set(toRiskIndex).equalTo(record::getToRiskIndex)
            .set(txAmount).equalTo(record::getTxAmount)
            .set(txNum).equalTo(record::getTxNum)
            .set(fromRatio).equalTo(record::getFromRatio)
            .set(toRatio).equalTo(record::getToRatio)
            .set(blockchain).equalTo(record::getBlockchain)
            .set(currencyType).equalTo(record::getCurrencyType)
            .set(note).equalTo(record::getNote)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(protocols).equalTo(record::getProtocols)
            .set(label).equalTo(record::getLabel)
            .set(toAmount).equalTo(record::getToAmount)
            .set(fromAmount).equalTo(record::getFromAmount)
            .set(toNum).equalTo(record::getToNum)
            .set(fromNum).equalTo(record::getFromNum)
            .set(toCounter).equalTo(record::getToCounter)
            .set(fromCounter).equalTo(record::getFromCounter)
            .set(chainId).equalTo(record::getChainId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(AccountToAccount record) {
        return update(c ->
            c.set(from).equalToWhenPresent(record::getFrom)
            .set(to).equalToWhenPresent(record::getTo)
            .set(fromRiskIndex).equalToWhenPresent(record::getFromRiskIndex)
            .set(toRiskIndex).equalToWhenPresent(record::getToRiskIndex)
            .set(txAmount).equalToWhenPresent(record::getTxAmount)
            .set(txNum).equalToWhenPresent(record::getTxNum)
            .set(fromRatio).equalToWhenPresent(record::getFromRatio)
            .set(toRatio).equalToWhenPresent(record::getToRatio)
            .set(blockchain).equalToWhenPresent(record::getBlockchain)
            .set(currencyType).equalToWhenPresent(record::getCurrencyType)
            .set(note).equalToWhenPresent(record::getNote)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(protocols).equalToWhenPresent(record::getProtocols)
            .set(label).equalToWhenPresent(record::getLabel)
            .set(toAmount).equalToWhenPresent(record::getToAmount)
            .set(fromAmount).equalToWhenPresent(record::getFromAmount)
            .set(toNum).equalToWhenPresent(record::getToNum)
            .set(fromNum).equalToWhenPresent(record::getFromNum)
            .set(toCounter).equalToWhenPresent(record::getToCounter)
            .set(fromCounter).equalToWhenPresent(record::getFromCounter)
            .set(chainId).equalToWhenPresent(record::getChainId)
            .where(id, isEqualTo(record::getId))
        );
    }
}