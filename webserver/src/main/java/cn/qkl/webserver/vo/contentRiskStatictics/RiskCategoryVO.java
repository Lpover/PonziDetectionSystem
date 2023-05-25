package cn.qkl.webserver.vo.contentRiskStatictics;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RiskCategoryVO {
    @ApiModelProperty("类别名称")
    private String riskName;
    @ApiModelProperty("类别数量")
    private Integer riskNum;
}