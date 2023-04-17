package cn.qkl.common.framework.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);

    @Autowired
    AuthChecker authChecker;

    /**
     * 否者验证token是否正确
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if (!(handler instanceof HandlerMethod)) {
            if (request.getRequestURI().equals("/favicon.ico")) {
                return false;
            }
            response.setCharacterEncoding("utf-8");
            response.sendError(404, "url : [" + request.getRequestURI() + "], 类型:   [" + request.getMethod() + "] 接口不存在");
            return false;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Class<?> clazz = method.getDeclaringClass();

        Role role;
        // 如果方法上有注解，不考虑类上
        if (method.isAnnotationPresent(Role.class)) {
            role = method.getAnnotation(Role.class);
        } else {
            // 如果方法上没有注解，类上有注解
            if (clazz.isAnnotationPresent(Role.class)) {
                role = clazz.getAnnotation(Role.class);
            } else {
                // 方法和类上都没有注解，跳过token校验
                return true;
            }
        }

        // 如果角色为空，表示不需要认证
        Class<? extends RoleType>[] roles = role.roles();
        if (roles.length == 0) {
            return true;
        }

        // 需要验证token
        TokenBean tokenBean = TokenHandler.checkToken();
        this.authChecker.check(tokenBean, roles);
        TokenHandler.setTokenBean(tokenBean);
        return true;
    }
}