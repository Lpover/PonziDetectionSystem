package cn.qkl.consumer.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:49
 * @wiki
 */
@Data
public class EmailRegisterDTO {
    @ApiModelProperty("邮箱")
    @Email
    private String email;

    @ApiModelProperty("密码")
    @NotNull
    private String password;

    @ApiModelProperty("验证码")
    @NotNull
    private String emailCode;
}
