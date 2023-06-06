package cn.qkl.webserver.vo.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CrossContentRiskViewVO {
    @ApiModelProperty("链主键id")
    private Long chainId;
    @ApiModelProperty("链名称")
    private String chainName;
    @ApiModelProperty("风险账户数量")
    private Integer riskAccountNum;
    @ApiModelProperty("风险交易数量")
    private Integer txNum;
}
