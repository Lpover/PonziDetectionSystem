package cn.qkl.webserver.dto.detail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ContentRiskReviseDTO {
//    @ApiModelProperty("人工修正结果，0否 1是")
//    @NotNull
//    private Integer resultRevise;
    @ApiModelProperty("数字内容id")
    @NotNull
    private Long contentID;
}
