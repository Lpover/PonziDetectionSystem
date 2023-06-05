package cn.qkl.webserver.vo.user;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class UserInfoVO {
    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("角色")
    private Integer roleType;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("头像")
    private String photo;

    @ApiModelProperty("性别")
    private Byte sex;

    @ApiModelProperty("简介")
    private String description;

    @ApiModelProperty("注册时间")
    private Long created;

    @ApiModelProperty("最后登录时间")
    private Long lastLogin;

    public static UserInfoVO transform(User user) {
        UserInfoVO vo = new UserInfoVO();
        BeanUtil.copyProperties(user, vo);
        return vo;
    }
}
