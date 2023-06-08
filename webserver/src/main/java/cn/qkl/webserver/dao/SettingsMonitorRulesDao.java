package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.SettingsMonitorRulesMapper;
import cn.qkl.webserver.vo.settings.MonitorRulesInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

@Mapper
public interface SettingsMonitorRulesDao extends SettingsMonitorRulesMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<MonitorRulesInfoVO> getMonitorRules(SelectStatementProvider selectStatementProvider);
}
