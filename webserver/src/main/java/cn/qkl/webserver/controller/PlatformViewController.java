package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.dto.platformview.HotnessRankingViewDTO;
import cn.qkl.webserver.dto.platformview.PlatformAndTimeSelectionDTO;
import cn.qkl.webserver.dto.platformview.PlatformSelectionDTO;
import cn.qkl.webserver.service.PlatformViewService;
import cn.qkl.webserver.vo.platformview.*;
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

/**
 * @title:
 * @Author lu
 * @Date: 2022/7/23 21:31
 * @wiki
 */
@RestController
@Slf4j
@Validated
@Api(value = "平台风险驾驶舱相关接口", tags = {"平台风险驾驶舱相关接口"})
@ApiSupport(author = "lpc")
@RequestMapping("platformcockpit")
@RefreshScope
@Role
public class PlatformViewController {

    //    @LoadBalanced
    @Autowired
    PlatformViewService platformViewService;

    //平台风险内容数量变化趋势视图
    @ApiOperation("风险内容数量变化趋势视图")
    @GetMapping("volumetrends")
    public BaseResult<VolumeTrendsVO> getVolumeTrends(@Validated PlatformAndTimeSelectionDTO dto) {
        return BaseResult.ok(new VolumeTrendsVO());
    }

    //平台风险指数变化趋势视图
    @ApiOperation("风险指数变化趋势视图")
    @GetMapping("indextrends")
    public BaseResult<IndexTrendsVO> getIndexTrends(@Validated PlatformAndTimeSelectionDTO dto) {
        return BaseResult.ok(new IndexTrendsVO());
    }

    //平台风险账户top10视图
    @ApiOperation("平台风险账户top10视图")
    @GetMapping("riskaccount")
    public BaseResult<PlatformRiskAccountVO> getRiskAccount(@Validated PlatformSelectionDTO dto) {
        return BaseResult.ok(new PlatformRiskAccountVO());
    }

    //平台风险内容top10视图
    @ApiOperation("平台风险内容top10视图")
    @GetMapping("riskcontent")
    public BaseResult<PlatformRiskContentVO> getRiskContent(@Validated PlatformSelectionDTO dto) {
        return BaseResult.ok(new PlatformRiskContentVO());
    }

    //NFT、WEB3热度排行视图
    @ApiOperation("NFT、WEB3热度排行视图")
    @GetMapping("hotnessrankingview")
    public BaseResult<HotnessRankingViewVO> getHotnessRankingView(@Validated HotnessRankingViewDTO dto) {
        return BaseResult.ok(new HotnessRankingViewVO());
    }

}