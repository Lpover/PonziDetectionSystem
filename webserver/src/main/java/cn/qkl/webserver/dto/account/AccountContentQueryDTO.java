package cn.qkl.webserver.dto.account;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @Author sunxiaen
 * @Date 2023/5/19 14:35
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountContentQueryDTO extends PageDTO {
    @ApiModelProperty("账户ID")
    @NotNull
    private Long accountId;

    @ApiModelProperty("0-该账户发布的数字内容 1-该账户关联的数字内容")
    @Range(min = 0, max = 1)
    private Integer type;
}
