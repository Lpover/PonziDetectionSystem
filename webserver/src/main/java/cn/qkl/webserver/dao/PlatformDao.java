package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.PlatformMapper;
import cn.qkl.webserver.vo.platform.PlatformContentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

/**
 * @title:
 * @Author ly yang
 * @Date: 2022/7/23 17:37
 * @wiki
 */
@Mapper
public interface PlatformDao extends PlatformMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<PlatformContentVO> getPlatformContent(SelectStatementProvider selectStatementProvider);

}
