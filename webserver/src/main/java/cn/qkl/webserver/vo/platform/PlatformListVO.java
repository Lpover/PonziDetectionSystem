package cn.qkl.webserver.vo.platform;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.Algorithm;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.webserver.vo.algorithm.AlgorithmVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
public class PlatformListVO {
    @ApiModelProperty("平台主键id")
    private Long id;
    @ApiModelProperty("平台名称")
    private String name;
    @ApiModelProperty("平台url")
    private String url;
    @ApiModelProperty("平台logo")
    private String logo;
    @ApiModelProperty("是否监管 0表示不监管 1表示监管")
    private Integer monitor;
    @ApiModelProperty("监测频率")
    private Integer frequency;
    @ApiModelProperty("风险评级：1低风险 2中风险 3高风险")
    private Integer riskLevel;
    @ApiModelProperty("添加时间")
    private Date updateTime;
    @ApiModelProperty("上次抓取时间")
    private Date createTime;
    public static PlatformListVO transform(Platform platform) {
        PlatformListVO vo = new PlatformListVO();
        BeanUtil.copyProperties(platform, vo);
        return vo;
    }
}
