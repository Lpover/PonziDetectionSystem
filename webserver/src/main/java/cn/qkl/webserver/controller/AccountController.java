package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.dto.account.AccountContentQueryDTO;
import cn.qkl.webserver.dto.account.AccountTxHistoryQueryDTO;
import cn.qkl.webserver.service.AccountService;
import cn.qkl.webserver.vo.account.AccountBasicVO;
import cn.qkl.webserver.vo.account.AccountCheckHistoryVO;
import cn.qkl.webserver.vo.account.AccountContentVO;
import cn.qkl.webserver.vo.account.AccountTxHistoryVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/5/18 16:21
 **/
@RestController
@Slf4j
@Validated
@Api(value = "账户相关接口", tags = {"账户相关接口"})
@ApiSupport(author = "xn")
@RequestMapping("account")
@RefreshScope
@Role
public class AccountController {

    @Resource
    AccountService accountService;

    @ApiOperation("账户基本信息")
    @GetMapping("info")
    public BaseResult<List<AccountBasicVO>> getAccountBasic(@Validated @RequestParam long accountId) {
        return BaseResult.ok(accountService.getAccountBasic(accountId));
    }

    @ApiOperation("账户检测记录")
    @GetMapping("check/history")
    public BaseResult<List<AccountCheckHistoryVO>> getAccountCheckHistory(@Validated @RequestParam long accountId, @RequestParam(required = false,defaultValue = "20") @Validated @Range(min = 1, max = 20) long num) {
        return BaseResult.ok(accountService.getAccountCheckHistory(accountId,num));
    }

    @ApiOperation("账户关联的链上交易记录")
    @GetMapping("tx")
    public BaseResult<PageVO<AccountTxHistoryVO>> getAccountTxHistory(@Validated AccountTxHistoryQueryDTO dto) {
        return BaseResult.ok(accountService.getAccountTxHistory(dto));
    }

    @ApiOperation("账户 关联/发布 的数字内容")
    @GetMapping("content")
    public BaseResult<PageVO<AccountContentVO>> getAccountContent(@Validated AccountContentQueryDTO dto) throws SQLException {
        return BaseResult.ok(accountService.getAccountContent(dto));
    }
}
