package cn.qkl.webserver.vo.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author sunxiaen
 * @Date 2023/5/19 14:19
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountTxHistoryVO {
    @ApiModelProperty("交易hash")
    private String txHash;

    @ApiModelProperty("交易方法")
    private String method;

    @ApiModelProperty("交易区块链号")
    private Long block;

    @ApiModelProperty("交易时间-Date")
    private Date txTimestamp;

    @ApiModelProperty("交易from")
    private String from;

    @ApiModelProperty("交易to")
    private String to;

    @ApiModelProperty("交易value")
    private String value;

    @ApiModelProperty("交易fee")
    private String txFee;

    @ApiModelProperty("账户所在区块链ID")
    private Long chainId;

    @ApiModelProperty("账户所在区块链名字（需要交表查）")
    private String chainName;
}
