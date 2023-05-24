package cn.qkl.webserver.vo.riskcontentstatistics;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.Algorithm;
import cn.qkl.common.repository.model.RiskContentStatistics;
import cn.qkl.webserver.vo.algorithm.AlgorithmVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.bytebuddy.jar.asm.commons.Remapper;

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
    public static RiskContentStatisticsVO transform(RiskContentStatistics riskSta) {
        RiskContentStatisticsVO vo = new RiskContentStatisticsVO();
        BeanUtil.copyProperties(riskSta, vo);
        return vo;
    }
}
