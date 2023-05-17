package cn.qkl.webserver.vo.algorithm;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AlgorithmVO {
    @ApiModelProperty("算法主键id")
    private Long id;

    @ApiModelProperty("算法版本: 1 2 3")
    private Integer version;

    @ApiModelProperty("算法识别率")
    private BigDecimal recognitionRate;

    @ApiModelProperty("算法类别：0动态风险识别算法 1账户风险识别算法")
    private Integer type;
}
