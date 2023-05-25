package cn.qkl.webserver.dto.oss;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @param
 * @return
 */
@Data
public class ossUploadFileDTO {
    @ApiModelProperty("上传文件的本地路径，路径分隔符为\\或者/")
    @NotNull
    private String localFile;
}
