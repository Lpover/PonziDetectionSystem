package cn.qkl.webserver.dto.evidence;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EvidenceDetailDTO {
    @ApiModelProperty("证据ID")
    private Long evidenceID;
}
