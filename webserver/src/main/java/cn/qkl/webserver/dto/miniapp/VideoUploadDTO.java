package cn.qkl.webserver.dto.miniapp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * @Author sunxiaen
 * @Date 2023/12/19 16:16
 **/
@Data
public class VideoUploadDTO {
    @ApiModelProperty("上传文件 multipart格式")
    @NotNull
    private MultipartFile file;

    @ApiModelProperty("视频证据文件的名称")
    private String name;
}
