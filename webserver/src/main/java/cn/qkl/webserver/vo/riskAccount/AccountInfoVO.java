package cn.qkl.webserver.vo.riskAccount;

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
public class AccountInfoVO {
    @ApiModelProperty("主键uuid，不要手动设置")
    private Long id;

    @ApiModelProperty("外键，账户主键Id")
    private Long accountId;

    @ApiModelProperty("快照 账户风险等级 0-低风险 1-中风险 2-高风险")
    private Integer riskLevel;

    @ApiModelProperty("快照 账户关联数字内容数量")
    private Integer relatedNum;

    @ApiModelProperty("快照 账户发布数字内容数量")
    private Integer releaseNum;

    @ApiModelProperty("数据库表更新时间")
    private Date updateTime;

    @ApiModelProperty("账户地址")
    private String accountAddress;
}
