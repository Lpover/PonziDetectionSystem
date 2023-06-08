package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.SocialPlatformHourStatisticsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.SocialPlatformHourStatistics;
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
public interface SocialPlatformHourStatisticsMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, socialPlatformId, createTime, updateTime, sensitiveNum, nonSensitiveNum, posEmotionNum, negEmotionNum);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SocialPlatformHourStatistics> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SocialPlatformHourStatistics> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SocialPlatformHourStatisticsResult")
    Optional<SocialPlatformHourStatistics> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SocialPlatformHourStatisticsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="social_platform_id", property="socialPlatformId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sensitive_num", property="sensitiveNum", jdbcType=JdbcType.INTEGER),
        @Result(column="non_sensitive_num", property="nonSensitiveNum", jdbcType=JdbcType.INTEGER),
        @Result(column="pos_emotion_num", property="posEmotionNum", jdbcType=JdbcType.INTEGER),
        @Result(column="neg_emotion_num", property="negEmotionNum", jdbcType=JdbcType.INTEGER)
    })
    List<SocialPlatformHourStatistics> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, socialPlatformHourStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, socialPlatformHourStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SocialPlatformHourStatistics record) {
        return MyBatis3Utils.insert(this::insert, record, socialPlatformHourStatistics, c ->
            c.map(id).toProperty("id")
            .map(socialPlatformId).toProperty("socialPlatformId")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(sensitiveNum).toProperty("sensitiveNum")
            .map(nonSensitiveNum).toProperty("nonSensitiveNum")
            .map(posEmotionNum).toProperty("posEmotionNum")
            .map(negEmotionNum).toProperty("negEmotionNum")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<SocialPlatformHourStatistics> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, socialPlatformHourStatistics, c ->
            c.map(id).toProperty("id")
            .map(socialPlatformId).toProperty("socialPlatformId")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(sensitiveNum).toProperty("sensitiveNum")
            .map(nonSensitiveNum).toProperty("nonSensitiveNum")
            .map(posEmotionNum).toProperty("posEmotionNum")
            .map(negEmotionNum).toProperty("negEmotionNum")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SocialPlatformHourStatistics record) {
        return MyBatis3Utils.insert(this::insert, record, socialPlatformHourStatistics, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(socialPlatformId).toPropertyWhenPresent("socialPlatformId", record::getSocialPlatformId)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(sensitiveNum).toPropertyWhenPresent("sensitiveNum", record::getSensitiveNum)
            .map(nonSensitiveNum).toPropertyWhenPresent("nonSensitiveNum", record::getNonSensitiveNum)
            .map(posEmotionNum).toPropertyWhenPresent("posEmotionNum", record::getPosEmotionNum)
            .map(negEmotionNum).toPropertyWhenPresent("negEmotionNum", record::getNegEmotionNum)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SocialPlatformHourStatistics> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, socialPlatformHourStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SocialPlatformHourStatistics> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, socialPlatformHourStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SocialPlatformHourStatistics> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, socialPlatformHourStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SocialPlatformHourStatistics> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, socialPlatformHourStatistics, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SocialPlatformHourStatistics record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(socialPlatformId).equalTo(record::getSocialPlatformId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(sensitiveNum).equalTo(record::getSensitiveNum)
                .set(nonSensitiveNum).equalTo(record::getNonSensitiveNum)
                .set(posEmotionNum).equalTo(record::getPosEmotionNum)
                .set(negEmotionNum).equalTo(record::getNegEmotionNum);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SocialPlatformHourStatistics record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(socialPlatformId).equalToWhenPresent(record::getSocialPlatformId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(sensitiveNum).equalToWhenPresent(record::getSensitiveNum)
                .set(nonSensitiveNum).equalToWhenPresent(record::getNonSensitiveNum)
                .set(posEmotionNum).equalToWhenPresent(record::getPosEmotionNum)
                .set(negEmotionNum).equalToWhenPresent(record::getNegEmotionNum);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SocialPlatformHourStatistics record) {
        return update(c ->
            c.set(socialPlatformId).equalTo(record::getSocialPlatformId)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(sensitiveNum).equalTo(record::getSensitiveNum)
            .set(nonSensitiveNum).equalTo(record::getNonSensitiveNum)
            .set(posEmotionNum).equalTo(record::getPosEmotionNum)
            .set(negEmotionNum).equalTo(record::getNegEmotionNum)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SocialPlatformHourStatistics record) {
        return update(c ->
            c.set(socialPlatformId).equalToWhenPresent(record::getSocialPlatformId)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(sensitiveNum).equalToWhenPresent(record::getSensitiveNum)
            .set(nonSensitiveNum).equalToWhenPresent(record::getNonSensitiveNum)
            .set(posEmotionNum).equalToWhenPresent(record::getPosEmotionNum)
            .set(negEmotionNum).equalToWhenPresent(record::getNegEmotionNum)
            .where(id, isEqualTo(record::getId))
        );
    }
}