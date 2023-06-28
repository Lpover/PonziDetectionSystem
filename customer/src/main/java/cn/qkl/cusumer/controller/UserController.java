package cn.qkl.cusumer.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.repository.model.User;
import cn.qkl.cusumer.common.auth.RoleEnum;
import cn.qkl.cusumer.dto.user.LoginDTO;

import cn.qkl.cusumer.service.user.UserService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@Role(roles = RoleEnum.UserBaseRole.class)
public class UserController {

//    @LoadBalanced
    @Autowired
    private UserService userService;

    @Value("${webserver.alias:kknone}")
    public String webServerAlias;

    @Value("${webserver.ag:100}")
    public int webServerAge;

    public void testAge() {
        System.out.println(webServerAge);
    }
    @ApiOperation("登录")
    @PostMapping("login")
    @Role
    public BaseResult<String> emailLogin(@RequestBody @Validated LoginDTO dto) {
        return BaseResult.ok(userService.emailLogin(dto));
    }

    @ApiOperation("获取个人信息")
    @GetMapping("info")
    @Role
    public BaseResult<User> getUserInfo() {
        return BaseResult.ok(userService.getUserInfo());
    }

    @ApiOperation("获取个人信息")
    @GetMapping("remote/info")
    @Role
    public BaseResult<User> getRemoteInfo() {
        return BaseResult.ok(userService.getRemoteUserInfo());
    }

}
