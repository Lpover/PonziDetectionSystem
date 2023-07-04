package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.riskreport.RiskReportListQueryDTO;
import cn.qkl.webserver.dto.riskreport.SituationReportDTO;
import cn.qkl.webserver.dto.threhold.IndexChangeDTO;
import cn.qkl.webserver.dto.threhold.IndexReportDTO;
import cn.qkl.webserver.service.RiskReportService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@Api(value = "多维度阈值接口", tags = {"多维度阈值接口"})
@ApiSupport(author = "lpc")
@RequestMapping("threshold")
@RefreshScope
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
public class ThresholdController {

//    @LoadBalanced
    @Autowired
        private RiskReportService riskReportService;

    @ApiOperation("多维度指数")
    @GetMapping("indexreport")
    public BaseResult<List<IndexReportVO>> getIndexReport(@Validated IndexReportDTO dto) {
        return BaseResult.ok(Collections.singletonList(new IndexReportVO()));
    }//获得报表信息

    @ApiOperation("修改阈值")
    @PutMapping("indexchange")
    public BaseResult<IndexChangeVO> getIndexChange(@Validated IndexChangeDTO dto) {
        return BaseResult.ok(new IndexChangeVO());
    }//获得报表信息

}
