package cn.qkl.webserver.dto.riskaccount;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:49
 * @wiki
 */
@Data
public class SmartAddressFindDTO {

    @ApiModelProperty("目标地址")
    private String address;

    @ApiModelProperty("查找方向：1-查去向/2-查来源")
    private Integer findDirections;

    @ApiModelProperty("选择某一区块链进行账户网状分析，请求chain/list接口获取链列表")
    private Long chainID;

    @ApiModelProperty("选择风险等级：0-低风险 1-中风险 2-高风险")
    private Integer riskIndex;

//    @ApiModelProperty("选择表格：1-地址表 2-交易表")
//    private Integer select;

}
