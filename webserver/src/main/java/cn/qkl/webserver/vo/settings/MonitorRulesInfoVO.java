package cn.qkl.webserver.vo.settings;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @param
 * @return
 */

public class MonitorRulesInfoVO {
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("监测类别：0 动态内容；5 高风险账户；6 中风险账户；7 低风险账户；10 高风险平台 11 中风险平台 12 低风险平台")
    private Integer type;

    @ApiModelProperty("监测频率：0不监测 2每天 3每周 4每月 5每季度 6每年")
    private Integer rule;

    @ApiModelProperty("上次监测时间")
    private Date lastMonitor;
}
