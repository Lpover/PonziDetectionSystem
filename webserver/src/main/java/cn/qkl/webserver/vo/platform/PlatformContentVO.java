package cn.qkl.webserver.vo.platform;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

public class PlatformContentVO {
    @ApiModelProperty("平台主键id")
    private Long id;
    @ApiModelProperty("平台名称")
    private String name;
}
