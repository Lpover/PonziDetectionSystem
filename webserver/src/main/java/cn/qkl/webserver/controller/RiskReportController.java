package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.common.log.ApiRecord;
import cn.qkl.webserver.common.log.OperationApiType;
import cn.qkl.webserver.dto.riskreport.SituationReportDTO;
import cn.qkl.webserver.service.RiskReportService;
import cn.qkl.webserver.vo.riskReport.RiskReportInfoVO;
import cn.qkl.webserver.dto.riskreport.ExportRiskReportDTO;
import cn.qkl.webserver.dto.riskreport.RiskReportListQueryDTO;
import cn.qkl.webserver.vo.riskReport.SituationInfoVO;
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
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
@ApiRecord(apiType = OperationApiType.class)
public class RiskReportController {

//    @LoadBalanced
    @Autowired
        private RiskReportService riskReportService;

    @ApiOperation("获取报表信息")
    @GetMapping("riskreport/info")
    public BaseResult<RiskReportInfoVO> getRiskReportInfo(@Validated RiskReportListQueryDTO dto) {
        return BaseResult.ok(riskReportService.getRiskReportInfo(dto));
    }//获得报表信息

    @ApiOperation("态势感知驾驶舱每日报告")
    @GetMapping("situationreport")
    public BaseResult<SituationInfoVO> getSituationInfo(@Validated SituationReportDTO dto) {
        return BaseResult.ok(riskReportService.getSituationInfo(dto));
    }//获得报表信息
}
