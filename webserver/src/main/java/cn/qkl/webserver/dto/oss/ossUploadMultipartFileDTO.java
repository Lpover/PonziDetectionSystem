package cn.qkl.webserver.dto.oss;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * @param
 * @return
 */
@Data
public class ossUploadMultipartFileDTO {
    @ApiModelProperty("上传文件 multipart格式")
    @NotNull
    private MultipartFile file;
}
