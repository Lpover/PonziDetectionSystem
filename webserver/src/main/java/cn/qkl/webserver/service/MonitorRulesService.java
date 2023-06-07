package cn.qkl.webserver.service;

import cn.qkl.webserver.vo.settings.MonitorRulesInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @return
 */
@Slf4j
@Service
public class MonitorRulesService {
    public List<MonitorRulesInfoVO> getMonitorRules() {
        MonitorRulesInfoVO monitorRulesInfoVO = new MonitorRulesInfoVO();
        List<MonitorRulesInfoVO> list = new ArrayList<>();
        list.add(monitorRulesInfoVO);
        return list;
    }
}
