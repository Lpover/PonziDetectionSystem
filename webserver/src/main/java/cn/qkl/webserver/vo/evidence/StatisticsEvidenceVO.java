package cn.qkl.webserver.vo.evidence;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @param
 * @return
 */
@Data
public class StatisticsEvidenceVO {
    @Data
    public static class PlatformView {
        @ApiModelProperty("平台名称")
        private String platformName;
        @ApiModelProperty("网页取证数量")
        private Integer webNum;
        @ApiModelProperty("移动端取证数量")
        private Integer mobileNum;
        @ApiModelProperty("固证数量")
        private Integer reinforceNum;
    }

    @Data
    public static class TimeView {
        @ApiModelProperty("日期时间")
        private Date date;
        @ApiModelProperty("网页取证数量")
        private Integer webNum;
        @ApiModelProperty("移动端取证数量")
        private Integer mobileNum;
        @ApiModelProperty("固证数量")
        private Integer reinforceNum;
    }

    @Data
    public static class ReinforceView {
        @ApiModelProperty("内容监测数量")
        private Integer contentMonitorNum;
        @ApiModelProperty("网页取证数量")
        private Integer webNum;
        @ApiModelProperty("固证数量")
        private Integer reinforceNum;
    }

    @ApiModelProperty("平台统计视图")
    private List<PlatformView> platformView;
    @ApiModelProperty("时间统计视图")
    private List<TimeView> timeView;
    @ApiModelProperty("固证量统计视图")
    private ReinforceView reinforceView;
}
