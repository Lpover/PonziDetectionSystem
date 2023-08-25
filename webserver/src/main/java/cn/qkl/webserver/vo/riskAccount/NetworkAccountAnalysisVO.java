package cn.qkl.webserver.vo.riskAccount;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author sunxiaen
 * @Date 2023/8/23 15:40
 **/

@Data
public class NetworkAccountAnalysisVO {
    @ApiModelProperty("賬戶主鍵ID")
    private Long accountId;

    @ApiModelProperty("账户地址")
    private String accountAddress;

    @ApiModelProperty("账户所在区块链ID")
    private Long chainId;

    @ApiModelProperty("账户所在区块链名字（需要交表查）")
    private String chainName;

    @ApiModelProperty("行为特征组合，逗号点开：行为特征枚举，0 无，1-散进整出 2-频繁转入 3-频繁转出 4-高频交易 5-非常规交易 6-分散转出")
    private String actionFeatures;

    @ApiModelProperty("内容标签组合，逗号点开：内容标签枚举，0无，1政治，2恐怖，3暴力，4低俗，5犯罪，6赌博，7毒品'")
    private String contentTag;

    @ApiModelProperty("该账户发布数字内容数量")
    private Integer releaseNum;

    @ApiModelProperty("账户风险等级 0-低风险 1-中风险 2-高风险")
    private Integer riskLevel;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("关联风险交易数-转入")
    private Integer riskTxNumIn;

    @ApiModelProperty("关联风险交易数-转出")
    private Integer riskTxNumOut;

    @ApiModelProperty("关联风险内容数")
    private Integer riskContentNum;

    @ApiModelProperty("最近交易时间")
    private Date recentTxTime;
}
