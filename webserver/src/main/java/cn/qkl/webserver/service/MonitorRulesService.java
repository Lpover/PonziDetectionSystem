package cn.qkl.webserver.service;

import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.dao.SettingsMonitorRulesDao;
import cn.qkl.webserver.vo.settings.MonitorRulesInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * @param
 * @return
 */
@Slf4j
@Service
public class MonitorRulesService {
    @Autowired
    private SettingsMonitorRulesDao settingsMonitorRulesDao;

    public List<MonitorRulesInfoVO> getMonitorRulesInfo() {
        return settingsMonitorRulesDao.getMonitorRules(select(Tables.settingsMonitorRules.id, Tables.settingsMonitorRules.type,
                Tables.settingsMonitorRules.monitorFrequency.as("rule"), Tables.settingsMonitorRules.lastMonitorTime.as("lastMonitor"))
                .from(Tables.settingsMonitorRules)
                .build()
                .render(RenderingStrategies.MYBATIS3)
        );
    }
}
