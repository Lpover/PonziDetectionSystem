package cn.qkl.webserver.vo.riskAccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author sunxiaen
 * @Date 2023/8/23 15:14
 **/

@Data
public class NetworkAccountEdgeVO {
    @ApiModelProperty("from节点accountId")
    @JsonProperty("source")
    Long fromAccountId;

    @JsonIgnore
    @ApiModelProperty("from节点")
    String from;

    @ApiModelProperty("to节点accountId")
    @JsonProperty("target")
    Long toAccountId;

    @JsonIgnore
    @ApiModelProperty("to节点")
    String to;

    @ApiModelProperty("交易金额")
    BigDecimal txAmount;

    @ApiModelProperty("交易笔数")
    Long txNum;

    @ApiModelProperty("金额占来源账户比")
    Double fromRatio;

    @ApiModelProperty("金额占去向账户比")
    Double toRatio;

    @JsonIgnore
    @ApiModelProperty("来源地址风险等级，0-低风险 1-中风险 2-高风险")
    Integer fromRiskIndex;

    @JsonIgnore
    @ApiModelProperty("去向地址风险等级，0-低风险 1-中风险 2-高风险")
    Integer toRiskIndex;

}
