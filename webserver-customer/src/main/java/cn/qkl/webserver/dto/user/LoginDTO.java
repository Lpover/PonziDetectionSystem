package cn.qkl.webserver.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:49
 * @wiki
 */
@Data
public class LoginDTO {
    @ApiModelProperty("账号")
    private String userNum;

    @ApiModelProperty("密码")
    private String userPwd;
}
