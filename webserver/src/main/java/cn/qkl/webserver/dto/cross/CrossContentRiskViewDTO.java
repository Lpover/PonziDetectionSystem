package cn.qkl.webserver.dto.cross;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class CrossContentRiskViewDTO {
    @ApiModelProperty("1 近七天 2 近1个月")
    @NotNull
    @Range(min = 1, max = 2)
    private Integer time;
}
