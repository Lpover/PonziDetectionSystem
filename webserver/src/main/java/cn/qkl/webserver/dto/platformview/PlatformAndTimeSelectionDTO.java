package cn.qkl.webserver.dto.platformview;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlatformAndTimeSelectionDTO {

    @ApiModelProperty("平台选择：平台ID")
    private Integer selectPlatformId;

    @ApiModelProperty("时间范围：1-7天 2-30天 默认7天")
    private Integer selectTime;

}
