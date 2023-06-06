package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.board.CrossContentRiskViewDTO;
import cn.qkl.webserver.service.CrossContentDailyStatisticsService;
import cn.qkl.webserver.vo.board.CrossContentRiskViewVO;
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

    @ApiOperation("跨链风险视图")
    @GetMapping("cross/view")
    public BaseResult<List<CrossContentRiskViewVO>> getCrossContentRiskView(@Validated CrossContentRiskViewDTO dto) {
        return BaseResult.ok(crossContentDailyStatisticsService.getCrossContentRiskView(dto));
    }

}
