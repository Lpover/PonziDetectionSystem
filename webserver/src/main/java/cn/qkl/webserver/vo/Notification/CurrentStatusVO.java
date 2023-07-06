package cn.qkl.webserver.vo.notification;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class CurrentStatusVO {

    @ApiModelProperty("通知开关状态，0-关闭，1-打开")
    private Integer open;

    @ApiModelProperty("周末通知开关状态，0-关闭，1-打开")
    private Integer openWeek;

    @ApiModelProperty("接收开启的时间")
    private Time startTime;

    @ApiModelProperty("接收关闭的时间")
    private Time endTime;


}
