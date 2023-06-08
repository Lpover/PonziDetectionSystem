package cn.qkl.webserver.dto.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class CrossContentRiskViewDTO {
    @ApiModelProperty("1 近七天 2 近1个月")
    @Range(min = 1, max = 2)
    private Integer time=1;
}
