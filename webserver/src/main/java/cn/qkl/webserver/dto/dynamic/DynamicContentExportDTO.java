package cn.qkl.webserver.dto.dynamic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class DynamicContentExportDTO {
    @ApiModelProperty("风险评级：1低风险 2中风险 3高风险, 不传表示都选")
    private List<Integer> riskLevelList;
    @ApiModelProperty("平台主键id, 不传表示都选")
    private List<Long> platformIdList;
    @ApiModelProperty("时间范围 0全部 1近七天 2近一个月 3近半年")
    @NotNull
    private Integer time;
}
