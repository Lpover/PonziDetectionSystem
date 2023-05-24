package cn.qkl.webserver.dto.platform;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ModifyPlatformDTO {
    //加个id
    @ApiModelProperty("平台id")
    @NotNull
    private Long id;
    @ApiModelProperty("平台名称")
    @NotNull
    private String name;
    @ApiModelProperty("平台url")
    @NotNull
    private String url;
    @ApiModelProperty("爬虫文件url")
    @NotNull
    private String crawlerUrl;
}
