package cn.qkl.webserver.dto.detail;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ContentDynamicMonitorDTO extends PageDTO {
    @ApiModelProperty("数字内容主键id")
    @NotNull
    private Long contentID;
}
