package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.evidence.*;
import cn.qkl.webserver.service.EvidenceDailyStatisticsService;
import cn.qkl.webserver.service.EvidenceService;
import cn.qkl.webserver.vo.evidence.*;
import cn.qkl.webserver.vo.evidence.EvidenceCertVO;
import cn.qkl.webserver.vo.evidence.EvidenceRecordItemVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import freemarker.template.TemplateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;

/**
 * @Author sunxiaen
 * @Date 2023/6/29 17:22
 **/
@RestController
@Slf4j
@Validated
@Api(value = "取证固证相关接口", tags = {"取证固证相关接口"})
@ApiSupport(author = "zz,sxe")
@RequestMapping("evidence")
@RefreshScope
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
public class EvidenceController {

    @Autowired
    EvidenceService evidenceService;

    @Autowired
    EvidenceDailyStatisticsService evidenceDailyStatisticsService;

    @ApiOperation("获取风险类型的列表")
    @GetMapping("risk/type")
    public BaseResult<EvidenceRiskTypeVO> getRiskTypeList() {
        return BaseResult.ok(evidenceService.getRiskTypeList());
    }

    @ApiOperation("查询取证固证状态")
    @GetMapping("phase")
    public BaseResult<EvidencePhaseVO> getPhase(@Validated EvidenceDetailDTO dto) {
        return BaseResult.ok(evidenceService.getEvidencePhase(dto));
    }

    @ApiOperation("网页取证")
    @PutMapping("web")
    public BaseResult<EvidencePhaseVO> webEvidence(@Validated @RequestBody WebEvidenceDTO dto) {
        return BaseResult.ok(evidenceService.webEvidence(dto));
    }

    @ApiOperation("固证")
    @PutMapping("reinforce")
    public BaseResult<EvidencePhaseVO> reinforceEvidence(@Validated @RequestBody ReinforceEvidenceDTO dto) {
        return BaseResult.ok(evidenceService.reinforceEvidence(dto));
    }

    @ApiOperation("取证固证情况统计")
    @GetMapping("statistics")
    public BaseResult<StatisticsEvidenceVO> getEvidenceStatistics(@Validated StatisticsEvidenceDTO dto) {
        return BaseResult.ok(evidenceDailyStatisticsService.getEvidenceStatistics(dto));
    }

    @ApiOperation("证据详情")
    @GetMapping("detail/info")
    public BaseResult<EvidenceDetailVO> getEvidenceDetail(@Validated EvidenceDetailDTO dto) {
        return BaseResult.ok(evidenceService.getEvidenceDetail(dto));
    }

    @ApiOperation("证据包下载")
    @PostMapping("pack/download")
    public BaseResult<Void> downloadEvidencePack(@Validated @RequestBody EvidenceDetailDTO dto, HttpServletResponse response) throws IOException {
        evidenceService.downloadEvidencePack(dto, response);
        return BaseResult.ok();
    }

    @ApiOperation("取证记录列表")
    @GetMapping("/record/list")
    public BaseResult<PageVO<EvidenceRecordItemVO>> getRecordList(EvidenceRecordListDTO dto) {
        return BaseResult.ok(evidenceService.getRecordList(dto));
    }

    @ApiOperation("查看固证文书")
    @GetMapping("/cert")
    public BaseResult<EvidenceCertVO> getEvidenceCert(@Validated @NotNull Long id) throws TemplateException, IOException, ParserConfigurationException, FontFormatException, SAXException {
        return BaseResult.ok(evidenceService.getEvidenceCert(id));
    }

    @ApiOperation("删除取证记录 1删除成功 0删除失败")
    @GetMapping("/record")
    public BaseResult<Void> markDeleteEvidence(@Validated @NotNull Long id) {
        evidenceService.markDeleteEvidence(id);
        return BaseResult.ok();
    }


}
