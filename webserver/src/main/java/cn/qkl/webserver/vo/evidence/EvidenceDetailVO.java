package cn.qkl.webserver.vo.evidence;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param
 * @return
 */
@Data
public class EvidenceDetailVO {
    @ApiModelProperty("证据ID")
    private Long evidenceID;
    @ApiModelProperty("取证名称")
    private String name;
    @ApiModelProperty("风险类型")
    private String riskType;
    @ApiModelProperty("情况概要")
    private String introduction;
    @ApiModelProperty("取证机构")
    private String institution;
    @ApiModelProperty("取证部门")
    private String department;
    @ApiModelProperty("取证人员")
    private String personnel;
    @ApiModelProperty("取证地址")
    private String url;
    @ApiModelProperty("所属平台的名称")
    private String platformName;
    @ApiModelProperty("取证固证阶段：0 取证中 1 固证中 2 完成 3 失败")
    private Integer evidencePhase;
}
