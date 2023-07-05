package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.evidence.EvidenceRecordListDTO;
import cn.qkl.webserver.service.EvidenceService;
import cn.qkl.webserver.vo.evidence.EvidenceRecordItemVO;
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
import cn.qkl.webserver.dto.evidence.*;
import cn.qkl.webserver.dto.evidence.EvidenceRecordListDTO;
import cn.qkl.webserver.vo.evidence.*;
import cn.qkl.webserver.vo.evidence.EvidenceRecordItemVO;
import freemarker.template.TemplateException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.validation.constraints.NotNull;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
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

    @ApiOperation("获取风险类型的列表")
    @GetMapping("risk/type")
    public BaseResult<EvidenceRiskTypeVO> getRiskTypeList() {
        return BaseResult.ok(new EvidenceRiskTypeVO());
    }

    @ApiOperation("网页取证")
    @PutMapping("web")
    public BaseResult<EvidencePhaseVO> webEvidence(@Validated @RequestBody WebEvidenceDTO dto) throws IOException, URISyntaxException, AWTException {
        return BaseResult.ok(evidenceService.webEvidence(dto));
    }

    @ApiOperation("固证")
    @PutMapping("reinforce")
    public BaseResult<EvidencePhaseVO> reinforceEvidence(@Validated @RequestBody ReinforceEvidenceDTO dto) throws IOException {
        return BaseResult.ok(evidenceService.reinforceEvidence(dto));
    }

    @ApiOperation("取证固证情况统计")
    @GetMapping("statistics")
    public BaseResult<StatisticsEvidenceVO> getEvidenceStatistics(@Validated StatisticsEvidenceDTO dto) {
        return BaseResult.ok(new StatisticsEvidenceVO());
    }

    @ApiOperation("证据详情")
    @GetMapping("detail/info")
    public BaseResult<EvidenceDetailVO> getEvidenceDetail(@Validated EvidenceDetailDTO dto) {
        return BaseResult.ok(evidenceService.getEvidenceDetail(dto));
    }

    @ApiOperation("证据包下载")
    @PostMapping("pack/download")
    public BaseResult<Void> downloadEvidencePack(@Validated @RequestBody EvidenceDetailDTO dto) {
        return BaseResult.ok();
    }

    @ApiOperation("取证记录列表")
    @GetMapping("/record/list")
    public BaseResult<PageVO<EvidenceRecordItemVO>> getRecordList(EvidenceRecordListDTO dto) {
        return BaseResult.ok(evidenceService.getRecordList(dto));
    }

    @ApiOperation("查看固证文书")
    @GetMapping("/cert")
    public BaseResult<String> getEvidenceCert(@Validated @NotNull Long id) throws TemplateException, IOException, ParserConfigurationException, FontFormatException, SAXException {
        return BaseResult.ok(evidenceService.getEvidenceCert(id));
    }

    @ApiOperation("删除取证记录 1删除成功 0删除失败")
    @GetMapping("/record")
    public BaseResult<Integer> markDeleteEvidence(@Validated @NotNull Long id) {
        return BaseResult.ok(evidenceService.markDeleteEvidence(id));
    }


}
