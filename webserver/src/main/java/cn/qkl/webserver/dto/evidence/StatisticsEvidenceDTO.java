package cn.qkl.webserver.dto.evidence;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param
 * @return
 */
@Data
public class StatisticsEvidenceDTO {
    @ApiModelProperty("平台类型：0 全部 1 NFT 2 Web3")
    private Integer platformType;
    @ApiModelProperty("时间跨度：0 近7天 1 近30天")
    private Integer timeSpan;
}
