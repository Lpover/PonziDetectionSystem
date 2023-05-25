package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.request.PageDTO;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.dynamic.DynamicContentListQueryDTO;
import cn.qkl.webserver.dto.dynamic.ReCheckDynamicTypeDTO;
import cn.qkl.webserver.dto.platform.*;
import cn.qkl.webserver.dto.user.LoginDTO;
import cn.qkl.webserver.service.DynamicContentService;
import cn.qkl.webserver.service.PlatformService;
import cn.qkl.webserver.service.UserService;
import cn.qkl.webserver.vo.platform.PlatformContentVO;
import cn.qkl.webserver.vo.platform.PlatformListVO;
import cn.qkl.webserver.vo.platform.PlatformNameListVO;
import cn.qkl.webserver.vo.platform.PlatformSuperviseListVO;
import cn.qkl.webserver.vo.user.UserInfoVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @title:
 * @Author li yang
 * @Date: 2023/5/17 21:31
 * @wiki
 */
@RestController
@Slf4j
@Validated
@Api(value = "平台相关接口", tags = {"平台相关接口"})
@ApiSupport(author = "ly")
@RequestMapping("platform")
@RefreshScope
@Role
public class  PlatformController {

    @Autowired
    private PlatformService platformService;
    @ApiOperation("查询热门nft或web3平台")
    @GetMapping("list/type")
    public BaseResult<List<PlatformContentVO>> getPopularPlatform(@Validated PopularPlatformQueryDTO dto) {
        return BaseResult.ok(platformService.getPopularPlatform(dto));
    }
    @ApiOperation("平台名称获取")
    @GetMapping("name/show")
    public BaseResult<List<PlatformNameListVO>> getNameList() {
        return BaseResult.ok(platformService.getNameList());
    }
    @ApiOperation("平台监测展示")
    @GetMapping("supervise/show")
    public BaseResult<PageVO<PlatformSuperviseListVO>> getSuperviseList(@Validated PageDTO dto) {
        return BaseResult.ok(platformService.getSuperviseList(dto));
    }
    @ApiOperation("平台列表展示")
    @GetMapping("list/show")
    public BaseResult<PageVO<PlatformListVO>> getPlatformList(@Validated PageDTO dto) {
        return BaseResult.ok(platformService.getPlatformList(dto));
    }
    @ApiOperation("添加平台")
    @PostMapping("add")
    public BaseResult<Void> addPlatform(@Validated AddPlatformDTO dto) {
        platformService.addPlatform(dto);
        return BaseResult.ok();
    }
    @ApiOperation("修改监管状态")
    @PutMapping("modify/supervise")
    public BaseResult<Void> modifySupervise(@Validated ModifySuperviseDTO dto) {
        platformService.modifySupervise(dto);
        return BaseResult.ok();
    }
    @ApiOperation("修改平台信息")
    @PutMapping("modify/platform")
    public BaseResult<Void> modifyPlatform(@Validated ModifyPlatformDTO dto) {
        platformService.modifyPlatform(dto);
        return BaseResult.ok();
    }
}
