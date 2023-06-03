package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.dto.user.LoginDTO;
import cn.qkl.webserver.service.UserService;
import cn.qkl.webserver.vo.user.UserInfoVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:31
 * @wiki
 */
@RestController
@Slf4j
@Validated
@Api(value = "用户相关接口", tags = {"用户相关接口"})
@ApiSupport(author = "wx")
@RequestMapping("user")
@RefreshScope
@Role
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @PostMapping("login")
    public BaseResult<String> emailLogin(@RequestBody @Validated LoginDTO dto) {
        return BaseResult.ok(userService.emailLogin(dto));
    }

    @ApiOperation("获取个人信息")
    @GetMapping("info")
    public BaseResult<UserInfoVO> getUserInfo() {
        return BaseResult.ok(userService.getUserInfo());
    }
}
