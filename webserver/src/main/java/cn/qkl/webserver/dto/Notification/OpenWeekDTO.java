package cn.qkl.webserver.dto.Notification;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OpenWeekDTO {
    @ApiModelProperty("周末通知开关状态，0-关闭，1-打开")
    private Integer openWeekValue=0;
}
