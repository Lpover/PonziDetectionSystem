package cn.qkl.webserver.dto.Notification;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ReceiveTimeDTO {

    @ApiModelProperty("接收开启的时间")
    private Date startTime;

    @ApiModelProperty("接收关闭的时间")
    private Date endTime;

}
