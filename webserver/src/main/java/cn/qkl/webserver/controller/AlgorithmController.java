package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.algorithm.AlgorithmListQueryDTO;
import cn.qkl.webserver.service.AlgorithmService;
import cn.qkl.webserver.vo.algorithm.AlgorithmVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Role(roles = { RoleEnum.AdminBaseRole.class})
public class AlgorithmController {
    @Autowired
    AlgorithmService algorithmService;

    @ApiOperation("算法列表")
    @GetMapping("list")
    public BaseResult<List<AlgorithmVO>> getAlgorithmList(@Validated AlgorithmListQueryDTO dto) {
        return BaseResult.ok(algorithmService.getAlgorithmList(dto));
    }

}
