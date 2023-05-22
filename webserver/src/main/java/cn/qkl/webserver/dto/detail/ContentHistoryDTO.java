package cn.qkl.webserver.dto.detail;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContentHistoryDTO extends PageDTO {
    @ApiModelProperty("数字内容主键id")
    @NotNull
    private Long contentID;
}
