package cn.qkl.webserver.dto.log;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author sunxiaen
 * @Date 2023/12/19 16:16
 **/

@Data
public class LoginLogDTO extends PageDTO {
    @ApiModelProperty("搜索的用户名")
    private String userName;
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
}
