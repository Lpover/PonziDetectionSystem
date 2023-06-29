package cn.qkl.webserver.dto.algorithm;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AlgorithmStateModifyDTO {
    @ApiModelProperty("算法类别：0动态风险识别算法 1账户风险识别算法")
    @NotNull
    private Integer type;

    @ApiModelProperty("算法主键id")
    @NotNull
    private Long id;
}
