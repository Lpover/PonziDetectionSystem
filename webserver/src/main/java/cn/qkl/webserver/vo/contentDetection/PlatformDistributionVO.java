package cn.qkl.webserver.vo.contentDetection;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.Platform;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class PlatformDistributionVO {
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("平台名字")
    private String named;

    @ApiModelProperty("平台内容数量")
    private Long riskContentNum;

    public static PlatformDistributionVO transform(Platform platformDistribution) {
        PlatformDistributionVO vo = new PlatformDistributionVO();
        BeanUtil.copyProperties(platformDistribution, vo);
        return vo;
    }
}
