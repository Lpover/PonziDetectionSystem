package cn.qkl.webserver.vo.evidence;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author sunxiaen
 * @Date 2023/6/30 9:35
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvidenceRecordItemVO {
    @ApiModelProperty("取证记录ID")
    private Long id;

    @ApiModelProperty("取证名称")
    private String name;

    @ApiModelProperty("取证方式 0 网页取证 1 移动端取证 2 手动固证 3 内容监测")
    private Integer evidenceType;

    @ApiModelProperty("风险类型")
    private String riskType;

    @ApiModelProperty("取证内容 原网页")
    private String url;

    @ApiModelProperty("取证内容 pack文件的地址")
    private String packOssPath;

    @ApiModelProperty("取证固证状态 0 取证中 1 固证中 2 完成 3 失败")
    private Integer evidencePhase;

    @ApiModelProperty("取证时间")
    private Date time;

    @ApiModelProperty("平台名称")
    private String platformName;

    @ApiModelProperty("平台分类 NFT or Web3")
    private Integer platformType;

    // 定时任务信息显示
    @ApiModelProperty("取证频率：0 关闭 1 一次 5 每天 6 每周 7 每月")
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
