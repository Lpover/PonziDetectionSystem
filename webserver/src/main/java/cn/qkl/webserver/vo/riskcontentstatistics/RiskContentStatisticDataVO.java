package cn.qkl.webserver.vo.riskcontentstatistics;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class RiskContentStatisticDataVO {
    @ApiModelProperty("低风险数字内容数量")
    private Integer lowRiskNumber;
    @ApiModelProperty("中风险数字内容数量")
    private Integer middleRiskNumber;
    @ApiModelProperty("高风险数字内容数量")
    private Integer highRiskNumber;
    @ApiModelProperty("时间")
    private Date updateTime;
}
