package cn.qkl.webserver.vo.platform;

import io.swagger.annotations.ApiModelProperty;

import javax.xml.crypto.Data;

public class PlatformListVO {
    @ApiModelProperty("平台主键id")
    private Long id;
    @ApiModelProperty("平台名称")
    private String name;
    @ApiModelProperty("平台url")
    private String url;
    @ApiModelProperty("平台logo")
    private String logo;
    @ApiModelProperty("是否监管 0表示不监管 1表示监管")
    private Integer monitor;
    @ApiModelProperty("平台位置")
    private Integer location;
    @ApiModelProperty("风险内容数量")
    private Integer riskContentNum;
    @ApiModelProperty("监测频率")
    private Integer frequency;
    @ApiModelProperty("24小时活跃度")
    private Integer activation;
    @ApiModelProperty("风险评级：1低风险 2中风险 3高风险")
    private Integer riskLevel;
    @ApiModelProperty("更新时间")
    private Data updateTime;
    @ApiModelProperty("上次抓取时间")
    private Data createTime;
}
