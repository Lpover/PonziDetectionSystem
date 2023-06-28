package cn.qkl.cusumer.common.auth;


import cn.qkl.common.framework.auth.BaseRole;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 16:40
 * @wiki
 */
public class RoleEnum {

    public enum RoleTypeEnum {
        USER("USER", "用户"),
        ADMIN("ADMIN", "管理员"),
        ;

        private final String roleType;

        public String getRoleType() {
            return roleType;
        }

        RoleTypeEnum(String roleType, String description) {
            this.roleType = roleType;
        }
    }

    //所有用户
    public interface UserBaseRole extends BaseRole {
    }

    //所有管理员
    public interface AdminBaseRole extends BaseRole {
    }

}
