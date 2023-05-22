package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.dto.detail.*;
import cn.qkl.webserver.service.DetailService;
import cn.qkl.webserver.vo.detail.ContentDynamicMonitorVO;
import cn.qkl.webserver.vo.detail.ContentHistoryVO;
import cn.qkl.webserver.vo.detail.ContentInfoVO;
import cn.qkl.webserver.vo.detail.ContentRiskReviseVO;
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
 * @Author zouzh
 * @Date: 2023/5/18 10:30
 * @wiki
 */
@RestController
@Slf4j
@Validated
@Api(value = "数字内容详情页相关接口", tags = {"数字内容详情页相关接口"})
@ApiSupport(author = "zz")
@RequestMapping("detail")
@RefreshScope
@Role
public class DetailedContentController {
    @Autowired
    DetailService detailService;

    @ApiOperation("数字内容详情信息展示")
    @GetMapping("content/info")
    public BaseResult<ContentInfoVO> getInfo(@Validated ContentInfoDTO dto) {
        return BaseResult.ok(detailService.getContentInfo(dto));
    }

    @ApiOperation("数字内容交易记录展示")
    @GetMapping("content/history")
    public BaseResult<PageVO<ContentHistoryVO>> getTxHistory(@Validated ContentHistoryDTO dto) {
        return BaseResult.ok(detailService.getContentTxHistory(dto));
    }

    @ApiOperation("数字内容风险人工修订信息展示")
    @GetMapping("content/revise/info")
    public  BaseResult<ContentRiskReviseVO> getRiskReviseInfo(@Validated ContentRiskReviseInfoDTO dto) {
        return BaseResult.ok(detailService.getReviseRiskInfo(dto));
    }

    @ApiOperation("数字内容风险人工修订")
    @PutMapping("content/revise")
    public BaseResult<Void> riskRevise(@Validated @RequestBody ContentRiskReviseDTO dto) {
        detailService.manualReviseRisk(dto);
        return BaseResult.ok();
    }

    @ApiOperation("动态风险数字内容监测历史")
    @GetMapping("content/dynamic/monitor")
    public BaseResult<PageVO<ContentDynamicMonitorVO>> getDynamicMonitor(@Validated ContentDynamicMonitorDTO dto) {
        return BaseResult.ok(detailService.getDynamicMonitor(dto));
    }

}
