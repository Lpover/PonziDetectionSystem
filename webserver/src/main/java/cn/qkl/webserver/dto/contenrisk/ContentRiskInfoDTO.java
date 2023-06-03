package cn.qkl.webserver.dto.contenrisk;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.List;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:49
 * @wiki
 */
@Data
public class ContentRiskInfoDTO extends PageDTO {
    @ApiModelProperty("平台来源,不传-全部 1-NFT, 2-WEB3")
    private Integer platformType;

    @ApiModelProperty("风险评级：不传-全部 1低风险 2中风险 3高风险")
    private Integer riskLevelList;

    @ApiModelProperty("时间范围：不传-全部 1-24H 2-7DAY")
    private Integer timeSet;

    @ApiModelProperty("事件类型：1-发布 2-转移 3-买卖，,不传表示都选")
    private List<Integer> thingType;

    @ApiModelProperty("风险标签: 0 无风险 1 政治风险,2, '恐怖风险',3, '暴力风险 ,4, '低俗风险,5, '犯罪风险,6, '赌博风险',7, '毒品风险',不传表示都选")
    private Long contentRisk;

    @ApiModelProperty("风险属性:1 可嵌套，2可编程，不传表示都选")
    private List<Integer> riskType;

    @ApiModelProperty("关键词")
    private String keyWord;
}
