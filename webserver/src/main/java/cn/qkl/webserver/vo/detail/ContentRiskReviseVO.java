package cn.qkl.webserver.vo.detail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContentRiskReviseVO {
    @ApiModelProperty("风险评级：0低风险 1中风险 2高风险")
    private Integer riskLevel;
    @ApiModelProperty("内容类型：0图片 1视频 2音频")
    private Integer contentType;
    @ApiModelProperty("内容标签，用逗号隔开每个标签")
    private String contentTag;
    @ApiModelProperty("自动识别模型算法")
    private String dynamicAlgorithm;
    @ApiModelProperty("算法准确率")
    private BigDecimal recognitionRate;
    @ApiModelProperty("识别结果：0静态 1动态")
    private String dynamicType;
}
