package cn.qkl.webserver.vo.dynamic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DynamicContentVO {
    @ApiModelProperty("数字内容主键id")
    private Long id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("合约地址")
    private String address;
    @ApiModelProperty("缩略图")
    private String metaUrl;
    @ApiModelProperty("识别算法版本")
    private Integer dynamicAlgorithm;
    @ApiModelProperty("识别状态：0识别完成 1正在识别中")
    private Integer dynamicRecognition;
    @ApiModelProperty("风险评级：1低风险 2中风险 3高风险")
    private Integer riskLevel;
    @ApiModelProperty("内容标签")
    private String contentTag;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}
