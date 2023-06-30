package cn.qkl.webserver.vo.riskReport;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.RiskReport;
import cn.qkl.webserver.vo.contentRiskStatictics.RiskCategoryVO;
import cn.qkl.webserver.vo.riskContentStatictics.PlatformReportVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class SituationInfoVO {
    @ApiModelProperty("储存量最大的平台名字")
    private String platformName;

    @ApiModelProperty("载体形式百分比,图片")
    private Integer carrierPic;

    @ApiModelProperty("载体形式百分比,视频")
    private Integer carrierVie;

    @ApiModelProperty("载体形式百分比,其它")
    private Integer carrierOth;

    @ApiModelProperty("动态数字内容百分比,动态")
    private Integer categoryDyn;

    @ApiModelProperty("动态数字内容百分比,静态")
    private Integer categorySta;

    @ApiModelProperty("动态数字内容百分比,其它")
    private Integer categoryOth;

    @ApiModelProperty("低风险交易变化百分比")
    private Integer lowTxRatio;

    @ApiModelProperty("中风险交易变化百分比")
    private Integer midTxRatio;

    @ApiModelProperty("高风险交易变化百分比")
    private Integer highTxRatio;

    @ApiModelProperty("风险类别词最多的名字")
    private String riskWordMostName;

    @ApiModelProperty("风险类别词最多的数量")
    private Integer riskWordMostNum;

    @ApiModelProperty("风险类别词最少的名字")
    private String riskWordLeastName;

    @ApiModelProperty("风险类别词最少的数量")
    private Integer riskWordLeastNum;

    @ApiModelProperty("风险数字内容数量变化趋势")
    private Integer contentNumRatio;

    @ApiModelProperty("内容平台最热门的的5个话题")
    private String top5TopicsContent;

    @ApiModelProperty("社交平台最热门的的5个话题")
    private String top5TopicsSocial;

    @ApiModelProperty("最热门的3个话题词")
    private String top3Words;

    @ApiModelProperty("正面情绪的比例")
    private Integer positive_ratio;

    @ApiModelProperty("负面情绪的比例")
    private Integer negative_ratio;

    @ApiModelProperty("热度排名第一的NFT平台名字")
    private String nftPlatformName;

    @ApiModelProperty("热度排名第一的NFT平台24h热度")
    private Long nftPlatformHotness;

    @ApiModelProperty("热度排名第一的NFT平台7D变化百分比")
    private BigDecimal nftPlatformHotnessChange;

    @ApiModelProperty("热度排名第一的WEB3平台名字")
    private String web3PlatformName;

    @ApiModelProperty("热度排名第一的WEB3平台24h热度")
    private Long web3PlatformHotness;

    @ApiModelProperty("热度排名第一的WEB3平台7D变化百分比")
    private BigDecimal web3PlatformHotnessChange;

    @ApiModelProperty("风险指数最高的平台名字")
    private String highRiskName;

    @ApiModelProperty("风险指数最高的平台风险指数")
    private Integer highRiskIndex;

    @ApiModelProperty("风险指数最低的平台名字")
    private String lowRiskName;

    @ApiModelProperty("风险指数最低的平台风险指数")
    private Integer lowRiskIndex;

    @ApiModelProperty("高风险平台监控个数")
    private Integer monitorNumHigh;

    @ApiModelProperty("中风险平台监控个数")
    private Integer monitorNumMid;

    @ApiModelProperty("低风险平台监控个数")
    private Integer monitorNumLow;

    @ApiModelProperty("高风险平台中热度最高平台名字")
    private String highPlatName;

    @ApiModelProperty("中风险平台中热度最高平台名字")
    private String midPlatName;

    @ApiModelProperty("低风险平台中热度最高平台名字")
    private String lowPlatName;

    @ApiModelProperty("高风险平台高风险数字内容占比")
    private Integer highPlatRatio;

    @ApiModelProperty("中风险平台高风险数字内容占比")
    private Integer midPlatRatio;

    @ApiModelProperty("低风险平台高风险数字内容占比")
    private Integer lowPlatRatio;

    @ApiModelProperty("预警次数")
    private Integer warningNum;

}
