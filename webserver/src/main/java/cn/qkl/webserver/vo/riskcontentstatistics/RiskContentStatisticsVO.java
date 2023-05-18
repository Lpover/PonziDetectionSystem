package cn.qkl.webserver.vo.riskcontentstatistics;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class RiskContentStatisticsVO {
    @ApiModelProperty("风险类别走势主键id")
    private String id;
    @ApiModelProperty("近七天低风险数字内容数量")
    private List<Integer> lowRiskNumber;
    @ApiModelProperty("近七天中风险数字内容数量")
    private List<Integer> middleRiskNumber;
    @ApiModelProperty("近七天高风险数字内容数量")
    private List<Integer> highRiskNumber;
    @ApiModelProperty("收录开始时间")
    private Date startInviteTime;
    @ApiModelProperty("收录结束时间")
    private Date endInviteTime;
}
