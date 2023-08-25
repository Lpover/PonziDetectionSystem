package cn.qkl.webserver.vo.riskAccount;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author sunxiaen
 * @Date 2023/8/23 15:14
 **/

@Data
public class NetworkAccountEdgeVO {
    @ApiModelProperty("from节点")
    String from;

    @ApiModelProperty("to节点")
    String to;

    @ApiModelProperty("交易金额")
    Long txAmount;

    @ApiModelProperty("交易笔数")
    Long txNum;

    @ApiModelProperty("金额占来源账户比")
    Double fromRatio;

    @ApiModelProperty("金额占去向账户比")
    Double toRatio;

    @ApiModelProperty("来源地址风险等级，0-低风险 1-中风险 2-高风险")
    Integer fromRiskIndex;

    @ApiModelProperty("去向地址风险等级，0-低风险 1-中风险 2-高风险")
    Integer toRiskIndex;

}
