package cn.qkl.webserver.dto.dynamic;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DynamicContentListQueryDTO extends PageDTO {
    @ApiModelProperty("风险评级：1低风险 2中风险 3高风险, 不传表示都选")
    private List<Integer> riskLevelList;
    @ApiModelProperty("算法版本主键id, 不传表示都选")
    private List<Long> dynamicAlgorithmIdList;
    @ApiModelProperty("平台主键id, 不传表示都选")
    private List<Long> platformIdList;
    @ApiModelProperty("主体风险: 0 无风险 1 有风险, 不传表示都选")
    private List<Integer> contentRiskTypeList;
    @ApiModelProperty("收录开始时间")
    private Date startInviteTime;
    @ApiModelProperty("收录结束时间")
    private Date endInviteTime;
}
