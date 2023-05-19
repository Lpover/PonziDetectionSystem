package cn.qkl.webserver.dto.cross;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CrossContentListQueryDTO extends PageDTO {
    @ApiModelProperty("风险评级：1低风险 2中风险 3高风险, 不传表示都选")
    @Size(max = 3)
    private List<@Range(min = 1, max = 3) Integer> riskLevelList;
    @ApiModelProperty("源链主键id, 不传表示都选")
    private List<Long> chainIdList;
    @ApiModelProperty("目标链主键id, 不传表示都选")
    private List<Long> dstChainIdList;
    @ApiModelProperty("跨链桥： 1 Zkbridge 2 protalTokenBridge , 不传表示都选")
    @Size(max = 2)
    private List<@Range(min = 1, max = 2) Integer> bridgeTypeList;
    @ApiModelProperty("收录开始时间")
    private Date startTime;
    @ApiModelProperty("收录结束时间")
    private Date endTime;
}
