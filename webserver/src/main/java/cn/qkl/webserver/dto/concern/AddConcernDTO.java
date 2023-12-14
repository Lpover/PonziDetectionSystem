package cn.qkl.webserver.dto.concern;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AddConcernDTO{
//    @ApiModelProperty("目前登录账号的ID，对应user表中的id")
//    private Long userId;
    @ApiModelProperty("内容标题")
    private String title;

    @ApiModelProperty("跳转url")
    private String url;

    @ApiModelProperty("收藏时间")
    private Date createTime;
}
