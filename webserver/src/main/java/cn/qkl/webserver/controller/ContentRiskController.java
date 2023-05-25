package cn.qkl.webserver.controller;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.dto.contenrisk.ContentRiskInfoDTO;
import cn.qkl.webserver.service.ContentRiskService;
import cn.qkl.webserver.vo.contentRisk.ContentRiskInfoVO;
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
 * @Author lu
 * @Date: 2022/7/23 21:31
 * @wiki
 */
@RestController
@Slf4j
@Validated
@Api(value = "风险列表相关接口", tags = {"风险列表相关接口"})
@ApiSupport(author = "lpc")
@RequestMapping("contentrisk")
@RefreshScope
@Role
public class ContentRiskController {

//    @LoadBalanced
    @Autowired
    private ContentRiskService contentRiskService;
    @ApiOperation("获取分页列表信息")
    @GetMapping("contentrisk/info")
    public BaseResult<PageVO<ContentRiskInfoVO>> getContentRiskInfo(@Validated ContentRiskInfoDTO dto) {
        return BaseResult.ok(contentRiskService.getContentRiskInfo(dto));
    }//获得报表信息


}
