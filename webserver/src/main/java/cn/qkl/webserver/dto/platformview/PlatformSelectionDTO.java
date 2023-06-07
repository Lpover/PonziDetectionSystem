package cn.qkl.webserver.dto.platformview;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public class PlatformSelectionDTO {
    @ApiModelProperty("平台选择：平台ID")
    @NonNull
    private Long selectPlatformId;
}
