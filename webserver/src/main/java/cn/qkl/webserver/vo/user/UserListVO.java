package cn.qkl.webserver.vo.user;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.common.repository.model.User;
import cn.qkl.webserver.vo.platform.PlatformListVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserListVO {
    @ApiModelProperty("用户主键id")
    private Long id;

    @ApiModelProperty("用户手机号")
    private String phone;

    @ApiModelProperty("用户角色 0管理员 5 用户")
    private int role;

    @ApiModelProperty("用户名字")
    private String name;
    public static UserListVO transform(User user) {
        UserListVO vo = new UserListVO();
        BeanUtil.copyProperties(user, vo);
        return vo;
    }
}
