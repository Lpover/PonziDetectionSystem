package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.vo.platform.PlatformContentVO;
import cn.qkl.webserver.vo.riskcontentstatistics.RiskContentStatisticsVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Validated
@Api(value = "风险类别走势相关接口", tags = {"风险类别走势相关接口"})
@ApiSupport(author = "ly")
@RequestMapping("trend")
@RefreshScope
@Role
public class RiskCategoryTrendController {
    @ApiOperation("查询风险类别走势")
    @GetMapping("riskCategory")
    public BaseResult<RiskContentStatisticsVO> getRiskCategoryTrend() {
        return BaseResult.ok(new RiskContentStatisticsVO());}
}
