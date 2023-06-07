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
public class PlatformRiskContentVO {
    @ApiModelProperty("该内容主键ID")
    private Long id;

    @ApiModelProperty("该内容的名字")
    private String name;

    @ApiModelProperty("logo的url")
    private String metaUrl;

    @ApiModelProperty("该内容的价值")
    private String cryptoPrice;

}
