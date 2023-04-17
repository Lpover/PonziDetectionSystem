package cn.qkl.common.framework.auth;

import cn.hutool.core.util.IdUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenBean {

    private long roleId;
    // 用户来源
    private String roleType;
    // 随机值
    private String uuid;

//    private RoleEnum userRole;

    public TokenBean(long roleId) {
        this.roleId = roleId;
    }

    public TokenBean withRoleType(String roleType) {
        this.setRoleType(roleType);
        return this;
    }

    public TokenBean withUuid() {
        this.setUuid(IdUtil.simpleUUID());
        return this;
    }
}
