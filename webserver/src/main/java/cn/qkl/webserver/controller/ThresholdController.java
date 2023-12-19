package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.common.log.ApiRecord;
import cn.qkl.webserver.common.log.OperationApiType;
import cn.qkl.webserver.dto.riskreport.RiskReportListQueryDTO;
import cn.qkl.webserver.dto.riskreport.SituationReportDTO;
import cn.qkl.webserver.dto.threhold.IndexChangeDTO;
import cn.qkl.webserver.dto.threhold.IndexReportDTO;
import cn.qkl.webserver.service.RiskReportService;
import cn.qkl.webserver.service.ThresholdService;
import cn.qkl.webserver.vo.riskReport.RiskReportInfoVO;
import cn.qkl.webserver.vo.riskReport.SituationInfoVO;
import cn.qkl.webserver.vo.threshold.IndexChangeVO;
import cn.qkl.webserver.vo.threshold.IndexReportVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "多维度阈值接口", tags = {"多维度阈值接口"})
@ApiSupport(author = "lpc")
@RequestMapping("threshold")
@RefreshScope
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
@ApiRecord(apiType = OperationApiType.class)
public class ThresholdController {

//    @LoadBalanced
    @Autowired
        private ThresholdService thresholdService;

    @ApiOperation("多维度指数")
    @GetMapping("indexreport")
    public BaseResult<List<IndexReportVO>> getIndexReport(@Validated IndexReportDTO dto) {
        return BaseResult.ok(thresholdService.getIndexReport(dto));
    }//多维度指数

    @ApiOperation("修改阈值")
    @PostMapping("indexchange")
    public BaseResult<Void> getIndexChange(@RequestBody @Validated IndexChangeDTO dto) {
        thresholdService.indexChange(dto);
        return BaseResult.ok();
    }//修改阈值

}
