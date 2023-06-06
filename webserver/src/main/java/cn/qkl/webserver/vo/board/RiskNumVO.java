package cn.qkl.webserver.vo.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @param
 * @return
 */
@Data
public class RiskNumVO {
    @ApiModelProperty("高风险数量的列表")
    List<Integer> high;

    @ApiModelProperty("中风险数量的列表")
    List<Integer> mid;

    @ApiModelProperty("低风险数量的列表")
    List<Integer> low;
}
