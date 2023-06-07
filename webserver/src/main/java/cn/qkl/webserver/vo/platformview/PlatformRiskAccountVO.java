package cn.qkl.webserver.vo.platformview;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class PlatformRiskAccountVO {
    @ApiModelProperty("该账号主键ID")
    private Long id;

    @ApiModelProperty("该账号的昵称")
    private String accountAlias;

    @ApiModelProperty("该账号头像url")
    private String image;

    @ApiModelProperty("该账号发布的风险内容数量")
    private Integer releaseNum;


}
