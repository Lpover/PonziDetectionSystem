package cn.qkl.webserver.dto.algorithm;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class AlgorithmAddDTO {
    @ApiModelProperty("算法名称")
    @NotNull
    private String name;

    @ApiModelProperty("算法描述")
    @NotNull
    private String describe;

    @ApiModelProperty("算法状态：0停用 1启用")
    @NotNull
    @Range(min = 0, max = 1)
    private Integer state;

    @ApiModelProperty("算法类别：0动态风险识别算法 1账户风险识别算法")
    @NotNull
    private Integer type;

    @ApiModelProperty("算法文件url")
    @NotNull
    private String fileUrl;
}
