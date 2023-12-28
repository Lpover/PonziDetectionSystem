package cn.qkl.webserver.vo.evidence;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @param
 * @return
 */
@Data
public class EvidenceRegularVO {
    // 定时取证
    @ApiModelProperty("定时取证频率：0 定时取证关闭 1 一次 5 每天 6 每周 7 每月")
    private Integer frequency;
    @ApiModelProperty("起始时间（在频率为单次时，表示单次取证时间）")
    private Date startTime;
    @ApiModelProperty("结束时间（在频率为单次时，表示单次取证时间）")
    private Date endTime;
    @ApiModelProperty("每周动作的星期几（1-7，分别代表周一到周日）（仅在频率为每周时有效）")
//    @Range(min = 1, max = 7)
    private int dayOfWeek;
    @ApiModelProperty("每月动作的日期（1-31，代表每月的具体哪一天）（仅在频率为每月时有效）")
//    @Range(min = 1, max = 31)
    private int dayOfMonth;
}
