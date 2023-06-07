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
public class RiskNumViewVO {
    @ApiModelProperty("高风险数量的列表")
    List<Integer> highNum;

    @ApiModelProperty("中风险数量的列表")
    List<Integer> midNum;

    @ApiModelProperty("低风险数量的列表")
    List<Integer> lowNum;

    @ApiModelProperty("当前时间")
    Date currentTime;
}
