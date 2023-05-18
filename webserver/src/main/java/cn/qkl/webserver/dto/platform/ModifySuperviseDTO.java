package cn.qkl.webserver.dto.platform;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class ModifySuperviseDTO {
    @ApiModelProperty("监管状态 0为不监管 1为监管")
    @NotNull
    private Integer monitor;
}
