package cn.qkl.webserver.vo.platformview;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
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
public class IndexTrendsVO {
    @ApiModelProperty("今日风险指数")
    private List<Integer> riskIndex;

    @ApiModelProperty("统计的时间")
    private List<Date> createTime;
}
