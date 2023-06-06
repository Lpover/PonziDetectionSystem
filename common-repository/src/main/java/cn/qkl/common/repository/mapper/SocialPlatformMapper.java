package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.SocialPlatformDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.SocialPlatform;
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
public interface SocialPlatformMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, socialPlatformIndex12h, socialPlatformIndex24h);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SocialPlatform> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SocialPlatform> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SocialPlatformResult")
    Optional<SocialPlatform> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SocialPlatformResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="social_platform_index_12h", property="socialPlatformIndex12h", jdbcType=JdbcType.DECIMAL),
        @Result(column="social_platform_index_24h", property="socialPlatformIndex24h", jdbcType=JdbcType.DECIMAL)
    })
    List<SocialPlatform> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, socialPlatform, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, socialPlatform, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SocialPlatform record) {
        return MyBatis3Utils.insert(this::insert, record, socialPlatform, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(socialPlatformIndex12h).toProperty("socialPlatformIndex12h")
            .map(socialPlatformIndex24h).toProperty("socialPlatformIndex24h")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<SocialPlatform> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, socialPlatform, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(socialPlatformIndex12h).toProperty("socialPlatformIndex12h")
            .map(socialPlatformIndex24h).toProperty("socialPlatformIndex24h")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SocialPlatform record) {
        return MyBatis3Utils.insert(this::insert, record, socialPlatform, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(socialPlatformIndex12h).toPropertyWhenPresent("socialPlatformIndex12h", record::getSocialPlatformIndex12h)
            .map(socialPlatformIndex24h).toPropertyWhenPresent("socialPlatformIndex24h", record::getSocialPlatformIndex24h)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SocialPlatform> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, socialPlatform, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SocialPlatform> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, socialPlatform, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SocialPlatform> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, socialPlatform, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SocialPlatform> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, socialPlatform, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SocialPlatform record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(socialPlatformIndex12h).equalTo(record::getSocialPlatformIndex12h)
                .set(socialPlatformIndex24h).equalTo(record::getSocialPlatformIndex24h);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SocialPlatform record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(socialPlatformIndex12h).equalToWhenPresent(record::getSocialPlatformIndex12h)
                .set(socialPlatformIndex24h).equalToWhenPresent(record::getSocialPlatformIndex24h);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SocialPlatform record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(socialPlatformIndex12h).equalTo(record::getSocialPlatformIndex12h)
            .set(socialPlatformIndex24h).equalTo(record::getSocialPlatformIndex24h)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SocialPlatform record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(socialPlatformIndex12h).equalToWhenPresent(record::getSocialPlatformIndex12h)
            .set(socialPlatformIndex24h).equalToWhenPresent(record::getSocialPlatformIndex24h)
            .where(id, isEqualTo(record::getId))
        );
    }
}