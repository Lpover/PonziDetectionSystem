package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.common.log.ApiRecord;
import cn.qkl.webserver.common.log.OperationApiType;
import cn.qkl.webserver.dto.board.CockpitIntegratedQueryDTO;
import cn.qkl.webserver.dto.board.CrossContentRiskViewDTO;
import cn.qkl.webserver.dto.board.CrossContentTxDTO;
import cn.qkl.webserver.dto.board.TimePlatformSelecteDTO;
import cn.qkl.webserver.dto.carrier.CarrierViewDTO;
import cn.qkl.webserver.dto.category.CategoryViewDTO;
import cn.qkl.webserver.dto.platformview.HotnessRankingViewDTO;
import cn.qkl.webserver.dto.platformview.PlatformAndTimeSelectionDTO;
import cn.qkl.webserver.dto.platformview.PlatformSelectionDTO;
import cn.qkl.webserver.dto.stroage.StorageViewDTO;
import cn.qkl.webserver.service.*;
import cn.qkl.webserver.vo.board.*;
import cn.qkl.webserver.vo.carrier.CarrierViewVO;
import cn.qkl.webserver.vo.category.CategoryViewVO;
import cn.qkl.webserver.vo.cockpit.integrated.CockpitIntegratedMultipleChoiceVO;
import cn.qkl.webserver.vo.cockpit.integrated.CockpitIntegratedResponseVO;
import cn.qkl.webserver.vo.platform.PlatformNameListVO;
import cn.qkl.webserver.vo.platformview.*;
import cn.qkl.webserver.vo.stroage.StorageViewVO;
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
@Api(value = "驾驶舱相关接口", tags = {"驾驶舱相关接口"})
@ApiSupport(author = "wx")
@RequestMapping("board")
@RefreshScope
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
@ApiRecord(apiType = OperationApiType.class)
public class BoardController {

    @Autowired
    private CrossContentDailyStatisticsService crossContentDailyStatisticsService;

    @Autowired
    private PlatformViewService platformViewService;

    @Autowired
    private CarrierViewService carrierViewService;

    @Autowired
    private StorageViewService storageViewService;

    @Autowired
    private CategoryViewService categoryViewService;

    @Autowired
    private CockpitIntegratedService cockpitIntegratedService;

    @Autowired
    private RiskTxViewService riskTxViewService;

    @Autowired
    private RiskNumViewService riskNumViewService;

    @Autowired
    private WordCloudViewService wordCloudViewService;

    @Autowired
    private PlatformService platformService;

    @ApiOperation("跨链风险视图")
    @GetMapping("cross/view")
    public BaseResult<List<CrossContentRiskViewVO>> getCrossContentRiskView(@Validated CrossContentRiskViewDTO dto) {
        return BaseResult.ok(crossContentDailyStatisticsService.getCrossContentRiskView(dto));
    }

    @ApiOperation("跨链交易数量变化趋势视图")
    @GetMapping("cross/tx/view")
    public BaseResult<CrossContentTxViewVO> getCrossContentTxView(@Validated CrossContentTxDTO dto) {
        return BaseResult.ok(crossContentDailyStatisticsService.getCrossContentTxView(dto));
    }

    @ApiOperation("存储视图")
    @GetMapping("storage/view")
    public BaseResult<StorageViewVO> getStorageView(@Validated StorageViewDTO dto) {
        return BaseResult.ok(storageViewService.getStorageView(dto));
    }


    @ApiOperation("载体视图")
    @GetMapping("carrier/view")
    public BaseResult<CarrierViewVO> getCarrierView(@Validated CarrierViewDTO dto) {
        return BaseResult.ok(carrierViewService.getCarrierView(dto));
    }

    @ApiOperation("动态数字内容视图")
    @GetMapping("category/view")
    public BaseResult<CategoryViewVO> getCategoryView(@Validated CategoryViewDTO dto) {
        return BaseResult.ok(categoryViewService.getCategoryView(dto));
    }

    @ApiOperation("综合风险驾驶舱首屏接口")
    @PostMapping("/cockpit/integrated/all")
    public BaseResult<CockpitIntegratedResponseVO> getCockpitIntegratedResponseAll(@RequestBody(required = false) CockpitIntegratedQueryDTO dto) {
        // no check for inputs
        return BaseResult.ok(cockpitIntegratedService.getCockpitIntegratedResponseAll());
    }


    @ApiOperation("综合风险驾驶舱动态接口")
    @PostMapping("/cockpit/integrated/dynamic")
    public BaseResult<CockpitIntegratedResponseVO> getCockpitIntegratedResponseDynamic(@RequestBody(required = true) CockpitIntegratedQueryDTO dto) {
        return BaseResult.ok(cockpitIntegratedService.getCockpitIntegratedResponseDynamic(dto));
    }

    @ApiOperation("综合风险驾驶舱查看可筛选项接口")
    @GetMapping("/cockpit/integrated/choice")
    public BaseResult<CockpitIntegratedMultipleChoiceVO> getCockpitIntegratedMultipleChoice() {
        return BaseResult.ok(cockpitIntegratedService.getCockpitIntegratedMultipleChoice());
    }

    @ApiOperation("获取正在监测中的平台列表")
    @GetMapping("monitoring/platform")
    public BaseResult<List<PlatformNameListVO>> getMonitoringPlatform() {
        return BaseResult.ok(platformService.getMonitoringPlatform());
    }

    @ApiOperation("风险交易视图")
    @GetMapping("risk/tx")
    public BaseResult<RiskTxViewVO> getRiskTxView(@Validated TimePlatformSelecteDTO dto) {
        return BaseResult.ok(riskTxViewService.getRiskTxView(dto));
    }

    @ApiOperation("风险类别词云分布视图")
    @GetMapping("risk/cloud")
    public BaseResult<List<WordCloudViewVO>> getWordCloudView(@Validated TimePlatformSelecteDTO dto) {
        return BaseResult.ok(wordCloudViewService.getWordCloudView(dto));
    }

    @ApiOperation("风险数量变化趋势图")
    @GetMapping("risk/num")
    public BaseResult<RiskNumViewVO> getRiskNumView(@Validated TimePlatformSelecteDTO dto) {
        return BaseResult.ok(riskNumViewService.getRiskNumView(dto));
    }

    //平台风险内容数量变化趋势视图
    @ApiOperation("平台风险内容数量变化趋势视图")
    @GetMapping("volumetrends")
    public BaseResult<VolumeTrendsVO> getVolumeTrends(@Validated PlatformAndTimeSelectionDTO dto) {
        return BaseResult.ok(platformViewService.getVolumeTrends(dto));
    }

    //平台风险指数变化趋势视图
    @ApiOperation("平台风险指数变化趋势视图")
    @GetMapping("indextrends")
    public BaseResult<IndexTrendsVO> getIndexTrends(@Validated PlatformAndTimeSelectionDTO dto) {
        return BaseResult.ok(platformViewService.getIndexTrends(dto));
    }

    //平台风险账户top10视图
    @ApiOperation("平台风险账户top10视图")
    @GetMapping("riskaccount")
    public BaseResult<List<PlatformRiskAccountVO>> getRiskAccount(@Validated PlatformSelectionDTO dto) {
        return BaseResult.ok(platformViewService.getPlatformRiskAccount(dto));
    }

    //平台风险内容top10视图
    @ApiOperation("平台风险内容top10视图")
    @GetMapping("riskcontent")
    public BaseResult<List<PlatformRiskContentVO>> getRiskContent(@Validated PlatformSelectionDTO dto) {
        return BaseResult.ok(platformViewService.getPlatformRiskContent(dto));
    }

    //NFT、WEB3热度排行视图
    @ApiOperation("NFT、WEB3热度排行视图")
    @GetMapping("hotnessrankingview")
    public BaseResult<PageVO<HotnessRankingViewVO>> getHotnessRankingView(@Validated HotnessRankingViewDTO dto) {
        return BaseResult.ok(platformViewService.getHotnessRankingView(dto));
    }


}
