package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.settings.MonitorRulesModifyDTO;
import cn.qkl.webserver.vo.settings.MonitorRulesInfoVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @return
 */
@RestController
@Slf4j
@Validated
@Api(value = "设置相关接口", tags = {"设置相关接口"})
@ApiSupport(author = "zz/ly")
@RequestMapping("settings")
@RefreshScope
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
public class SettingsController {
    @ApiOperation("查看监测规则列表")
    @GetMapping("monitor/rules/info")
    public BaseResult<List<MonitorRulesInfoVO>> getMonitorRules() {
        return BaseResult.ok(new ArrayList());
    }

    @ApiOperation("修改监测规则列表")
    @PutMapping("monitor/rules/modify")
    public BaseResult<Void> modifyMonitorRules(@Validated MonitorRulesModifyDTO dto) {
        return BaseResult.ok();
    }
}
