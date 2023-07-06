package cn.qkl.webserver.vo.threshold;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class IndexReportVO {

    @ApiModelProperty("主键ID,1-风险平台占比,2-风险内容数量,3-风险交易数量,4-综合风险指数,5-平台风险指数")
    private Long id;

    @ApiModelProperty("当前的阈值")
    private Integer nowIndex;

    @ApiModelProperty("设定的阈值")
    private Integer setIndex;
}
