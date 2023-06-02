package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.ContentCrossDailyStatisticsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.ContentCrossDailyStatistics;
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
public interface ContentCrossDailyStatisticsMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, chainId, riskAccountNum, txNum, createTime, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ContentCrossDailyStatistics> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ContentCrossDailyStatistics> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ContentCrossDailyStatisticsResult")
    Optional<ContentCrossDailyStatistics> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ContentCrossDailyStatisticsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="chain_id", property="chainId", jdbcType=JdbcType.BIGINT),
        @Result(column="risk_account_num", property="riskAccountNum", jdbcType=JdbcType.INTEGER),
        @Result(column="tx_num", property="txNum", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ContentCrossDailyStatistics> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, contentCrossDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, contentCrossDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ContentCrossDailyStatistics record) {
        return MyBatis3Utils.insert(this::insert, record, contentCrossDailyStatistics, c ->
            c.map(id).toProperty("id")
            .map(chainId).toProperty("chainId")
            .map(riskAccountNum).toProperty("riskAccountNum")
            .map(txNum).toProperty("txNum")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ContentCrossDailyStatistics> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, contentCrossDailyStatistics, c ->
            c.map(id).toProperty("id")
            .map(chainId).toProperty("chainId")
            .map(riskAccountNum).toProperty("riskAccountNum")
            .map(txNum).toProperty("txNum")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ContentCrossDailyStatistics record) {
        return MyBatis3Utils.insert(this::insert, record, contentCrossDailyStatistics, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(chainId).toPropertyWhenPresent("chainId", record::getChainId)
            .map(riskAccountNum).toPropertyWhenPresent("riskAccountNum", record::getRiskAccountNum)
            .map(txNum).toPropertyWhenPresent("txNum", record::getTxNum)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ContentCrossDailyStatistics> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, contentCrossDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ContentCrossDailyStatistics> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, contentCrossDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ContentCrossDailyStatistics> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, contentCrossDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ContentCrossDailyStatistics> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, contentCrossDailyStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ContentCrossDailyStatistics record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(chainId).equalTo(record::getChainId)
                .set(riskAccountNum).equalTo(record::getRiskAccountNum)
                .set(txNum).equalTo(record::getTxNum)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ContentCrossDailyStatistics record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(chainId).equalToWhenPresent(record::getChainId)
                .set(riskAccountNum).equalToWhenPresent(record::getRiskAccountNum)
                .set(txNum).equalToWhenPresent(record::getTxNum)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ContentCrossDailyStatistics record) {
        return update(c ->
            c.set(chainId).equalTo(record::getChainId)
            .set(riskAccountNum).equalTo(record::getRiskAccountNum)
            .set(txNum).equalTo(record::getTxNum)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ContentCrossDailyStatistics record) {
        return update(c ->
            c.set(chainId).equalToWhenPresent(record::getChainId)
            .set(riskAccountNum).equalToWhenPresent(record::getRiskAccountNum)
            .set(txNum).equalToWhenPresent(record::getTxNum)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}