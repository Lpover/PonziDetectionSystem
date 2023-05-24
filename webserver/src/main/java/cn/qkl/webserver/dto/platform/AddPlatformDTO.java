package cn.qkl.webserver.dto.platform;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddPlatformDTO {
    @ApiModelProperty("平台名称")
    private String name;
    @ApiModelProperty("平台url")
    private String url;
    @ApiModelProperty("爬虫文件url")
    private String crawlerUrl;
}
