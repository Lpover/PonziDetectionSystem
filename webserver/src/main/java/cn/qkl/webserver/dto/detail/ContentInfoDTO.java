package cn.qkl.webserver.dto.detail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ContentInfoDTO {
    @ApiModelProperty("数字内容主键id")
    @NotNull
    private Long contentID;
}
