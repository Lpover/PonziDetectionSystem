package cn.qkl.webserver.dto.noticification;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class ReceiveTimeDTO {

    @ApiModelProperty("接收开启的时间")
    private Date startTime;

    @ApiModelProperty("接收关闭的时间")
    private Date endTime;

}
