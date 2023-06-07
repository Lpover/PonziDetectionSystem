package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.user.AddUserDTO;
import cn.qkl.webserver.dto.user.LoginDTO;
import cn.qkl.webserver.dto.user.ModifyPwdDTO;
import cn.qkl.webserver.service.UserService;
import cn.qkl.webserver.vo.user.UserInfoVO;
import cn.qkl.webserver.vo.user.UserListVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @PostMapping("login")
    @Role
    public BaseResult<String> emailLogin(@RequestBody @Validated LoginDTO dto) {
        return BaseResult.ok(userService.emailLogin(dto));
    }

//    @ApiOperation("获取个人信息")
//    @GetMapping("info")
//    public BaseResult<UserInfoVO> getUserInfo() {
//        return BaseResult.ok(userService.getUserInfo());
//    }

    @ApiOperation("用户列表")
    @GetMapping("list")
    @Role(roles = { RoleEnum.AdminBaseRole.class})
    public BaseResult<List<UserListVO>> getUserList() {
        return BaseResult.ok(userService.getUserList());
    }

    @ApiOperation("添加普通用户")
    @PostMapping("normal")
    @Role(roles = { RoleEnum.AdminBaseRole.class})
    public BaseResult<Void> addUser(@Validated @RequestBody AddUserDTO dto) {
        userService.addUser(dto);
        return BaseResult.ok();
    }

    @ApiOperation("修改密码")
    @PutMapping("pwd")
    @Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
    public BaseResult<Void> modifyPwd(@Validated @RequestBody ModifyPwdDTO dto) {
        userService.modifyPwd(dto);
        return BaseResult.ok();
    }
}
