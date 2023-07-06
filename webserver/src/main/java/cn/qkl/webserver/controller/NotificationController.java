package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.noticification.*;
import cn.qkl.webserver.dto.threhold.IndexChangeDTO;
import cn.qkl.webserver.service.RiskReportService;
import cn.qkl.webserver.vo.notification.TextPreviewVO;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.service.NotificationService;
import cn.qkl.webserver.vo.notification.CurrentStatusVO;
import cn.qkl.webserver.vo.notification.NotificationItemVO;
import cn.qkl.webserver.vo.notification.NotificationNumbersVO;
import cn.qkl.webserver.vo.notification.NotificationRecordVO;
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
 * @Author sunxiaen
 * @Date 2023/7/3 11:50
 **/

@RestController
@Slf4j
@Validated
@Api(value = "通知相关接口", tags = {"通知相关接口"})
@ApiSupport(author = "sxe")
@RequestMapping("notification")
@RefreshScope
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @ApiOperation("累计通知次数")
    @GetMapping("/sum")
    public BaseResult<NotificationNumbersVO> getNotificationNumbers() {
        return BaseResult.ok(notificationService.getNotificationNumbers());
    }

    @ApiOperation("获取通知项")
    @GetMapping("/list")
    public BaseResult<List<NotificationItemVO>> getNotificationItems() {
        return BaseResult.ok(notificationService.getNotificationItems());
    }

    @ApiOperation("提交通知项选择 注意 只会返回 data: 一个数字 表示成功")
    @PostMapping("/choice")
    public BaseResult<Integer> chooseNotificationItem(@RequestBody ChooseNotificationDTO dto) {
        return BaseResult.ok(notificationService.chooseNotificationItem(dto));
    }

    @ApiOperation("通知记录 分页")
    @GetMapping("record")
    public BaseResult<PageVO<NotificationRecordVO>> getNotificationRecord(NotificationRecordDTO dto) {
        return BaseResult.ok(notificationService.getNotificationRecord(dto));
    }


    @ApiOperation("当前通知状态获取")
    @GetMapping("currentstatus")
    public BaseResult<CurrentStatusVO> getCurrentStatus() {
        return BaseResult.ok(notificationService.getCurrentStatus());
    }//当前通知状态获取

    @ApiOperation("通知开关")
    @PutMapping("open")
    public void getOpen(@Validated OpenDTO dto) {
        notificationService.openChange(dto);
    }//通知开关修改

    @ApiOperation("周末预警")
    @PutMapping("openweek")
    public void getOpenWeek(@Validated OpenWeekDTO dto) {
        notificationService.openWeekChange(dto);
    }//周末预警修改

    @ApiOperation("接收时间")
    @PutMapping("receivetime")
    public void getReceivetime(@Validated ReceiveTimeDTO dto) {
        notificationService.receivetimeChange(dto);
    }//接收时间修改

    @ApiOperation("文本预览")
    @GetMapping("textpreview")
    public BaseResult<List<TextPreviewVO>> getTextPreview() {
        return BaseResult.ok(notificationService.getTextPreview());
    }//文本预览
}
