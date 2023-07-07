package cn.qkl.webserver.dto.noticification;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class ReceiveTimeDTO {

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm:ss")
    @DateTimeFormat("HH:mm:ss")
    @ApiModelProperty("接收开启的时间")
    private Date startTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm:ss")
    @DateTimeFormat("HH:mm:ss")
    @ApiModelProperty("接收关闭的时间")
    private Date endTime;

}
