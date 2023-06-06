package cn.qkl.webserver.dto.settings;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @param
 * @return
 */
@Data
public class MonitorRulesModifyDTO {
    @ApiModelProperty("设置的监测规则列表，0不监测 2每天 3每周 4每月 5每季度 6每年")
    @Size(min = 7)
    private List<Integer> rulesList;
}
