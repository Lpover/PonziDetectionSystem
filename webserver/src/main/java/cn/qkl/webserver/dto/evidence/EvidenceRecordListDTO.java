package cn.qkl.webserver.dto.evidence;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author sunxiaen
 * @Date 2023/6/30 11:04
 **/

@Data
public class EvidenceRecordListDTO extends PageDTO {
    @ApiModelProperty("取证固证类型的id，0 网页取证 1 移动端取证 2 手动固证 3 内容监测")
    private Integer evidenceType;
    @ApiModelProperty("风险类型，字符串搜索")
    private String riskType;
    @ApiModelProperty("所属平台的id")
    private Long platformId;
    @ApiModelProperty("起始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("取证名称")
    private String evidenceName;
}
