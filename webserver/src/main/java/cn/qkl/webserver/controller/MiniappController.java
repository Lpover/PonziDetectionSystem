package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.common.log.ApiRecord;
import cn.qkl.webserver.common.log.OperationApiType;
import cn.qkl.webserver.dto.miniapp.EvidenceDTO;
import cn.qkl.webserver.dto.miniapp.VideoUploadDTO;
import cn.qkl.webserver.service.MiniappService;
import cn.qkl.webserver.vo.miniapp.EvidenceVO;
import cn.qkl.webserver.vo.miniapp.VideoVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2024/1/2 13:57
 **/
@RestController
@Slf4j
@Validated
@Api(value = "小程序相关接口", tags = {"小程序相关接口"})
@ApiSupport(author = "lpc,sxe,zz")
@RequestMapping("miniapp")
@RefreshScope
//@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
//@ApiRecord(apiType = OperationApiType.class)

public class MiniappController {

    @Resource
    MiniappService miniappService;

    @ApiOperation("录屏上传")
    @PostMapping("video/upload")
    public BaseResult<VideoVO> videoUpload(@Validated VideoUploadDTO dto) throws IOException {
        VideoVO vo = miniappService.videoUpload(dto);
        return BaseResult.ok(vo);
    }

    @ApiOperation("证据保全（保全/未保全记录）")
    @PostMapping("evidence/list")
    public BaseResult<List<EvidenceVO>> getEvidenceList(@Validated EvidenceDTO dto) throws IOException {
        List<EvidenceVO> evidenceVOList = miniappService.getEvidenceList(dto);
        return BaseResult.ok(evidenceVOList);
    }

}
