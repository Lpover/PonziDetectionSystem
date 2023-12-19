package cn.qkl.webserver.vo.concern;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author sunxiaen
 * @Date 2023/5/18 10:29
 **/
@Data
public class AddConcernVO {
    @ApiModelProperty("内容标题")
    private String title;

    @ApiModelProperty("跳转url")
    private String url;

    @ApiModelProperty("收藏时间")
    private Date createTime;
}
