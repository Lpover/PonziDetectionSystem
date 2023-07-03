package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.request.PageDTO;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.dynamic.DynamicContentListQueryDTO;
import cn.qkl.webserver.dto.evidence.EvidenceRecordListDTO;
import cn.qkl.webserver.service.EvidenceService;
import cn.qkl.webserver.vo.dynamic.DynamicContentVO;
import cn.qkl.webserver.vo.evidence.EvidenceRecordItemVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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

    @ApiOperation("取证记录列表")
    @GetMapping("/record/list")
    public BaseResult<PageVO<EvidenceRecordItemVO>> getRecordList(EvidenceRecordListDTO dto) {
        return BaseResult.ok(evidenceService.getRecordList(dto));
    }

    @ApiOperation("查看固证文书")
    @GetMapping("/cert")
    public BaseResult<String> getEvidenceCert(@Validated @NotNull Long id) {
        return BaseResult.ok(evidenceService.getEvidenceCert(id));
    }

    @ApiOperation("删除取证记录")
    @GetMapping("/record")
    public BaseResult<Integer> markDeleteEvidence(@Validated @NotNull Long id) {
        return BaseResult.ok(evidenceService.markDeleteEvidence(id));
    }


}
