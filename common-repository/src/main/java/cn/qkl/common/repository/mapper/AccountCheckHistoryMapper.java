package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.AccountCheckHistoryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.AccountCheckHistory;
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
public interface AccountCheckHistoryMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, accountId, accountCheckTime, riskLevel, relatedNum, releaseNum, createTime, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<AccountCheckHistory> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<AccountCheckHistory> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AccountCheckHistoryResult")
    Optional<AccountCheckHistory> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AccountCheckHistoryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.BIGINT),
        @Result(column="account_check_time", property="accountCheckTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="risk_level", property="riskLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="related_num", property="relatedNum", jdbcType=JdbcType.INTEGER),
        @Result(column="release_num", property="releaseNum", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AccountCheckHistory> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, accountCheckHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, accountCheckHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(AccountCheckHistory record) {
        return MyBatis3Utils.insert(this::insert, record, accountCheckHistory, c ->
            c.map(id).toProperty("id")
            .map(accountId).toProperty("accountId")
            .map(accountCheckTime).toProperty("accountCheckTime")
            .map(riskLevel).toProperty("riskLevel")
            .map(relatedNum).toProperty("relatedNum")
            .map(releaseNum).toProperty("releaseNum")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<AccountCheckHistory> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, accountCheckHistory, c ->
            c.map(id).toProperty("id")
            .map(accountId).toProperty("accountId")
            .map(accountCheckTime).toProperty("accountCheckTime")
            .map(riskLevel).toProperty("riskLevel")
            .map(relatedNum).toProperty("relatedNum")
            .map(releaseNum).toProperty("releaseNum")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(AccountCheckHistory record) {
        return MyBatis3Utils.insert(this::insert, record, accountCheckHistory, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(accountId).toPropertyWhenPresent("accountId", record::getAccountId)
            .map(accountCheckTime).toPropertyWhenPresent("accountCheckTime", record::getAccountCheckTime)
            .map(riskLevel).toPropertyWhenPresent("riskLevel", record::getRiskLevel)
            .map(relatedNum).toPropertyWhenPresent("relatedNum", record::getRelatedNum)
            .map(releaseNum).toPropertyWhenPresent("releaseNum", record::getReleaseNum)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<AccountCheckHistory> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, accountCheckHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<AccountCheckHistory> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, accountCheckHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<AccountCheckHistory> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, accountCheckHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<AccountCheckHistory> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, accountCheckHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(AccountCheckHistory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(accountId).equalTo(record::getAccountId)
                .set(accountCheckTime).equalTo(record::getAccountCheckTime)
                .set(riskLevel).equalTo(record::getRiskLevel)
                .set(relatedNum).equalTo(record::getRelatedNum)
                .set(releaseNum).equalTo(record::getReleaseNum)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AccountCheckHistory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(accountId).equalToWhenPresent(record::getAccountId)
                .set(accountCheckTime).equalToWhenPresent(record::getAccountCheckTime)
                .set(riskLevel).equalToWhenPresent(record::getRiskLevel)
                .set(relatedNum).equalToWhenPresent(record::getRelatedNum)
                .set(releaseNum).equalToWhenPresent(record::getReleaseNum)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(AccountCheckHistory record) {
        return update(c ->
            c.set(accountId).equalTo(record::getAccountId)
            .set(accountCheckTime).equalTo(record::getAccountCheckTime)
            .set(riskLevel).equalTo(record::getRiskLevel)
            .set(relatedNum).equalTo(record::getRelatedNum)
            .set(releaseNum).equalTo(record::getReleaseNum)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(AccountCheckHistory record) {
        return update(c ->
            c.set(accountId).equalToWhenPresent(record::getAccountId)
            .set(accountCheckTime).equalToWhenPresent(record::getAccountCheckTime)
            .set(riskLevel).equalToWhenPresent(record::getRiskLevel)
            .set(relatedNum).equalToWhenPresent(record::getRelatedNum)
            .set(releaseNum).equalToWhenPresent(record::getReleaseNum)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}