package cn.qkl.webserver.vo.log;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author sunxiaen
 * @Date 2023/12/19 16:24
 **/
@Data
public class LoginLogVO {
    @ApiModelProperty("记录的主键id")
    private Long id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("来源ip地址")
    private String ip;

    @ApiModelProperty("接口名称")
    private String apiName;

    @ApiModelProperty("接口路径")
    private String apiRouter;

    @ApiModelProperty("操作时间")
    private Date time;

    @ApiModelProperty("详情")
    private String detail;

}
