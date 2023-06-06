package cn.qkl.webserver.vo.platformview;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.mapper.PlatformDailyStatisticsMapper;
import cn.qkl.common.repository.model.PlatformDailyStatistics;
import cn.qkl.common.repository.model.RiskReport;
import cn.qkl.webserver.vo.contentRiskStatictics.RiskCategoryVO;
import cn.qkl.webserver.vo.riskContentStatictics.PlatformReportVO;
import cn.qkl.webserver.vo.riskReport.RiskReportInfoVO;
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
public class VolumeTrendsVO {
    @ApiModelProperty("今日风险内容数量")
    private Integer contentRiskSum;

    @ApiModelProperty("统计的时间")
    private Date createTime;
    public static VolumeTrendsVO transform(List<VolumeTrendsVO> platformDailyStatistics) {
        VolumeTrendsVO vo = new VolumeTrendsVO();
        BeanUtil.copyProperties(platformDailyStatistics, vo);
        return vo;
    }
}
