package cn.qkl.webserver.dto.platformview;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlatformAndTimeSelectionDTO {

    @ApiModelProperty("平台选择：平台ID")
    private long selectPlatformId=-999;//-999代表未选择

    @ApiModelProperty("时间范围：1-7天 2-30天 3-180天，默认7天")
    private long selectTime=1;

}
