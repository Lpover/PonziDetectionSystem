package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.ContentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.Content;
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
public interface ContentMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, address, tokenid, metaUrl, cryptoPrice, currencyPrice, creator, platformId, standard, chainId, listingTime, description, dynamicType, dynamicAlgorithm, dynamicRecognition, revised, riskLevel, contentType, contentTag, riskType, owner, mintTime, accountId, thingType, createTime, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Content> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Content> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ContentResult")
    Optional<Content> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ContentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="tokenID", property="tokenid", jdbcType=JdbcType.INTEGER),
        @Result(column="meta_url", property="metaUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="crypto_price", property="cryptoPrice", jdbcType=JdbcType.VARCHAR),
        @Result(column="currency_price", property="currencyPrice", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator", property="creator", jdbcType=JdbcType.VARCHAR),
        @Result(column="platform_id", property="platformId", jdbcType=JdbcType.BIGINT),
        @Result(column="standard", property="standard", jdbcType=JdbcType.VARCHAR),
        @Result(column="chain_id", property="chainId", jdbcType=JdbcType.BIGINT),
        @Result(column="listing_time", property="listingTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="dynamic_type", property="dynamicType", jdbcType=JdbcType.INTEGER),
        @Result(column="dynamic_algorithm", property="dynamicAlgorithm", jdbcType=JdbcType.BIGINT),
        @Result(column="dynamic_recognition", property="dynamicRecognition", jdbcType=JdbcType.INTEGER),
        @Result(column="revised", property="revised", jdbcType=JdbcType.INTEGER),
        @Result(column="risk_level", property="riskLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="content_type", property="contentType", jdbcType=JdbcType.INTEGER),
        @Result(column="content_tag", property="contentTag", jdbcType=JdbcType.VARCHAR),
        @Result(column="risk_type", property="riskType", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner", property="owner", jdbcType=JdbcType.VARCHAR),
        @Result(column="mint_time", property="mintTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.BIGINT),
        @Result(column="thing_type", property="thingType", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Content> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, content, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, content, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Content record) {
        return MyBatis3Utils.insert(this::insert, record, content, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(address).toProperty("address")
            .map(tokenid).toProperty("tokenid")
            .map(metaUrl).toProperty("metaUrl")
            .map(cryptoPrice).toProperty("cryptoPrice")
            .map(currencyPrice).toProperty("currencyPrice")
            .map(creator).toProperty("creator")
            .map(platformId).toProperty("platformId")
            .map(standard).toProperty("standard")
            .map(chainId).toProperty("chainId")
            .map(listingTime).toProperty("listingTime")
            .map(description).toProperty("description")
            .map(dynamicType).toProperty("dynamicType")
            .map(dynamicAlgorithm).toProperty("dynamicAlgorithm")
            .map(dynamicRecognition).toProperty("dynamicRecognition")
            .map(revised).toProperty("revised")
            .map(riskLevel).toProperty("riskLevel")
            .map(contentType).toProperty("contentType")
            .map(contentTag).toProperty("contentTag")
            .map(riskType).toProperty("riskType")
            .map(owner).toProperty("owner")
            .map(mintTime).toProperty("mintTime")
            .map(accountId).toProperty("accountId")
            .map(thingType).toProperty("thingType")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Content> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, content, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(address).toProperty("address")
            .map(tokenid).toProperty("tokenid")
            .map(metaUrl).toProperty("metaUrl")
            .map(cryptoPrice).toProperty("cryptoPrice")
            .map(currencyPrice).toProperty("currencyPrice")
            .map(creator).toProperty("creator")
            .map(platformId).toProperty("platformId")
            .map(standard).toProperty("standard")
            .map(chainId).toProperty("chainId")
            .map(listingTime).toProperty("listingTime")
            .map(description).toProperty("description")
            .map(dynamicType).toProperty("dynamicType")
            .map(dynamicAlgorithm).toProperty("dynamicAlgorithm")
            .map(dynamicRecognition).toProperty("dynamicRecognition")
            .map(revised).toProperty("revised")
            .map(riskLevel).toProperty("riskLevel")
            .map(contentType).toProperty("contentType")
            .map(contentTag).toProperty("contentTag")
            .map(riskType).toProperty("riskType")
            .map(owner).toProperty("owner")
            .map(mintTime).toProperty("mintTime")
            .map(accountId).toProperty("accountId")
            .map(thingType).toProperty("thingType")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Content record) {
        return MyBatis3Utils.insert(this::insert, record, content, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
            .map(tokenid).toPropertyWhenPresent("tokenid", record::getTokenid)
            .map(metaUrl).toPropertyWhenPresent("metaUrl", record::getMetaUrl)
            .map(cryptoPrice).toPropertyWhenPresent("cryptoPrice", record::getCryptoPrice)
            .map(currencyPrice).toPropertyWhenPresent("currencyPrice", record::getCurrencyPrice)
            .map(creator).toPropertyWhenPresent("creator", record::getCreator)
            .map(platformId).toPropertyWhenPresent("platformId", record::getPlatformId)
            .map(standard).toPropertyWhenPresent("standard", record::getStandard)
            .map(chainId).toPropertyWhenPresent("chainId", record::getChainId)
            .map(listingTime).toPropertyWhenPresent("listingTime", record::getListingTime)
            .map(description).toPropertyWhenPresent("description", record::getDescription)
            .map(dynamicType).toPropertyWhenPresent("dynamicType", record::getDynamicType)
            .map(dynamicAlgorithm).toPropertyWhenPresent("dynamicAlgorithm", record::getDynamicAlgorithm)
            .map(dynamicRecognition).toPropertyWhenPresent("dynamicRecognition", record::getDynamicRecognition)
            .map(revised).toPropertyWhenPresent("revised", record::getRevised)
            .map(riskLevel).toPropertyWhenPresent("riskLevel", record::getRiskLevel)
            .map(contentType).toPropertyWhenPresent("contentType", record::getContentType)
            .map(contentTag).toPropertyWhenPresent("contentTag", record::getContentTag)
            .map(riskType).toPropertyWhenPresent("riskType", record::getRiskType)
            .map(owner).toPropertyWhenPresent("owner", record::getOwner)
            .map(mintTime).toPropertyWhenPresent("mintTime", record::getMintTime)
            .map(accountId).toPropertyWhenPresent("accountId", record::getAccountId)
            .map(thingType).toPropertyWhenPresent("thingType", record::getThingType)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Content> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, content, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Content> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, content, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Content> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, content, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Content> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, content, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Content record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(address).equalTo(record::getAddress)
                .set(tokenid).equalTo(record::getTokenid)
                .set(metaUrl).equalTo(record::getMetaUrl)
                .set(cryptoPrice).equalTo(record::getCryptoPrice)
                .set(currencyPrice).equalTo(record::getCurrencyPrice)
                .set(creator).equalTo(record::getCreator)
                .set(platformId).equalTo(record::getPlatformId)
                .set(standard).equalTo(record::getStandard)
                .set(chainId).equalTo(record::getChainId)
                .set(listingTime).equalTo(record::getListingTime)
                .set(description).equalTo(record::getDescription)
                .set(dynamicType).equalTo(record::getDynamicType)
                .set(dynamicAlgorithm).equalTo(record::getDynamicAlgorithm)
                .set(dynamicRecognition).equalTo(record::getDynamicRecognition)
                .set(revised).equalTo(record::getRevised)
                .set(riskLevel).equalTo(record::getRiskLevel)
                .set(contentType).equalTo(record::getContentType)
                .set(contentTag).equalTo(record::getContentTag)
                .set(riskType).equalTo(record::getRiskType)
                .set(owner).equalTo(record::getOwner)
                .set(mintTime).equalTo(record::getMintTime)
                .set(accountId).equalTo(record::getAccountId)
                .set(thingType).equalTo(record::getThingType)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Content record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(address).equalToWhenPresent(record::getAddress)
                .set(tokenid).equalToWhenPresent(record::getTokenid)
                .set(metaUrl).equalToWhenPresent(record::getMetaUrl)
                .set(cryptoPrice).equalToWhenPresent(record::getCryptoPrice)
                .set(currencyPrice).equalToWhenPresent(record::getCurrencyPrice)
                .set(creator).equalToWhenPresent(record::getCreator)
                .set(platformId).equalToWhenPresent(record::getPlatformId)
                .set(standard).equalToWhenPresent(record::getStandard)
                .set(chainId).equalToWhenPresent(record::getChainId)
                .set(listingTime).equalToWhenPresent(record::getListingTime)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(dynamicType).equalToWhenPresent(record::getDynamicType)
                .set(dynamicAlgorithm).equalToWhenPresent(record::getDynamicAlgorithm)
                .set(dynamicRecognition).equalToWhenPresent(record::getDynamicRecognition)
                .set(revised).equalToWhenPresent(record::getRevised)
                .set(riskLevel).equalToWhenPresent(record::getRiskLevel)
                .set(contentType).equalToWhenPresent(record::getContentType)
                .set(contentTag).equalToWhenPresent(record::getContentTag)
                .set(riskType).equalToWhenPresent(record::getRiskType)
                .set(owner).equalToWhenPresent(record::getOwner)
                .set(mintTime).equalToWhenPresent(record::getMintTime)
                .set(accountId).equalToWhenPresent(record::getAccountId)
                .set(thingType).equalToWhenPresent(record::getThingType)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Content record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(address).equalTo(record::getAddress)
            .set(tokenid).equalTo(record::getTokenid)
            .set(metaUrl).equalTo(record::getMetaUrl)
            .set(cryptoPrice).equalTo(record::getCryptoPrice)
            .set(currencyPrice).equalTo(record::getCurrencyPrice)
            .set(creator).equalTo(record::getCreator)
            .set(platformId).equalTo(record::getPlatformId)
            .set(standard).equalTo(record::getStandard)
            .set(chainId).equalTo(record::getChainId)
            .set(listingTime).equalTo(record::getListingTime)
            .set(description).equalTo(record::getDescription)
            .set(dynamicType).equalTo(record::getDynamicType)
            .set(dynamicAlgorithm).equalTo(record::getDynamicAlgorithm)
            .set(dynamicRecognition).equalTo(record::getDynamicRecognition)
            .set(revised).equalTo(record::getRevised)
            .set(riskLevel).equalTo(record::getRiskLevel)
            .set(contentType).equalTo(record::getContentType)
            .set(contentTag).equalTo(record::getContentTag)
            .set(riskType).equalTo(record::getRiskType)
            .set(owner).equalTo(record::getOwner)
            .set(mintTime).equalTo(record::getMintTime)
            .set(accountId).equalTo(record::getAccountId)
            .set(thingType).equalTo(record::getThingType)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Content record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(address).equalToWhenPresent(record::getAddress)
            .set(tokenid).equalToWhenPresent(record::getTokenid)
            .set(metaUrl).equalToWhenPresent(record::getMetaUrl)
            .set(cryptoPrice).equalToWhenPresent(record::getCryptoPrice)
            .set(currencyPrice).equalToWhenPresent(record::getCurrencyPrice)
            .set(creator).equalToWhenPresent(record::getCreator)
            .set(platformId).equalToWhenPresent(record::getPlatformId)
            .set(standard).equalToWhenPresent(record::getStandard)
            .set(chainId).equalToWhenPresent(record::getChainId)
            .set(listingTime).equalToWhenPresent(record::getListingTime)
            .set(description).equalToWhenPresent(record::getDescription)
            .set(dynamicType).equalToWhenPresent(record::getDynamicType)
            .set(dynamicAlgorithm).equalToWhenPresent(record::getDynamicAlgorithm)
            .set(dynamicRecognition).equalToWhenPresent(record::getDynamicRecognition)
            .set(revised).equalToWhenPresent(record::getRevised)
            .set(riskLevel).equalToWhenPresent(record::getRiskLevel)
            .set(contentType).equalToWhenPresent(record::getContentType)
            .set(contentTag).equalToWhenPresent(record::getContentTag)
            .set(riskType).equalToWhenPresent(record::getRiskType)
            .set(owner).equalToWhenPresent(record::getOwner)
            .set(mintTime).equalToWhenPresent(record::getMintTime)
            .set(accountId).equalToWhenPresent(record::getAccountId)
            .set(thingType).equalToWhenPresent(record::getThingType)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}