package cn.qkl.webserver.vo.evidence;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param
 * @return
 */
@Data
public class EvidencePhaseVO {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("取证固证阶段：0 取证中 1 固证中 2 完成 3 失败")
    private Integer phase;
}
