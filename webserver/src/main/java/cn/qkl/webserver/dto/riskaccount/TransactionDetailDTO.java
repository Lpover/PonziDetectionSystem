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

    @ApiModelProperty("账户节点的地址")
    private String address;

}
