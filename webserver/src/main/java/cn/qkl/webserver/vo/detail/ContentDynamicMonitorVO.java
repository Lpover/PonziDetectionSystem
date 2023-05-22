package cn.qkl.webserver.vo.detail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class ContentDynamicMonitorVO {
    @ApiModelProperty("数字内容风险评级：0低 1中 2高风险")
    private Integer riskLevel;
    @ApiModelProperty("内容标签，用逗号隔开每个标签")
    private String contentTag;
    @ApiModelProperty("监测到的变更时间")
    private String createTime;
}
