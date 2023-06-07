package cn.qkl.webserver.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class ModifyPwdDTO {
    @ApiModelProperty("用户id")
    @NotNull
    private Long id;
    @ApiModelProperty("密码")
    @Pattern(regexp = "[A-Za-z0-9]{6,12}", message = "密码格式不正确")
    @NotNull
    private String pwd;
}
