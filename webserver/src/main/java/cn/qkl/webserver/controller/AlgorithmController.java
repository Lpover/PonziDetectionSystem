package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.common.log.ApiRecord;
import cn.qkl.webserver.common.log.OperationApiType;
import cn.qkl.webserver.dto.algorithm.AlgorithmAddDTO;
import cn.qkl.webserver.dto.algorithm.AlgorithmListQueryDTO;
import cn.qkl.webserver.dto.algorithm.AlgorithmModifyDTO;
import cn.qkl.webserver.dto.algorithm.AlgorithmStateModifyDTO;
import cn.qkl.webserver.service.AlgorithmService;
import cn.qkl.webserver.vo.algorithm.AlgorithmVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value = "算法相关接口", tags = {"算法相关接口"})
@ApiSupport(author = "wx")
@RequestMapping("algorithm")
@RefreshScope
@Role(roles = {RoleEnum.AdminBaseRole.class})
@ApiRecord(apiType = OperationApiType.class)
public class AlgorithmController {
    @Autowired
    AlgorithmService algorithmService;

    @ApiOperation("算法列表")
    @GetMapping("list")
    public BaseResult<List<AlgorithmVO>> getAlgorithmList(@Validated AlgorithmListQueryDTO dto) {
        return BaseResult.ok(algorithmService.getAlgorithmList(dto));
    }

    @ApiOperation("更改使用的算法")
    @PutMapping("state/id")
    public BaseResult<Void> modifyAlgorithmState(@RequestBody @Validated AlgorithmStateModifyDTO dto) {
        algorithmService.modifyAlgorithmState(dto);
        return BaseResult.ok();
    }

    @ApiOperation("添加算法")
    @PostMapping("")
    public BaseResult<Void> addAlgorithm(@RequestBody @Validated AlgorithmAddDTO dto) {
        algorithmService.addAlgorithm(dto);
        return BaseResult.ok();
    }

    @ApiOperation("修改算法")
    @PutMapping("id")
    public BaseResult<Void> modifyAlgorithm(@RequestBody @Validated AlgorithmModifyDTO dto) {
        algorithmService.modifyAlgorithm(dto);
        return BaseResult.ok();
    }


}
