package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.riskaccount.*;
import cn.qkl.webserver.service.RiskAccountService;
import cn.qkl.webserver.vo.riskAccount.*;
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
 * @Author lu
 * @Date: 2022/7/23 21:31
 * @wiki
 */
@RestController
@Slf4j
@Validated
@Api(value = "风险账户相关接口", tags = {"风险账户相关接口"})
@ApiSupport(author = "lpc")
@RequestMapping("riskaccount")
@RefreshScope
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
public class RiskAccountController {

    //    @LoadBalanced
    @Autowired
    RiskAccountService riskAccountService;//风险账户



    @ApiOperation("获取分页列表信息")
    @GetMapping("riskaccount/info")
    public BaseResult<PageVO<AccountInfoVO>> getAccountInfo(@Validated AccountInfoListQueryDTO dto) {
        return BaseResult.ok(riskAccountService.getAccountInfoList(dto));
    }//获得报表信息
    @ApiOperation("高中低风险账户信息")
    @GetMapping("riskaccount/accountnum")
    public BaseResult<AccountNumVO> accountNum(@Validated AccountNumDTO dto) {
        return BaseResult.ok(riskAccountService.getAccountNum(dto));
    }

    @ApiOperation("智能查找目标地址")
    @GetMapping("smartaddressfind")
    public BaseResult<List<SmartAddressFindVO>>  smartAddressFind(@Validated SmartAddressFindDTO dto) {
        return BaseResult.ok(riskAccountService.getSmartAddress(dto));
    }

    @ApiOperation("网状分析添加备注")
    @PostMapping("addnote")
    public BaseResult<Void> addNote(@RequestBody @Validated AddNoteDTO dto) {
        riskAccountService.changeAddNote(dto);
        return BaseResult.ok();
    }

    @ApiOperation("交易导出按钮")
    @PostMapping("transactionexport")
    public BaseResult<Void> transactionExport(@Validated TransactionExportDTO dto) {
        return BaseResult.ok();
    }
    @ApiOperation("导出任务显示")
    @GetMapping("exporttask")
    public BaseResult<List<exportTaskVO>> exportTask(@Validated exportTaskDTO dto) {
        return BaseResult.ok(riskAccountService.getExportTask(dto));
    }

    @ApiOperation("地址全部交易详情")
    @GetMapping("transactiondetail")
    public BaseResult<List<TransactionDetailVO>> transactionDetail(@Validated TransactionDetailDTO dto) {
        return BaseResult.ok(riskAccountService.getTransactionDetail(dto));
    }

    @ApiOperation("地址全部交易备注")
    @PostMapping("detailnote")
    public BaseResult<Void> detailNote(@RequestBody @Validated DetailNoteDTO dto) {
        riskAccountService.changeDetailNote(dto);
        return BaseResult.ok();
    }

}
