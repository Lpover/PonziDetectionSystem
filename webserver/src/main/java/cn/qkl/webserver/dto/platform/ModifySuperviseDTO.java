package cn.qkl.webserver.dto.platform;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
@Data
public class ModifySuperviseDTO {
    @ApiModelProperty("平台id")
    @NotNull
    private Long id;
    @ApiModelProperty("监管状态 0为不监管 1为监管")
    @NotNull
    @Range(min = 0, max = 1)
    private Integer monitor;
}
