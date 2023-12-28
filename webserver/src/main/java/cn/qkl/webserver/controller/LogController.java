package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.log.LoginLogDTO;
import cn.qkl.webserver.dto.log.OperationLogDTO;
import cn.qkl.webserver.service.LogService;
import cn.qkl.webserver.vo.log.LoginLogVO;
import cn.qkl.webserver.vo.log.OperationLogVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author sunxiaen
 * @Date 2023/12/19 16:03
 **/

@RestController
@Slf4j
@Validated
@Api(value = "日志相关接口", tags = {"日志相关接口"})
@ApiSupport(author = "sxe")
@RequestMapping("log")
@Role(roles = {RoleEnum.AdminBaseRole.class})
public class LogController {

    @Resource
    LogService logService;

    @ApiOperation("登录日志")
    @GetMapping("api/login")
    public BaseResult<PageVO<LoginLogVO>> getLoginLog(LoginLogDTO dto) {
        return BaseResult.ok(logService.getLoginLog(dto));
    }

    @ApiOperation("操作日志")
    @GetMapping("api/operation")
    public BaseResult<PageVO<OperationLogVO>> getOperationLog(OperationLogDTO dto) {
        return BaseResult.ok(logService.getOperationLog(dto));
    }
}
