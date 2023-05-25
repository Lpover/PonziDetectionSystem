package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.service.RiskReportService;
import cn.qkl.webserver.vo.riskReport.RiskReportInfoVO;
import cn.qkl.webserver.dto.riskreport.ExportRiskReportDTO;
import cn.qkl.webserver.dto.riskreport.RiskReportListQueryDTO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @title:
 * @Author lu
 * @Date: 2022/7/23 21:31
 * @wiki
 */
@RestController
@Slf4j
@Validated
@Api(value = "每日报告相关接口", tags = {"每日报告相关接口"})
@ApiSupport(author = "lpc")
@RequestMapping("riskreport")
@RefreshScope
@Role
public class RiskReportController {

//    @LoadBalanced
    @Autowired
        private RiskReportService riskReportService;

    @ApiOperation("获取报表信息")
    @GetMapping("riskreport/info")
    public BaseResult<RiskReportInfoVO> getRiskReportInfo(@Validated RiskReportListQueryDTO dto) {
        return BaseResult.ok(riskReportService.getRiskReportInfo(dto));
    }//获得报表信息
}
