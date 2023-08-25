package cn.qkl.webserver.dto.noticification;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OpenDTO {
    @ApiModelProperty("通知开关状态，0-关闭，1-打开")
    private Integer openValue=0;
    @ApiModelProperty("频率，单位分钟")
    private Integer frequency = 10;
}
