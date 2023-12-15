package cn.qkl.webserver.dto.concern;

import cn.qkl.common.framework.request.PageDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AddConcernDTO{
    @ApiModelProperty("内容标题")
    private String title;

    @ApiModelProperty("跳转url")
    private String url;
//    @ApiModelProperty("目前登录账号的ID，对应user表中的id")
//    private Long userId;
//    @ApiModelProperty("收藏时间,格式为yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date createTime;
}
