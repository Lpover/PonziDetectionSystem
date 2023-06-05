package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.dto.riskaccount.AccountInfoListQueryDTO;
import cn.qkl.webserver.dto.riskaccount.AccountNumDTO;
import cn.qkl.webserver.service.RiskAccountService;
import cn.qkl.webserver.vo.riskAccount.AccountInfoVO;
import cn.qkl.webserver.vo.riskAccount.AccountNumVO;
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
public class PlatformCockpitController {

    //    @LoadBalanced
    @Autowired
    RiskAccountService riskAccountService;

    @ApiOperation("风险内容数量变化趋势视图")
    @GetMapping("volumetrends")
    public BaseResult<AccountInfoVO> getVolumeTrends(@Validated AccountInfoListQueryDTO dto) {
        return BaseResult.ok(riskAccountService.getAccountInfoList(dto));
    }//获得报表信息
    @ApiOperation("高中低风险账户信息")
    @GetMapping("riskaccount/accountnum")
    public BaseResult<AccountNumVO> accountNum(@Validated AccountNumDTO dto) {
        return BaseResult.ok(riskAccountService.getAccountNum(dto));
    }

}
