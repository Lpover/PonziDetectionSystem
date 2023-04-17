package cn.qkl.common.framework.request;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class PageDTO {
    @Min(1)
    private Integer pageId = 1;
    @Min(1)
    private Integer pageSize = 10;
}