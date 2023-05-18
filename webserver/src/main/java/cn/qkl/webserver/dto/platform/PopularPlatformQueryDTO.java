package cn.qkl.webserver.dto.platform;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class PopularPlatformQueryDTO {
    @ApiModelProperty("此平台为web或nft平台")
    @NotNull
    private Integer type;
}
