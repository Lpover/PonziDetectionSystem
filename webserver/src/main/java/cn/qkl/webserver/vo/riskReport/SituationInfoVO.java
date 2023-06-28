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
    private Integer categoryDyN;

    @ApiModelProperty("动态数字内容百分比,静态")
    private Integer categoryStatic;

    @ApiModelProperty("动态数字内容百分比,其它")
    private Integer categoryOth;

    @ApiModelProperty("新增低风险账户数量")
    private Integer lowAccountNum;

    @ApiModelProperty("热度第一的NFT名字")
    private String nftName;

    @ApiModelProperty("热度第一的NFT平台，感知到风险数字内容的数量")
    private Integer nftNum;

    @ApiModelProperty("热度第一的WEB3平台名字")
    private String web3Name;

    @ApiModelProperty("热度第一的WEB3平台，感知到风险数字内容的数量")
    private Integer web3Num;

    @ApiModelProperty("高风险数字内容数量")
    private Integer highContentNum;

    @ApiModelProperty("中风险数字内容数量")
    private Integer midContentNum;

    @ApiModelProperty("低风险数字内容数量")
    private Integer lowContentNum;

    @ApiModelProperty("新增动态数字内容数量")
    private Integer dynNum;

    @ApiModelProperty("监测平台的次数")
    private Integer monitorNum;

    @ApiModelProperty("高风险平台的名字")
    private String highRiskPlat;

    @ApiModelProperty("中风险平台的名字")
    private String midRiskPlat;

    @ApiModelProperty("低风险平台的名字")
    private String lowRiskPlat;

    @ApiModelProperty("高风险平台的高风险数字内容占比")
    private BigDecimal highRiskPlatPer;

    @ApiModelProperty("中风险平台的高风险数字内容占比")
    private BigDecimal midRiskPlatPer;

    @ApiModelProperty("低风险平台的高风险数字内容占比")
    private BigDecimal lowRiskPlatPer;

    @ApiModelProperty("感知到最多风险的平台的名字")
    private String highNamePlat;

    @ApiModelProperty("感知到最多风险的平台的数量")
    private Integer highNumPlat;

    @ApiModelProperty("报表创建时间")
    private Date createTime;

    @ApiModelProperty("每日风险类别数据")
    private List<RiskCategoryVO> riskCategoryVOList;

    @ApiModelProperty("每日平台数据")
    private List<PlatformReportVO> dailyPlatformList;

    public static SituationInfoVO transform(RiskReport report, List<RiskCategoryVO> riskCategoryVOList, List<PlatformReportVO> platformReportVOList) {
        SituationInfoVO vo = new SituationInfoVO();
        BeanUtil.copyProperties(report, vo);
        vo.setRiskCategoryVOList(riskCategoryVOList);
        vo.setDailyPlatformList(platformReportVOList);
        return vo;
    }
}
