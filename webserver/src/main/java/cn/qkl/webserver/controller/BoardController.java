package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.board.CrossContentRiskViewDTO;
import cn.qkl.webserver.dto.platformview.HotnessRankingViewDTO;
import cn.qkl.webserver.dto.platformview.PlatformAndTimeSelectionDTO;
import cn.qkl.webserver.dto.platformview.PlatformSelectionDTO;
import cn.qkl.webserver.service.CrossContentDailyStatisticsService;
import cn.qkl.webserver.service.PlatformViewService;
import cn.qkl.webserver.vo.board.CrossContentRiskViewVO;
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
@Api(value = "驾驶舱相关接口", tags = {"驾驶舱相关接口"})
@ApiSupport(author = "wx")
@RequestMapping("board")
@RefreshScope
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
public class BoardController {

    @Autowired
    private CrossContentDailyStatisticsService crossContentDailyStatisticsService;
    @Autowired
    private PlatformViewService platformViewService;

    @ApiOperation("跨链风险视图")
    @GetMapping("cross/view")
    public BaseResult<List<CrossContentRiskViewVO>> getCrossContentRiskView(@Validated CrossContentRiskViewDTO dto) {
        return BaseResult.ok(crossContentDailyStatisticsService.getCrossContentRiskView(dto));
    }

    //平台风险内容数量变化趋势视图
    @ApiOperation("平台风险内容数量变化趋势视图")
    @GetMapping("volumetrends")
    public BaseResult<List<VolumeTrendsVO>> getVolumeTrends(@Validated PlatformAndTimeSelectionDTO dto) {
        return BaseResult.ok(platformViewService.getVolumeTrends(dto));
    }

    //平台风险指数变化趋势视图
    @ApiOperation("平台风险指数变化趋势视图")
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
