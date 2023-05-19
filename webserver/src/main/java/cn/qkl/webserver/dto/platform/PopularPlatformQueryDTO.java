package cn.qkl.webserver.dto.platform;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class PopularPlatformQueryDTO {
    @ApiModelProperty("此平台为web或nft平台")
    @NotNull
    private Integer type;
}
