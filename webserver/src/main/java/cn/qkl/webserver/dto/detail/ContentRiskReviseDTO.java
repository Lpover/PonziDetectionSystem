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

    @ApiModelProperty("风险评级 0无风险 1低风险 2中风险 3高风险")
    @NotNull
    private Integer riskLevel;

    @ApiModelProperty("人工识别结果 是否动态 0静态 1读动态 2写动态")
    @NotNull
    private Integer dynamicType;

}
