package cn.qkl.webserver.vo.riskAccount;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:49
 * @wiki
 */
@Data
public class TransactionDetailVO {

    @ApiModelProperty("交易哈希，是长度为66的字符串")
    private String txHash;

    @ApiModelProperty("交易时间")
    private Date updateTime;

    @ApiModelProperty("交易方向，1-转入/2-转出")
    private Integer txDirection;

    @ApiModelProperty("对手地址")
    private String address;

    @ApiModelProperty("交易金额")
    private String value;

    @ApiModelProperty("备注")
    private String note;

}
