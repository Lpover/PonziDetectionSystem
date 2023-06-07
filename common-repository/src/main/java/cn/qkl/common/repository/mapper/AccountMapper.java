package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.AccountDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.Account;
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
public interface AccountMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, accountAddress, chainId, accountAlias, image, cryptoBalance, currencyBalance, exchangeRate, createTime, updateTime, platformId, releaseNum);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Account> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Account> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AccountResult")
    Optional<Account> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AccountResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account_address", property="accountAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="chain_id", property="chainId", jdbcType=JdbcType.BIGINT),
        @Result(column="account_alias", property="accountAlias", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="crypto_balance", property="cryptoBalance", jdbcType=JdbcType.VARCHAR),
        @Result(column="currency_balance", property="currencyBalance", jdbcType=JdbcType.VARCHAR),
        @Result(column="exchange_rate", property="exchangeRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="platform_id", property="platformId", jdbcType=JdbcType.BIGINT),
        @Result(column="release_num", property="releaseNum", jdbcType=JdbcType.INTEGER)
    })
    List<Account> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, account, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, account, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Account record) {
        return MyBatis3Utils.insert(this::insert, record, account, c ->
            c.map(id).toProperty("id")
            .map(accountAddress).toProperty("accountAddress")
            .map(chainId).toProperty("chainId")
            .map(accountAlias).toProperty("accountAlias")
            .map(image).toProperty("image")
            .map(cryptoBalance).toProperty("cryptoBalance")
            .map(currencyBalance).toProperty("currencyBalance")
            .map(exchangeRate).toProperty("exchangeRate")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(platformId).toProperty("platformId")
            .map(releaseNum).toProperty("releaseNum")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Account> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, account, c ->
            c.map(id).toProperty("id")
            .map(accountAddress).toProperty("accountAddress")
            .map(chainId).toProperty("chainId")
            .map(accountAlias).toProperty("accountAlias")
            .map(image).toProperty("image")
            .map(cryptoBalance).toProperty("cryptoBalance")
            .map(currencyBalance).toProperty("currencyBalance")
            .map(exchangeRate).toProperty("exchangeRate")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(platformId).toProperty("platformId")
            .map(releaseNum).toProperty("releaseNum")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Account record) {
        return MyBatis3Utils.insert(this::insert, record, account, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(accountAddress).toPropertyWhenPresent("accountAddress", record::getAccountAddress)
            .map(chainId).toPropertyWhenPresent("chainId", record::getChainId)
            .map(accountAlias).toPropertyWhenPresent("accountAlias", record::getAccountAlias)
            .map(image).toPropertyWhenPresent("image", record::getImage)
            .map(cryptoBalance).toPropertyWhenPresent("cryptoBalance", record::getCryptoBalance)
            .map(currencyBalance).toPropertyWhenPresent("currencyBalance", record::getCurrencyBalance)
            .map(exchangeRate).toPropertyWhenPresent("exchangeRate", record::getExchangeRate)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(platformId).toPropertyWhenPresent("platformId", record::getPlatformId)
            .map(releaseNum).toPropertyWhenPresent("releaseNum", record::getReleaseNum)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Account> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, account, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Account> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, account, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Account> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, account, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Account> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, account, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Account record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(accountAddress).equalTo(record::getAccountAddress)
                .set(chainId).equalTo(record::getChainId)
                .set(accountAlias).equalTo(record::getAccountAlias)
                .set(image).equalTo(record::getImage)
                .set(cryptoBalance).equalTo(record::getCryptoBalance)
                .set(currencyBalance).equalTo(record::getCurrencyBalance)
                .set(exchangeRate).equalTo(record::getExchangeRate)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(platformId).equalTo(record::getPlatformId)
                .set(releaseNum).equalTo(record::getReleaseNum);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Account record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(accountAddress).equalToWhenPresent(record::getAccountAddress)
                .set(chainId).equalToWhenPresent(record::getChainId)
                .set(accountAlias).equalToWhenPresent(record::getAccountAlias)
                .set(image).equalToWhenPresent(record::getImage)
                .set(cryptoBalance).equalToWhenPresent(record::getCryptoBalance)
                .set(currencyBalance).equalToWhenPresent(record::getCurrencyBalance)
                .set(exchangeRate).equalToWhenPresent(record::getExchangeRate)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(platformId).equalToWhenPresent(record::getPlatformId)
                .set(releaseNum).equalToWhenPresent(record::getReleaseNum);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Account record) {
        return update(c ->
            c.set(accountAddress).equalTo(record::getAccountAddress)
            .set(chainId).equalTo(record::getChainId)
            .set(accountAlias).equalTo(record::getAccountAlias)
            .set(image).equalTo(record::getImage)
            .set(cryptoBalance).equalTo(record::getCryptoBalance)
            .set(currencyBalance).equalTo(record::getCurrencyBalance)
            .set(exchangeRate).equalTo(record::getExchangeRate)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(platformId).equalTo(record::getPlatformId)
            .set(releaseNum).equalTo(record::getReleaseNum)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Account record) {
        return update(c ->
            c.set(accountAddress).equalToWhenPresent(record::getAccountAddress)
            .set(chainId).equalToWhenPresent(record::getChainId)
            .set(accountAlias).equalToWhenPresent(record::getAccountAlias)
            .set(image).equalToWhenPresent(record::getImage)
            .set(cryptoBalance).equalToWhenPresent(record::getCryptoBalance)
            .set(currencyBalance).equalToWhenPresent(record::getCurrencyBalance)
            .set(exchangeRate).equalToWhenPresent(record::getExchangeRate)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(platformId).equalToWhenPresent(record::getPlatformId)
            .set(releaseNum).equalToWhenPresent(record::getReleaseNum)
            .where(id, isEqualTo(record::getId))
        );
    }
}