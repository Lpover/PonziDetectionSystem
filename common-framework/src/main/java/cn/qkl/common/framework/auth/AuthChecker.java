package cn.qkl.common.framework.auth;


import cn.qkl.common.framework.exception.UnauthorizedException;

import java.util.Arrays;

public interface AuthChecker {

    Object getUser(final TokenBean tokenBean);

    Class<? extends BaseRole> getRole(Object user, final TokenBean tokenBean);

    void customCheck(Object user, final TokenBean tokenBean);

    default void check(final TokenBean tokenBean, Class<? extends BaseRole>[] roles) {
        Object user = getUser(tokenBean);
        Class<? extends BaseRole> roleClazz = getRole(user, tokenBean);
        if (Arrays.stream(roles).noneMatch(role -> role.isAssignableFrom(roleClazz))) {
            throw new UnauthorizedException("未授权");
        }
        customCheck(user, tokenBean);
    }
}
