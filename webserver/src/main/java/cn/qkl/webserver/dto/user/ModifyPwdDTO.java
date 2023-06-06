package cn.qkl.webserver.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class ModifyPwdDTO {
    @ApiModelProperty("用户id")
    @NotNull
    private Long id;
    @ApiModelProperty("密码")
    @NotNull
    private String pwd;
}
