package cn.qkl.webserver.dto.evidence;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WebEvidenceDTO {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("取证名称")
    private String name;
    @ApiModelProperty("风险类型")
    private String riskType;
    @ApiModelProperty("情况概要")
    private String introduction;
    @ApiModelProperty("取证人员")
    private String personnel;
    @ApiModelProperty("取证地址")
    private String url;
    @ApiModelProperty("所属平台的id")
    private Long platformId;
}
