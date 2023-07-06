package cn.qkl.webserver.vo.evidence;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @param
 * @return
 */
@Data
public class EvidenceRiskTypeVO {
    @ApiModelProperty("风险类型列表")
    private List<String> evidenceID;

}
