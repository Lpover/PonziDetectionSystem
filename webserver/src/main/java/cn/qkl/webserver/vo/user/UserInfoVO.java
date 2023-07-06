package cn.qkl.webserver.vo.user;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class UserInfoVO {
    @ApiModelProperty("用户主键id")
    private Long id;

    @ApiModelProperty("用户手机号")
    private String phone;

    @ApiModelProperty("用户角色 0管理员 5 用户")
    private int role;

    @ApiModelProperty("用户名字")
    private String name;

    public static UserInfoVO transform(User user) {
        UserInfoVO vo = new UserInfoVO();
        BeanUtil.copyProperties(user, vo);
        return vo;
    }
}
