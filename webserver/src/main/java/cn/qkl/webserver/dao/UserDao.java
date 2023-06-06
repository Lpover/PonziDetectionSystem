package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

/**
 * @title:
 * @Author Wang Xin
 * @Date: 2022/7/23 17:37
 * @wiki
 */
@Mapper
public interface UserDao extends UserMapper {

}
