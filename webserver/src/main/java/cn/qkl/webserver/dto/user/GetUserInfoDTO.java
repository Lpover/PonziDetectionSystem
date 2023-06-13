package cn.qkl.webserver.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class GetUserInfoDTO {
    @ApiModelProperty("用户id")
    @NotNull
    private Long id;
}
