package cn.qkl.webserver.dto.detail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ContentRiskReviseDTO {
    @ApiModelProperty("是否人工修正，0否 1是")
    private Integer peopleRevise;
    @ApiModelProperty("人工修正结果，0否 1是")
    private Integer resultRevise;
    @ApiModelProperty("数字内容id")
    @NotNull
    private Long contentID;
}
