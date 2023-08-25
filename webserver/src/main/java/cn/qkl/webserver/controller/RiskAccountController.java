package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.riskaccount.AccountInfoListQueryDTO;
import cn.qkl.webserver.dto.riskaccount.AccountNumDTO;
import cn.qkl.webserver.dto.riskaccount.NetworkAccountQueryDTO;
import cn.qkl.webserver.service.RiskAccountService;
import cn.qkl.webserver.vo.account.AccountBasicVO;
import cn.qkl.webserver.vo.riskAccount.AccountInfoVO;
import cn.qkl.webserver.vo.riskAccount.AccountNumVO;
import cn.qkl.webserver.vo.riskAccount.NetworkAccountAnalysisVO;
import cn.qkl.webserver.vo.riskAccount.NetworkAccountPanelVO;
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
    RiskAccountService riskAccountService;

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

    @ApiOperation("账户网状分析的账户查询")
    @GetMapping("riskaccount/network/list")
    public BaseResult<List<AccountBasicVO>> getNetworkAccountList(@Validated NetworkAccountQueryDTO dto) {
        return BaseResult.ok(riskAccountService.getNetworkAccount(dto));
    }

    @ApiOperation("账户网状分析画布界面")
    @GetMapping("riskaccount/network/panel")
    public BaseResult<NetworkAccountPanelVO> getNetworkAccountPanel(Long accountId) {
        return BaseResult.ok(riskAccountService.getNetworkAccountPanel(accountId));
    }

    @ApiOperation("账户网状分析-点击账户-左侧栏分析账户信息")
    @GetMapping("riskaccount/network/analysis")
    public BaseResult<NetworkAccountAnalysisVO> getNetworkAccountAnalysis(Long accountId) {
        return BaseResult.ok(riskAccountService.getNetworkAccountAnalysis(accountId));
    }
}
