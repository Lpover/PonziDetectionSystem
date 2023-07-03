package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.UserMapper;
import cn.qkl.common.repository.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

/**
 * @title:
 * @Author Wang Xin
 * @Date: 2022/7/23 17:37
 * @wiki
 */
@Mapper
public interface UserDao extends UserMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<User> getUserByIds(SelectStatementProvider selectStatementProvider);
}
