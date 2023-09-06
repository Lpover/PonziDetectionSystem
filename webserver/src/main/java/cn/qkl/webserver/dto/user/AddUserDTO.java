package cn.qkl.webserver.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddUserDTO {
    @ApiModelProperty("用户手机号")
    @Pattern(regexp = "[0-9]{11}", message = "手机号格式不正确")
    @NotNull
    private String phone;
    @ApiModelProperty("用户密码")
    @Pattern(regexp = "[A-Za-z0-9]{6,12}", message = "密码格式不正确")
    @NotNull
    private String pwd;

    @ApiModelProperty("用户名字")
    @NotNull
    private String name;
}
