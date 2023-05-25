package cn.qkl.webserver.vo.platform;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.Platform;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
public class PlatformSuperviseListVO {
    @ApiModelProperty("平台主键id")
    private Long id;
    @ApiModelProperty("平台名称")
    private String name;
    @ApiModelProperty("平台url")
    private String url;
    @ApiModelProperty("平台logo")
    private String logo;
    @ApiModelProperty("平台位置")
    private Integer location;
    @ApiModelProperty("风险内容数量")
    private Integer riskContentNum;
    @ApiModelProperty("24小时活跃度")
    private Integer activation;
    @ApiModelProperty("风险评级：1低风险 2中风险 3高风险")
    private Integer riskLevel;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    public static PlatformSuperviseListVO transform(Platform platform) {
        PlatformSuperviseListVO vo = new PlatformSuperviseListVO();
        BeanUtil.copyProperties(platform, vo);
        return vo;
    }
}
