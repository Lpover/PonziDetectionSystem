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
    private String contractAddress;

    @ApiModelProperty("拥有者：数字内容当前的拥有者账户地址")
    private String owner;

    @ApiModelProperty("铸造时间")
    private Date mintTime;

    @ApiModelProperty("平台ID-来源")
    private Long platformId;


    @ApiModelProperty("平台类别： 0 nft  1 web ")
    private Integer platformType;

    @ApiModelProperty("平台名")
    private String platformname;

    @ApiModelProperty("动态风险类别：0静态 5读动态 10写动态")
    private Integer dynamicType;

    @ApiModelProperty("创建时间")
    private Date create_time;

    @ApiModelProperty("更新时间")
    private Date update_time;

    @ApiModelProperty("简介")
    private String description;

    @ApiModelProperty("链的名字")
    private String chainName;

    public static ContentRiskInfoVO transform(ContentRisk contentRisk) {
        ContentRiskInfoVO vo = new ContentRiskInfoVO();
        BeanUtil.copyProperties(contentRisk, vo);
        return vo;
    }
}
