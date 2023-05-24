package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.service.ChainService;
import cn.qkl.webserver.vo.chain.ChainVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author sunxiaen
 * @Date 15:12 2023/5/18
 **/
@RestController
@Slf4j
@Validated
@Api(value = "区块链相关接口", tags = {"区块链相关接口"})
@ApiSupport(author = "xn")
@RequestMapping("chain")
@RefreshScope
@Role
public class ChainController {

    @Resource
    ChainService chainService;

    @ApiOperation("区块链列表")
    @GetMapping("list")
    public BaseResult<List<ChainVO>> getChainList() {
        return BaseResult.ok(chainService.getChainList());
    }

}
