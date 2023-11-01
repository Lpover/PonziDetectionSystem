package cn.qkl.webserver.vo.riskAccount;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/8/23 15:11
 **/

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkAccountPanelVO {
    @ApiModelProperty("中心账户主鍵ID")
    private Long accountId;

    @ApiModelProperty("中心账户地址")
    private String accountAddress;

    @ApiModelProperty("账户所在区块链ID")
    private Long chainId;

    @ApiModelProperty("账户所在区块链名字（需要交表查）")
    private String chainName;

    @ApiModelProperty("与中心账户发生的交易关系记录(相关账号，包含中心账户)")
    List<NetworkAccountNodeVO> nodes;

    @ApiModelProperty("与中心账户发生的交易关系记录")
    List<NetworkAccountEdgeVO> edges;

}
