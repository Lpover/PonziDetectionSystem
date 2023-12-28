package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.common.log.ApiRecord;
import cn.qkl.webserver.common.log.OperationApiType;
import cn.qkl.webserver.dto.concern.AddConcernDTO;
import cn.qkl.webserver.dto.concern.ConcernListDTO;
import cn.qkl.webserver.service.ConcernService;
import cn.qkl.webserver.vo.concern.ConcernListVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@Validated
@Api(value = "我的关注相关接口", tags = {"我的关注相关接口"})
@ApiSupport(author = "lpc")
@RequestMapping("concern")
@RefreshScope
@ApiRecord(apiType = OperationApiType.class)
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
public class ConcernController {

    @Autowired
    ConcernService concernService;

    @ApiOperation("我的关注列表")
    @GetMapping("concernlist")
    public BaseResult<PageVO<ConcernListVO>> getConcernList(@Validated ConcernListDTO dto) {
        return BaseResult.ok(concernService.getConcernList(dto));
    }

    @ApiOperation("添加关注")
    @PostMapping("addconcern")
    public BaseResult<Void> addConcern(@RequestBody @Validated AddConcernDTO dto) {
        concernService.addConcern(dto);
        return BaseResult.ok();
    }

}
