package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.common.log.ApiRecord;
import cn.qkl.webserver.common.log.OperationApiType;
import cn.qkl.webserver.dto.settings.MonitorRulesModifyDTO;
import cn.qkl.webserver.service.MonitorRulesService;
import cn.qkl.webserver.vo.settings.MonitorRulesInfoVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Validated
@Api(value = "设置相关接口", tags = {"设置相关接口"})
@ApiSupport(author = "zz/ly")
@RequestMapping("settings")
@RefreshScope
@Role(roles = {RoleEnum.AdminBaseRole.class})
@ApiRecord(apiType = OperationApiType.class)
public class SettingsController {

    @Autowired
    private MonitorRulesService monitorRulesService;

    @ApiOperation("查看监测规则列表")
    @GetMapping("monitor/rules/info")
    public BaseResult<List<MonitorRulesInfoVO>> getMonitorRules() {
        return BaseResult.ok(monitorRulesService.getMonitorRulesInfo());
    }

    @ApiOperation("修改监测规则")
    @PutMapping("monitor/rules")
    public BaseResult<Void> modifyMonitorRules(@RequestBody @Validated List<MonitorRulesModifyDTO> dto) {
        monitorRulesService.modifyMonitorRules(dto);
        return BaseResult.ok();
    }
}
