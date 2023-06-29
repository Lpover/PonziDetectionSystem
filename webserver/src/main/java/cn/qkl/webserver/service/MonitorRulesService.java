package cn.qkl.webserver.service;

import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.dao.SettingsMonitorRulesDao;
import cn.qkl.webserver.dto.settings.MonitorRulesModifyDTO;
import cn.qkl.webserver.vo.settings.MonitorRulesInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

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

    public void modifyMonitorRules(List<MonitorRulesModifyDTO> dto) {
        for (MonitorRulesModifyDTO monitorRulesModifyDTO : dto) {
            settingsMonitorRulesDao.update(c -> c
                    .set(Tables.settingsMonitorRules.monitorFrequency).equalTo(monitorRulesModifyDTO.getRule())
                    .set(Tables.settingsMonitorRules.updateTime).equalTo(new Date())
                    .where(Tables.settingsMonitorRules.id, isEqualTo(monitorRulesModifyDTO.getId()))
            );
        }
    }
}
