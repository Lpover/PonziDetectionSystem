package cn.qkl.common.framework.auth;

import java.lang.annotation.*;

/**
 * 该注解表示接口需要token验证，当roles为空时表示不需要校验
 *
 * @author zyl
 */
@Retention(RetentionPolicy.RUNTIME)
// 表示该注解可在类或方法上使用
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Inherited
public @interface Role {
    // 默认空数组，表示不需要登录
    Class<? extends RoleType>[] roles() default {};
}
