package cn.qkl.webserver.vo.riskAccount;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.RiskReport;
import cn.qkl.webserver.vo.contentRiskStatictics.RiskCategoryVO;
import cn.qkl.webserver.vo.riskContentStatictics.PlatformReportVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class SmartAddressFindVO {

    @ApiModelProperty("地址表-风险等级")
    private Integer riskIndex;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("交易表-来源地址")
    private String from;

    @ApiModelProperty("交易表-去向地址")
    private String to;

    @ApiModelProperty("来源地址风险等级，0-低风险 1-中风险 2-高风险")
    private Integer fromRiskIndex;

    @ApiModelProperty("去向地址风险等级，0-低风险 1-中风险 2-高风险")
    private Integer toRiskIndex;

    @ApiModelProperty("交易金额")
    private Long txAmount;

    @ApiModelProperty("交易笔数")
    private Long txNum;

    @ApiModelProperty("金额占来源账户比")
    private BigDecimal fromRatio;

    @ApiModelProperty("金额占去向账户比")
    private BigDecimal toRatio;

    @ApiModelProperty("公链")
    private String blockchain;

//    @ApiModelProperty("币种")
//    private String currencyType;

}
