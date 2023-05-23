package cn.qkl.webserver.vo.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author sunxiaen
 * @Date 2023/5/19 14:52
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountContentVO {
    @ApiModelProperty("数字内容ID-主键  拼Schema跳转到数字内容详情页")
    private Long contentId;

    @ApiModelProperty("数字内容名称")
    private String contentName;

    @ApiModelProperty("数字内容合约地址")
    private String address;

    @ApiModelProperty("持有人账户")
    private String owner;

    @ApiModelProperty("Mint的时间-Date")
    private Date mintTime;

    @ApiModelProperty("内容链接")
    private String metaUrl;

    @ApiModelProperty("区块链名字")
    private String chainName;

    @ApiModelProperty("前端用一个小图标来进行来源区分 0-数字内容 1-跨链内容")
    private Integer sourceType;

    @ApiModelProperty("标签组合")
    private TagVO tags;
}
