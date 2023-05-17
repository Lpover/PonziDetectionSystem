package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.PlatformDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.Platform;
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
public interface PlatformMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, named, url, monitor, riskContentNum, activation, riskLevel, updateTime, platformType, logo, location, frequency, crawlerFile, web3Type, contentNum, highAccountNum, midAccountNum, lowAccountNum, highContentNum, midContentNum, lowContentNum, createTime, updataTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Platform> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Platform> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PlatformResult")
    Optional<Platform> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PlatformResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="named", property="named", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="monitor", property="monitor", jdbcType=JdbcType.INTEGER),
        @Result(column="risk_content_num", property="riskContentNum", jdbcType=JdbcType.BIGINT),
        @Result(column="activation", property="activation", jdbcType=JdbcType.INTEGER),
        @Result(column="risk_level", property="riskLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="platform_type", property="platformType", jdbcType=JdbcType.INTEGER),
        @Result(column="logo", property="logo", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.INTEGER),
        @Result(column="frequency", property="frequency", jdbcType=JdbcType.INTEGER),
        @Result(column="crawler_file", property="crawlerFile", jdbcType=JdbcType.VARCHAR),
        @Result(column="web3_type", property="web3Type", jdbcType=JdbcType.INTEGER),
        @Result(column="content_num", property="contentNum", jdbcType=JdbcType.BIGINT),
        @Result(column="high_account_num", property="highAccountNum", jdbcType=JdbcType.INTEGER),
        @Result(column="mid_account_num", property="midAccountNum", jdbcType=JdbcType.INTEGER),
        @Result(column="low_account_num", property="lowAccountNum", jdbcType=JdbcType.INTEGER),
        @Result(column="high_content_num", property="highContentNum", jdbcType=JdbcType.INTEGER),
        @Result(column="mid_content_num", property="midContentNum", jdbcType=JdbcType.INTEGER),
        @Result(column="low_content_num", property="lowContentNum", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updata_time", property="updataTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Platform> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, platform, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, platform, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Platform record) {
        return MyBatis3Utils.insert(this::insert, record, platform, c ->
            c.map(id).toProperty("id")
            .map(named).toProperty("named")
            .map(url).toProperty("url")
            .map(monitor).toProperty("monitor")
            .map(riskContentNum).toProperty("riskContentNum")
            .map(activation).toProperty("activation")
            .map(riskLevel).toProperty("riskLevel")
            .map(updateTime).toProperty("updateTime")
            .map(platformType).toProperty("platformType")
            .map(logo).toProperty("logo")
            .map(location).toProperty("location")
            .map(frequency).toProperty("frequency")
            .map(crawlerFile).toProperty("crawlerFile")
            .map(web3Type).toProperty("web3Type")
            .map(contentNum).toProperty("contentNum")
            .map(highAccountNum).toProperty("highAccountNum")
            .map(midAccountNum).toProperty("midAccountNum")
            .map(lowAccountNum).toProperty("lowAccountNum")
            .map(highContentNum).toProperty("highContentNum")
            .map(midContentNum).toProperty("midContentNum")
            .map(lowContentNum).toProperty("lowContentNum")
            .map(createTime).toProperty("createTime")
            .map(updataTime).toProperty("updataTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Platform> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, platform, c ->
            c.map(id).toProperty("id")
            .map(named).toProperty("named")
            .map(url).toProperty("url")
            .map(monitor).toProperty("monitor")
            .map(riskContentNum).toProperty("riskContentNum")
            .map(activation).toProperty("activation")
            .map(riskLevel).toProperty("riskLevel")
            .map(updateTime).toProperty("updateTime")
            .map(platformType).toProperty("platformType")
            .map(logo).toProperty("logo")
            .map(location).toProperty("location")
            .map(frequency).toProperty("frequency")
            .map(crawlerFile).toProperty("crawlerFile")
            .map(web3Type).toProperty("web3Type")
            .map(contentNum).toProperty("contentNum")
            .map(highAccountNum).toProperty("highAccountNum")
            .map(midAccountNum).toProperty("midAccountNum")
            .map(lowAccountNum).toProperty("lowAccountNum")
            .map(highContentNum).toProperty("highContentNum")
            .map(midContentNum).toProperty("midContentNum")
            .map(lowContentNum).toProperty("lowContentNum")
            .map(createTime).toProperty("createTime")
            .map(updataTime).toProperty("updataTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Platform record) {
        return MyBatis3Utils.insert(this::insert, record, platform, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(named).toPropertyWhenPresent("named", record::getNamed)
            .map(url).toPropertyWhenPresent("url", record::getUrl)
            .map(monitor).toPropertyWhenPresent("monitor", record::getMonitor)
            .map(riskContentNum).toPropertyWhenPresent("riskContentNum", record::getRiskContentNum)
            .map(activation).toPropertyWhenPresent("activation", record::getActivation)
            .map(riskLevel).toPropertyWhenPresent("riskLevel", record::getRiskLevel)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(platformType).toPropertyWhenPresent("platformType", record::getPlatformType)
            .map(logo).toPropertyWhenPresent("logo", record::getLogo)
            .map(location).toPropertyWhenPresent("location", record::getLocation)
            .map(frequency).toPropertyWhenPresent("frequency", record::getFrequency)
            .map(crawlerFile).toPropertyWhenPresent("crawlerFile", record::getCrawlerFile)
            .map(web3Type).toPropertyWhenPresent("web3Type", record::getWeb3Type)
            .map(contentNum).toPropertyWhenPresent("contentNum", record::getContentNum)
            .map(highAccountNum).toPropertyWhenPresent("highAccountNum", record::getHighAccountNum)
            .map(midAccountNum).toPropertyWhenPresent("midAccountNum", record::getMidAccountNum)
            .map(lowAccountNum).toPropertyWhenPresent("lowAccountNum", record::getLowAccountNum)
            .map(highContentNum).toPropertyWhenPresent("highContentNum", record::getHighContentNum)
            .map(midContentNum).toPropertyWhenPresent("midContentNum", record::getMidContentNum)
            .map(lowContentNum).toPropertyWhenPresent("lowContentNum", record::getLowContentNum)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updataTime).toPropertyWhenPresent("updataTime", record::getUpdataTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Platform> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, platform, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Platform> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, platform, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Platform> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, platform, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Platform> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, platform, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Platform record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(named).equalTo(record::getNamed)
                .set(url).equalTo(record::getUrl)
                .set(monitor).equalTo(record::getMonitor)
                .set(riskContentNum).equalTo(record::getRiskContentNum)
                .set(activation).equalTo(record::getActivation)
                .set(riskLevel).equalTo(record::getRiskLevel)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(platformType).equalTo(record::getPlatformType)
                .set(logo).equalTo(record::getLogo)
                .set(location).equalTo(record::getLocation)
                .set(frequency).equalTo(record::getFrequency)
                .set(crawlerFile).equalTo(record::getCrawlerFile)
                .set(web3Type).equalTo(record::getWeb3Type)
                .set(contentNum).equalTo(record::getContentNum)
                .set(highAccountNum).equalTo(record::getHighAccountNum)
                .set(midAccountNum).equalTo(record::getMidAccountNum)
                .set(lowAccountNum).equalTo(record::getLowAccountNum)
                .set(highContentNum).equalTo(record::getHighContentNum)
                .set(midContentNum).equalTo(record::getMidContentNum)
                .set(lowContentNum).equalTo(record::getLowContentNum)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updataTime).equalTo(record::getUpdataTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Platform record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(named).equalToWhenPresent(record::getNamed)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(monitor).equalToWhenPresent(record::getMonitor)
                .set(riskContentNum).equalToWhenPresent(record::getRiskContentNum)
                .set(activation).equalToWhenPresent(record::getActivation)
                .set(riskLevel).equalToWhenPresent(record::getRiskLevel)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(platformType).equalToWhenPresent(record::getPlatformType)
                .set(logo).equalToWhenPresent(record::getLogo)
                .set(location).equalToWhenPresent(record::getLocation)
                .set(frequency).equalToWhenPresent(record::getFrequency)
                .set(crawlerFile).equalToWhenPresent(record::getCrawlerFile)
                .set(web3Type).equalToWhenPresent(record::getWeb3Type)
                .set(contentNum).equalToWhenPresent(record::getContentNum)
                .set(highAccountNum).equalToWhenPresent(record::getHighAccountNum)
                .set(midAccountNum).equalToWhenPresent(record::getMidAccountNum)
                .set(lowAccountNum).equalToWhenPresent(record::getLowAccountNum)
                .set(highContentNum).equalToWhenPresent(record::getHighContentNum)
                .set(midContentNum).equalToWhenPresent(record::getMidContentNum)
                .set(lowContentNum).equalToWhenPresent(record::getLowContentNum)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updataTime).equalToWhenPresent(record::getUpdataTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Platform record) {
        return update(c ->
            c.set(named).equalTo(record::getNamed)
            .set(url).equalTo(record::getUrl)
            .set(monitor).equalTo(record::getMonitor)
            .set(riskContentNum).equalTo(record::getRiskContentNum)
            .set(activation).equalTo(record::getActivation)
            .set(riskLevel).equalTo(record::getRiskLevel)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(platformType).equalTo(record::getPlatformType)
            .set(logo).equalTo(record::getLogo)
            .set(location).equalTo(record::getLocation)
            .set(frequency).equalTo(record::getFrequency)
            .set(crawlerFile).equalTo(record::getCrawlerFile)
            .set(web3Type).equalTo(record::getWeb3Type)
            .set(contentNum).equalTo(record::getContentNum)
            .set(highAccountNum).equalTo(record::getHighAccountNum)
            .set(midAccountNum).equalTo(record::getMidAccountNum)
            .set(lowAccountNum).equalTo(record::getLowAccountNum)
            .set(highContentNum).equalTo(record::getHighContentNum)
            .set(midContentNum).equalTo(record::getMidContentNum)
            .set(lowContentNum).equalTo(record::getLowContentNum)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updataTime).equalTo(record::getUpdataTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Platform record) {
        return update(c ->
            c.set(named).equalToWhenPresent(record::getNamed)
            .set(url).equalToWhenPresent(record::getUrl)
            .set(monitor).equalToWhenPresent(record::getMonitor)
            .set(riskContentNum).equalToWhenPresent(record::getRiskContentNum)
            .set(activation).equalToWhenPresent(record::getActivation)
            .set(riskLevel).equalToWhenPresent(record::getRiskLevel)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(platformType).equalToWhenPresent(record::getPlatformType)
            .set(logo).equalToWhenPresent(record::getLogo)
            .set(location).equalToWhenPresent(record::getLocation)
            .set(frequency).equalToWhenPresent(record::getFrequency)
            .set(crawlerFile).equalToWhenPresent(record::getCrawlerFile)
            .set(web3Type).equalToWhenPresent(record::getWeb3Type)
            .set(contentNum).equalToWhenPresent(record::getContentNum)
            .set(highAccountNum).equalToWhenPresent(record::getHighAccountNum)
            .set(midAccountNum).equalToWhenPresent(record::getMidAccountNum)
            .set(lowAccountNum).equalToWhenPresent(record::getLowAccountNum)
            .set(highContentNum).equalToWhenPresent(record::getHighContentNum)
            .set(midContentNum).equalToWhenPresent(record::getMidContentNum)
            .set(lowContentNum).equalToWhenPresent(record::getLowContentNum)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updataTime).equalToWhenPresent(record::getUpdataTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}