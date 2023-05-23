package cn.qkl.webserver.vo.detail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ContentHistoryVO {
    @ApiModelProperty("单条记录的id")
    private Long id;
    @ApiModelProperty("事件类型，0铸造/发布 5买入")
    private Integer event;
//    @ApiModelProperty("交易价格")
//    private String price;
    @ApiModelProperty("交易来源账户")
    private String from;
    @ApiModelProperty("交易目的账户")
    private String to;
    @ApiModelProperty("持有者头像")
    private String ownerLogo;
    @ApiModelProperty("交易发生时间")
    private Date createTime;
}
