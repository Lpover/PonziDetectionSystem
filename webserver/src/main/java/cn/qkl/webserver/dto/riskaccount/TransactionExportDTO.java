package cn.qkl.webserver.dto.riskaccount;

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
public class TransactionExportDTO {

    @ApiModelProperty("目标地址")
    private String address;

    @ApiModelProperty("区块链，ETH/TRON")
    private String blockchain;

    @ApiModelProperty("交易金额下限：数字框，默认不填，表示导出所有金额的交易")
    private Long lowerLimit;

    @ApiModelProperty("交易开始时间")
    private Date startTime;

    @ApiModelProperty("交易开始时间")
    private Date endTime;

    @ApiModelProperty("交易方向， 1-全部/2-转入/3-转出")
    private Integer direction;

}
