package cn.qkl.webserver.dto.platform;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class ModifySuperviseDTO {
    @ApiModelProperty("监管状态 0为不监管 1为监管")
    @NotNull
    private Integer monitor;
}
