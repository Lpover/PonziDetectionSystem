package cn.qkl.webserver.controller;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.util.OssUtil;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.oss.ossUploadFileDTO;
import cn.qkl.webserver.dto.oss.ossUploadMultipartFileDTO;
import cn.qkl.webserver.vo.oss.OssUploadFileVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @param
 * @return
 */
@RestController
@Slf4j
@Validated
@Api(value = "OSS相关接口", tags = {"OSS相关接口"})
@ApiSupport(author = "zz")
@RequestMapping("oss")
@RefreshScope
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
public class OssController {
    @Autowired
    OssUtil ossUtil;

    @ApiOperation("上传文件(路径)到oss")
    @PostMapping("upload/by/path")
    public BaseResult<OssUploadFileVO> ossUploadFileByPath(@RequestBody @Validated ossUploadFileDTO dto) {
        OssUploadFileVO ossUploadFileVO = new OssUploadFileVO();
        ossUploadFileVO.setRemoteFileURL(ossUtil.updateLocalFile(dto.getLocalFile()));
        return BaseResult.ok(ossUploadFileVO);
    }

    @ApiOperation("上传文件(MultipartFile)到oss")
    @PostMapping("upload/by/file")
    public BaseResult<OssUploadFileVO> ossUploadFileByFile(@Validated ossUploadMultipartFileDTO dto) throws IOException {
        OssUploadFileVO ossUploadFileVO = new OssUploadFileVO();
        ossUploadFileVO.setRemoteFileURL(ossUtil.uploadMultipartFile(dto.getFile(), dto.getFile().getName()));
        return BaseResult.ok(ossUploadFileVO);
    }

}
