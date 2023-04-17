package cn.qkl.common.framework.auth;


import cn.qkl.common.framework.exception.UnauthorizedException;

import java.util.Arrays;

public interface AuthChecker {

    Object getUser(final TokenBean tokenBean);

    Class<? extends RoleType> getRole(Object user, final TokenBean tokenBean);

    void customCheck(Object user, final TokenBean tokenBean);

    default void check(final TokenBean tokenBean, Class<? extends RoleType>[] roles) {
        Object user = getUser(tokenBean);
        Class<? extends RoleType> roleClazz = getRole(user, tokenBean);
        if (Arrays.stream(roles).noneMatch(role -> role.isAssignableFrom(roleClazz))) {
            throw new UnauthorizedException("Unauthorized");
        }
        customCheck(user, tokenBean);
    }
}
