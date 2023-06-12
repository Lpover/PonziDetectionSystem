package cn.qkl.webserver.dto.platformview;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlatformSelectionDTO {
    @ApiModelProperty("平台选择：平台ID")
    private long selectPlatformId=-999;
}
