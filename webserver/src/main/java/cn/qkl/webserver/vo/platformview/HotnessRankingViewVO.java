package cn.qkl.webserver.vo.platformview;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.math.BigDecimal;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class HotnessRankingViewVO {
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("平台的ID-外键")
    private Long platformId;

    @ApiModelProperty("平台的名字")
    private String name;

    @ApiModelProperty("平台logo的url")
    private String logo;

    @ApiModelProperty("平台的24小时热度,排序规则")
    private Long hotness24h;

    @ApiModelProperty("24小时的热度变化比例")
    private BigDecimal hotnessChange24h;

    @ApiModelProperty("7天的热度变化比例")
    private BigDecimal hotnessChange7d;

    @ApiModelProperty("30天的热度变化比例")
    private BigDecimal hotnessChange30d;

    @ApiModelProperty("平台风险评级：0表示低 1表示中 2表示高")
    private Integer riskLevel;

    @ApiModelProperty("平台的总热度")
    private Long hotness;
}
