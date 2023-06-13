package cn.qkl.webserver.dto.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author sunxiaen
 * @Date 2023/6/6 16:30
 **/
@Data
public class CockpitIntegratedQueryDTO {
    @ApiModelProperty("综合风险驾驶舱筛选入参-时间")
    Long timeSeriesChoice;
    @ApiModelProperty("综合风险驾驶舱筛选入参-社交平台")
    Long socialPlatformChoice;
    @ApiModelProperty("综合风险驾驶舱筛选入参-平台")
    Long platformChoice;
}
