package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.Notification.OpenDTO;
import cn.qkl.webserver.dto.Notification.ReceiveTimeDTO;
import cn.qkl.webserver.dto.Notification.TextPreviewDTO;
import cn.qkl.webserver.dto.threhold.IndexChangeDTO;
import cn.qkl.webserver.dto.threhold.IndexReportDTO;
import cn.qkl.webserver.service.RiskReportService;
import cn.qkl.webserver.vo.Notification.NotificationVO;
import cn.qkl.webserver.vo.Notification.TextPreviewVO;
import cn.qkl.webserver.vo.threshold.IndexChangeVO;
import cn.qkl.webserver.vo.threshold.IndexReportVO;
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

import java.util.Collections;
import java.util.List;

/**
 * @title:
 * @Author lu
 * @Date: 2022/7/23 21:31
 * @wiki
 */
@RestController
@Slf4j
@Validated
@Api(value = "通知接口", tags = {"通知接口"})
@ApiSupport(author = "lpc")
@RequestMapping("notification")
@RefreshScope
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
public class NotificationController {

//    @LoadBalanced
    @Autowired
        private RiskReportService riskReportService;

    @ApiOperation("通知开关")
    @GetMapping("open")
    public BaseResult<NotificationVO> getOpen(OpenDTO dto) {
        return BaseResult.ok(new NotificationVO());
    }//获得报表信息

    @ApiOperation("周末预警")
    @GetMapping("openweek")
    public BaseResult<NotificationVO> getOpenWeek(IndexChangeDTO dto) {
        return BaseResult.ok(new NotificationVO());
    }//获得报表信息

    @ApiOperation("接收时间")
    @GetMapping("Receivetime")
    public BaseResult<NotificationVO> getReceivetime(ReceiveTimeDTO dto) {
        return BaseResult.ok(new NotificationVO());
    }//获得报表信息

    @ApiOperation("文本预览")
    @GetMapping("TextPreview")
    public BaseResult<TextPreviewVO> getTextPreview(TextPreviewDTO dto) {
        return BaseResult.ok(new TextPreviewVO());
    }//获得报表信息
}
