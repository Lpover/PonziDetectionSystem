package cn.qkl.webserver.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:49
 * @wiki
 */
@Data
public class LoginDTO {
    @ApiModelProperty("手机号")
    @Pattern(regexp = "[0-9]{11}", message = "手机号格式不正确")
    private String phone;

    @ApiModelProperty("密码")
//    @Pattern(regexp = "[A-Za-z0-9]{6,12}", message = "密码格式不正确")
    @NotNull
    private String pwd;
}
