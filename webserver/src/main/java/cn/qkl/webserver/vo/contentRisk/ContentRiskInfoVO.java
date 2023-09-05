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
public class ContentRiskInfoVO {
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("数字内容项目名称")
    private String name;

    @ApiModelProperty("NFT 元数据（图片/视频/音频）的url")
    private String metaUrl;

    @ApiModelProperty("合约地址")
    private String address;

    @ApiModelProperty("拥有者：数字内容当前的拥有者账户地址")
    private String owner;

    @ApiModelProperty("铸造时间")
    private Date mintTime;

    @ApiModelProperty("平台类别： 0 nft  1 web ")
    private Integer platformType;

    @ApiModelProperty("平台名")
    private String platformname;

    @ApiModelProperty("动态风险类别：0静态 5读动态 10写动态")
    private Integer dynamicType;

    @ApiModelProperty("简介")
    private String description;

    @ApiModelProperty("链的名字")
    private String chainName;

    @ApiModelProperty("风险评级：0无风险 1低风险 2中风险 3高风险")
    private Integer riskLevel;

    @ApiModelProperty("是否已固证：0未固证 1取证中 2已固证")
    private Integer evidencStatus;

    public static ContentRiskInfoVO transform(ContentRisk contentRisk) {
        ContentRiskInfoVO vo = new ContentRiskInfoVO();
        BeanUtil.copyProperties(contentRisk, vo);
        return vo;
    }
}
