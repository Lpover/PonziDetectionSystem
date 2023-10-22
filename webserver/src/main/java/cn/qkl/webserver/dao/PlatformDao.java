package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.PlatformMapper;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.common.repository.model.PlatformDailyStatistics;
import cn.qkl.webserver.vo.platform.PlatformContentVO;
import cn.qkl.webserver.vo.riskAccount.AccountNumVO;
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
public interface PlatformDao extends PlatformMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<PlatformContentVO> getPlatformContent(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    AccountNumVO getAccountNum(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<Platform> getHotnessOfPlatform(SelectStatementProvider selectStatementProvider);
}
