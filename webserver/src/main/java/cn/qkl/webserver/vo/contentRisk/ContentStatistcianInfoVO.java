package cn.qkl.webserver.vo.contentRisk;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.ContentRisk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class ContentStatistcianInfoVO {

    @ApiModelProperty("风险内容数量")
    private Long riskNum;

    @ApiModelProperty("风险账户数量")
    private Long riskAccount;

    @ApiModelProperty("风险平台数量")
    private Long riskPlatform;

    @ApiModelProperty("风险取证数量")
    private Long riskEvidence;

}
