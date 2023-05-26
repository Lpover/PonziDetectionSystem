package cn.qkl.webserver.vo.riskcontentstatistics;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.Algorithm;
import cn.qkl.common.repository.model.RiskContentStatistics;
import cn.qkl.webserver.vo.algorithm.AlgorithmVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.bytebuddy.jar.asm.commons.Remapper;

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
