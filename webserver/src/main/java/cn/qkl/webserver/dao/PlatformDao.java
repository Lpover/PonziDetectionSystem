package cn.qkl.webserver.dao;

import cn.qkl.common.framework.util.mybatis.DateTypeHandler;
import cn.qkl.common.repository.mapper.AlgorithmMapper;
import cn.qkl.common.repository.mapper.PlatformMapper;
import cn.qkl.webserver.vo.dynamic.DynamicContentExportVO;
import cn.qkl.webserver.vo.dynamic.DynamicContentVO;
import cn.qkl.webserver.vo.platform.PlatformContentVO;
import cn.qkl.webserver.vo.platform.PlatformListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.springframework.boot.BootstrapRegistry;

import java.util.Date;
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
