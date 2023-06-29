package cn.qkl.webserver.dto.settings;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class MonitorRulesModifyDTO {
    @ApiModelProperty("设置对象的id")
    @NotNull
    private Long id;

    @ApiModelProperty("设置的监测规则，0不监测 2每天 3每周 4每月 5每季度 6每年")
    @NotNull
    @Range(min = 0, max = 6)
    private Integer rule;
}
