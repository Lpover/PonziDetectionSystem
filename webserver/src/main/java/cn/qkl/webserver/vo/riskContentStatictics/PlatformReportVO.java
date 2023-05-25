package cn.qkl.webserver.vo.riskContentStatictics;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlatformReportVO {
    @ApiModelProperty("平台名称")
    private String platformName;
    @ApiModelProperty("平台新增风险数量")
    private Integer contentSum;
}