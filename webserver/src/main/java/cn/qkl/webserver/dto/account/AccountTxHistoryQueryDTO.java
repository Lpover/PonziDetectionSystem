package cn.qkl.webserver.dto.account;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author sunxiaen
 * @Date 2023/5/19 14:35
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountTxHistoryQueryDTO extends PageDTO {
    @ApiModelProperty("账户ID")
    private Long accountId;
}
