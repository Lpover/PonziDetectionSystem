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
public class TransactionDetailDTO {

    @ApiModelProperty("交易哈希或者目标地址")
    private String address;

    @ApiModelProperty("交易开始时间")
    private Date startTime;

    @ApiModelProperty("交易开始时间")
    private Date endTime;

}
