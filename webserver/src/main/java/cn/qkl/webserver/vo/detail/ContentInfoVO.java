package cn.qkl.webserver.vo.detail;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.Content;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ContentInfoVO {
    @ApiModelProperty("数字内容项目名称")
    private String name;
    @ApiModelProperty("合约地址")
    private String address;
    @ApiModelProperty("Token ID")
    private Integer tokenid;
    @ApiModelProperty("加密货币价格")
    private String cryptoPrice;
    @ApiModelProperty("法定货币价格")
    private String currencyPrice;
    @ApiModelProperty("创作者")
    private String creator;
    @ApiModelProperty("平台名称")
    private String named;
    @ApiModelProperty("认证标准")
    private String standard;
    @ApiModelProperty("所在链名称")
    private String chainName;
    @ApiModelProperty("上架时间")
    private String listingTime;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("元数据(图片/视频/音频)url")
    private String metaUrl;

    public static ContentInfoVO transform(Content content) {
        ContentInfoVO vo = new ContentInfoVO();
        BeanUtil.copyProperties(content, vo);
        return vo;
    }
}
