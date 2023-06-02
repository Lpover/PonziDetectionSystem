package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.UserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.User;
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
public interface UserMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(userId, userNum, userPwd, userPhone, userRole, userName, userImgUrl, userSex, userRegdate, userIntro, randomnum, state, email);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<User> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<User> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    Optional<User> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_num", property="userNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_pwd", property="userPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_img_url", property="userImgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_sex", property="userSex", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_regdate", property="userRegdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_intro", property="userIntro", jdbcType=JdbcType.VARCHAR),
        @Result(column="randomNum", property="randomnum", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long userId_) {
        return delete(c -> 
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(userId).toProperty("userId")
            .map(userNum).toProperty("userNum")
            .map(userPwd).toProperty("userPwd")
            .map(userPhone).toProperty("userPhone")
            .map(userRole).toProperty("userRole")
            .map(userName).toProperty("userName")
            .map(userImgUrl).toProperty("userImgUrl")
            .map(userSex).toProperty("userSex")
            .map(userRegdate).toProperty("userRegdate")
            .map(userIntro).toProperty("userIntro")
            .map(randomnum).toProperty("randomnum")
            .map(state).toProperty("state")
            .map(email).toProperty("email")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<User> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, user, c ->
            c.map(userId).toProperty("userId")
            .map(userNum).toProperty("userNum")
            .map(userPwd).toProperty("userPwd")
            .map(userPhone).toProperty("userPhone")
            .map(userRole).toProperty("userRole")
            .map(userName).toProperty("userName")
            .map(userImgUrl).toProperty("userImgUrl")
            .map(userSex).toProperty("userSex")
            .map(userRegdate).toProperty("userRegdate")
            .map(userIntro).toProperty("userIntro")
            .map(randomnum).toProperty("randomnum")
            .map(state).toProperty("state")
            .map(email).toProperty("email")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(userNum).toPropertyWhenPresent("userNum", record::getUserNum)
            .map(userPwd).toPropertyWhenPresent("userPwd", record::getUserPwd)
            .map(userPhone).toPropertyWhenPresent("userPhone", record::getUserPhone)
            .map(userRole).toPropertyWhenPresent("userRole", record::getUserRole)
            .map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(userImgUrl).toPropertyWhenPresent("userImgUrl", record::getUserImgUrl)
            .map(userSex).toPropertyWhenPresent("userSex", record::getUserSex)
            .map(userRegdate).toPropertyWhenPresent("userRegdate", record::getUserRegdate)
            .map(userIntro).toPropertyWhenPresent("userIntro", record::getUserIntro)
            .map(randomnum).toPropertyWhenPresent("randomnum", record::getRandomnum)
            .map(state).toPropertyWhenPresent("state", record::getState)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<User> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<User> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<User> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<User> selectByPrimaryKey(Long userId_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(userNum).equalTo(record::getUserNum)
                .set(userPwd).equalTo(record::getUserPwd)
                .set(userPhone).equalTo(record::getUserPhone)
                .set(userRole).equalTo(record::getUserRole)
                .set(userName).equalTo(record::getUserName)
                .set(userImgUrl).equalTo(record::getUserImgUrl)
                .set(userSex).equalTo(record::getUserSex)
                .set(userRegdate).equalTo(record::getUserRegdate)
                .set(userIntro).equalTo(record::getUserIntro)
                .set(randomnum).equalTo(record::getRandomnum)
                .set(state).equalTo(record::getState)
                .set(email).equalTo(record::getEmail);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(userNum).equalToWhenPresent(record::getUserNum)
                .set(userPwd).equalToWhenPresent(record::getUserPwd)
                .set(userPhone).equalToWhenPresent(record::getUserPhone)
                .set(userRole).equalToWhenPresent(record::getUserRole)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(userImgUrl).equalToWhenPresent(record::getUserImgUrl)
                .set(userSex).equalToWhenPresent(record::getUserSex)
                .set(userRegdate).equalToWhenPresent(record::getUserRegdate)
                .set(userIntro).equalToWhenPresent(record::getUserIntro)
                .set(randomnum).equalToWhenPresent(record::getRandomnum)
                .set(state).equalToWhenPresent(record::getState)
                .set(email).equalToWhenPresent(record::getEmail);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(User record) {
        return update(c ->
            c.set(userNum).equalTo(record::getUserNum)
            .set(userPwd).equalTo(record::getUserPwd)
            .set(userPhone).equalTo(record::getUserPhone)
            .set(userRole).equalTo(record::getUserRole)
            .set(userName).equalTo(record::getUserName)
            .set(userImgUrl).equalTo(record::getUserImgUrl)
            .set(userSex).equalTo(record::getUserSex)
            .set(userRegdate).equalTo(record::getUserRegdate)
            .set(userIntro).equalTo(record::getUserIntro)
            .set(randomnum).equalTo(record::getRandomnum)
            .set(state).equalTo(record::getState)
            .set(email).equalTo(record::getEmail)
            .where(userId, isEqualTo(record::getUserId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(User record) {
        return update(c ->
            c.set(userNum).equalToWhenPresent(record::getUserNum)
            .set(userPwd).equalToWhenPresent(record::getUserPwd)
            .set(userPhone).equalToWhenPresent(record::getUserPhone)
            .set(userRole).equalToWhenPresent(record::getUserRole)
            .set(userName).equalToWhenPresent(record::getUserName)
            .set(userImgUrl).equalToWhenPresent(record::getUserImgUrl)
            .set(userSex).equalToWhenPresent(record::getUserSex)
            .set(userRegdate).equalToWhenPresent(record::getUserRegdate)
            .set(userIntro).equalToWhenPresent(record::getUserIntro)
            .set(randomnum).equalToWhenPresent(record::getRandomnum)
            .set(state).equalToWhenPresent(record::getState)
            .set(email).equalToWhenPresent(record::getEmail)
            .where(userId, isEqualTo(record::getUserId))
        );
    }
}