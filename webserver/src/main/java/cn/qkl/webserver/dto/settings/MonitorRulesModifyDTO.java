package cn.qkl.webserver.dto.settings;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param
 * @return
 */
@Data
public class MonitorRulesModifyDTO {
    @ApiModelProperty("设置对象的id")
    private Long id;

    @ApiModelProperty("设置的监测规则，0不监测 2每天 3每周 4每月 5每季度 6每年")
    private Integer rule;
}
