package cn.qkl.webserver.vo.riskAccount;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class SmartTranscationFindVO {

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("交易表-来源地址")
    private String from;

    @ApiModelProperty("交易表-去向地址")
    private String to;

    @ApiModelProperty("交易表-来源地址风险等级，0-低风险 1-中风险 2-高风险")
    private Integer fromRiskIndex;

    @ApiModelProperty("交易表-去向地址风险等级，0-低风险 1-中风险 2-高风险")
    private Integer toRiskIndex;

    @ApiModelProperty("交易表-交易金额")
    private Long txAmount;

    @ApiModelProperty("交易表-交易笔数")
    private Long txNum;

    @ApiModelProperty("交易表-金额占来源账户比")
    private BigDecimal fromRatio;

    @ApiModelProperty("交易表-金额占去向账户比")
    private BigDecimal toRatio;

    @ApiModelProperty("交易表-公链")
    private String blockchain;

//    @ApiModelProperty("币种")
//    private String currencyType;

}
