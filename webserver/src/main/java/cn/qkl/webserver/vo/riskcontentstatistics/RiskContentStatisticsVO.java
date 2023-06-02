package cn.qkl.webserver.vo.riskcontentstatistics;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public class RiskContentStatisticsVO {
    @ApiModelProperty("低风险数字内容数量")
    private List<Integer> lowRiskNumber;
    @ApiModelProperty("中风险数字内容数量")
    private List<Integer> middleRiskNumber;
    @ApiModelProperty("高风险数字内容数量")
    private List<Integer> highRiskNumber;
    @ApiModelProperty("时间")
    private List<Date> updateTime;
    public static RiskContentStatisticsVO transform(List<RiskContentStatisticDataVO> list) {
        RiskContentStatisticsVO vo = new RiskContentStatisticsVO();
        vo.setLowRiskNumber(new ArrayList<>());
        vo.setMiddleRiskNumber(new ArrayList<>());
        vo.setHighRiskNumber(new ArrayList<>());
        vo.setUpdateTime(new ArrayList<>());
        for (RiskContentStatisticDataVO riskContentStatisticDataVO : list) {
            vo.getLowRiskNumber().add(riskContentStatisticDataVO.getLowRiskNumber());
            vo.getMiddleRiskNumber().add(riskContentStatisticDataVO.getMiddleRiskNumber());
            vo.getHighRiskNumber().add(riskContentStatisticDataVO.getHighRiskNumber());
            vo.getUpdateTime().add(riskContentStatisticDataVO.getUpdateTime());
        }
        return vo;
    }
}
