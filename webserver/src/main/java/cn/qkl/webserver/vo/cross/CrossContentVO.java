package cn.qkl.webserver.vo.cross;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CrossContentVO {
    @ApiModelProperty("数字内容主键id")
    private Long id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("缩略图")
    private String metaUrl;
    @ApiModelProperty("源链名称")
    private String chainName;
    @ApiModelProperty("源链合约地址")
    private String address;
    @ApiModelProperty("源链hash")
    private String hash;
    @ApiModelProperty("源链tokenId")
    private String tokenId;
    @ApiModelProperty("源链用户地址")
    private String accountAddress;
    @ApiModelProperty("源链开始时间")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @ApiModelProperty("目标链名称")
    private String dstChainName;
    @ApiModelProperty("目标链合约地址")
    private String dstAddress;
    @ApiModelProperty("目标链hash")
    private String dstHash;
    @ApiModelProperty("目标链tokenId")
    private String dstTokenId;
    @ApiModelProperty("目标链用户地址")
    private String dstAccountAddress;
    @ApiModelProperty("目标链结束时间")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @ApiModelProperty("跨链桥： 1 Zkbridge 2 protalTokenBridge")
    private Integer bridge;
    @ApiModelProperty("动态数字内容类别：0静态 1动态")
    private Integer dynamicType;
    @ApiModelProperty("风险评级：1低风险 2中风险 3高风险")
    private Integer riskLevel;

    @ApiModelProperty("创建时间")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
