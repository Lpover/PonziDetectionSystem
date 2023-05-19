package cn.qkl.common.framework.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class PageDTO {
    @ApiModelProperty("页码")
    @Min(1)
    private Integer pageId = 1;
    @ApiModelProperty("页条数")
    @Min(1)
    private Integer pageSize = 10;
}