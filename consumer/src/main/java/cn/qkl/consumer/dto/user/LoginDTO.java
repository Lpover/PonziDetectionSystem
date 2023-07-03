package cn.qkl.consumer.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
