package cn.qkl.webserver.vo.notification;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/6/30 16:57
 **/

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
//通知记录的单条记录的数据结构
public class NotificationRecordVO {
    @ApiModelProperty("通知项们")
    private List<String> notifyItems;

    @ApiModelProperty("被通知人们")
    private List<String> users;

    @ApiModelProperty("通知时间")
    private Date createTime;

    @ApiModelProperty("通知状态  0-待发送 1-已发送 2-失败")
    private Integer status;

}
