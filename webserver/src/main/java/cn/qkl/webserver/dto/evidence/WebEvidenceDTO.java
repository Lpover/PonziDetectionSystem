package cn.qkl.webserver.dto.evidence;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class WebEvidenceDTO {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("取证名称")
    private String name;
    @ApiModelProperty("风险类型")
    private String riskType;
    @ApiModelProperty("情况概要")
    private String introduction;
    @ApiModelProperty("取证人员")
    private String personnel;
    @ApiModelProperty("取证地址")
    private String url;
    @ApiModelProperty("所属平台的id")
    private Long platformId;

    // 定时取证
    @ApiModelProperty("定时取证频率：0 定时取证关闭 1 一次 5 每天 6 每周 7 每月")
    private Integer frequency;
    @ApiModelProperty("起始时间（在频率为单次时，表示单次取证时间）")
    private Date startTime;
    @ApiModelProperty("结束时间（在频率为单次时无效）")
    private Date endTime;
    @ApiModelProperty("每周动作的星期几（1-7，分别代表周一到周日）（仅在频率为每周时有效）")
    private int dayOfWeek;
    @ApiModelProperty("每月动作的日期（1-31，代表每月的具体哪一天）（仅在频率为每月时有效）")
    private int dayOfMonth;

}
