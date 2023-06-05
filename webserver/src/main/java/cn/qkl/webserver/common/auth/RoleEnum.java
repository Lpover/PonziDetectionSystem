package cn.qkl.webserver.common.auth;


import cn.qkl.common.framework.auth.BaseRole;
import cn.qkl.webserver.common.enums.UserRoleEnum;


import java.util.Arrays;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 16:40
 * @wiki
 */
public class RoleEnum {

    public enum RoleTypeEnum {
        USER("USER", UserRoleEnum.USER, "用户"),
        ADMIN("ADMIN", UserRoleEnum.ADMIN, "管理员"),
        ;

        private final String roleType;

        private final UserRoleEnum userRoleEnum;

        public String getRoleType() {
            return roleType;
        }

        public UserRoleEnum getUserRoleEnum() {
            return userRoleEnum;
        }

        RoleTypeEnum(String roleType, UserRoleEnum userRoleEnum, String description) {
            this.roleType = roleType;
            this.userRoleEnum = userRoleEnum;
        }

        public static RoleTypeEnum valueOf(UserRoleEnum userRoleEnum) {
            return Arrays.stream(values()).filter((x) -> x.getUserRoleEnum() == userRoleEnum).findFirst().orElseThrow(() -> new RuntimeException("枚举类型错误，code=[" + userRoleEnum.toString() + "]"));
        }
    }

    //所有用户
    public interface UserBaseRole extends BaseRole {
    }

    //所有管理员
    public interface AdminBaseRole extends BaseRole {
    }

}
