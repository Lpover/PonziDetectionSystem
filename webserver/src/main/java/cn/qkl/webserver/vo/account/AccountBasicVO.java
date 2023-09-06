package cn.qkl.webserver.vo.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author sunxiaen
 * @Date 2023/5/18 21:14
 **/

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountBasicVO {
    @ApiModelProperty("賬戶主鍵ID")
    private Long accountId;

    @ApiModelProperty("账户地址")
    private String accountAddress;

    @ApiModelProperty("账户所在区块链ID")
    private Long chainId;

    @ApiModelProperty("账户所在区块链名字（需要交表查）")
    private String chainName;

    @ApiModelProperty("账户去匿名话昵称")
    private String accountAlias;

    @ApiModelProperty("账户头像")
    private String image;

    @ApiModelProperty("账户加密货币余额")
    private String cryptoBalance;

    @ApiModelProperty("账户现实货币余额")
    private String currencyBalance;

    @ApiModelProperty("汇率")
    private String exchangeRate;

    @ApiModelProperty("账户详情页基本信息更新时间")
    private Date updateTime;

}
