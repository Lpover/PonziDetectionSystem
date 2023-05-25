package cn.qkl.webserver.vo.oss;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param
 * @return
 */
@Data
public class OssUploadFileVO {
    @ApiModelProperty("可访问的文件URL")
    private String remoteFileURL;
}
