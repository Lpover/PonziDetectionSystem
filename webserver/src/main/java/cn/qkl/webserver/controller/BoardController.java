package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.board.CrossContentRiskViewDTO;
import cn.qkl.webserver.dto.board.TimePlatformSelecteDTO;
import cn.qkl.webserver.dto.carrier.CarrierViewDTO;
import cn.qkl.webserver.dto.category.CategoryViewDTO;
import cn.qkl.webserver.dto.stroage.StorageViewDTO;
import cn.qkl.webserver.service.*;
import cn.qkl.webserver.vo.board.CrossContentRiskViewVO;
import cn.qkl.webserver.vo.board.RiskNumVO;
import cn.qkl.webserver.vo.board.RiskTxViewVO;
import cn.qkl.webserver.vo.board.WordCloudVO;
import cn.qkl.webserver.vo.carrier.CarrierViewVO;
import cn.qkl.webserver.vo.category.CategoryViewVO;
import cn.qkl.webserver.vo.stroage.StorageViewVO;
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

import java.util.ArrayList;
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
    private CarrierViewService carrierViewService;

    @Autowired
    private StorageViewService storageViewService;

    @Autowired
    private CategoryViewService categoryViewService;

    @Autowired
    private RiskTxViewService riskTxViewService;
    @ApiOperation("跨链风险视图")
    @GetMapping("cross/view")
    public BaseResult<List<CrossContentRiskViewVO>> getCrossContentRiskView(@Validated CrossContentRiskViewDTO dto) {
        return BaseResult.ok(crossContentDailyStatisticsService.getCrossContentRiskView(dto));
    }

    @ApiOperation("存储视图")
    @GetMapping("stroage/view")
    public BaseResult<List<StorageViewVO>> getStorageView(@Validated StorageViewDTO dto) {
        return BaseResult.ok(storageViewService.getStorageView(dto));
    }


    @ApiOperation("载体视图")
    @GetMapping("carrier/view")
    public BaseResult<List<CarrierViewVO>> getCarrierView(@Validated CarrierViewDTO dto) {
        return BaseResult.ok(carrierViewService.getCarrierView(dto));
    }

    @ApiOperation("动态数字内容视图")
    @GetMapping("category/view")
    public BaseResult<List<CategoryViewVO>> getCategoryView(@Validated CategoryViewDTO dto) {
        return BaseResult.ok(categoryViewService.getCategoryView(dto));
    }

    @ApiOperation("风险交易视图")
    @GetMapping("risk/tx")
    public BaseResult<RiskTxViewVO> getRiskTxView(@Validated TimePlatformSelecteDTO dto) {
        return BaseResult.ok(riskTxViewService.getRiskTxView(dto));
    }

    @ApiOperation("风险类别词云分布视图")
    @GetMapping("risk/cloud")
    public BaseResult<List<WordCloudVO>> getWordCloudView(@Validated TimePlatformSelecteDTO dto) {
        return BaseResult.ok(new ArrayList<>());
    }

    @ApiOperation("风险变化趋势图")
    @GetMapping("risk/num")
    public BaseResult<List<RiskNumVO>> getRiskNumView(@Validated TimePlatformSelecteDTO dto) {
        return BaseResult.ok(new ArrayList<>());
    }
}
