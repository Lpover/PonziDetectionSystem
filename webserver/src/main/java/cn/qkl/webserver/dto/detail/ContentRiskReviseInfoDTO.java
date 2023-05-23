package cn.qkl.webserver.dto.detail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @param
 * @return
 */
@Data
public class ContentRiskReviseInfoDTO {
    @ApiModelProperty("数字内容id")
    @NotNull
    private Long contentID;
}
