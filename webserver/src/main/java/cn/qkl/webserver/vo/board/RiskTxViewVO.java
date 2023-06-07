package cn.qkl.webserver.vo.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @param
 * @return
 */
@Data
public class RiskTxViewVO {
    @ApiModelProperty("高风险交易数量的列表")
    List<Integer> highTx;

    @ApiModelProperty("中风险交易数量的列表")
    List<Integer> midTx;

    @ApiModelProperty("低风险交易数量的列表")
    List<Integer> lowTx;

    @ApiModelProperty("当前时间")
    Date currentTime;

}
