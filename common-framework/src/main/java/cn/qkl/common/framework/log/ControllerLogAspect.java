package cn.qkl.common.framework.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 该类主要做开发调试使用
 *
 * @author zyl
 */
@Component
@Aspect
@Slf4j
public class ControllerLogAspect {
    private final JsonMapper jsonMapper = new JsonMapper();
    @Autowired
    HttpServletRequest request;

    /**
     * 切面点
     */
    @Pointcut("execution(* cn.bylh..*.controller..*.*(..))")
    private void pointcut() {
    }

    /**
     * 前置通知，方法调用前被调用
     *
     * @param joinPoint 切面点表达式
     */
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames(); // 参数名
        String methodName = joinPoint.getSignature().getName();
        log.debug("【request-start】:[url:{}, type:{}, method:{}]", request.getRequestURI(),
                request.getMethod(), methodName);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < args.length; i++) {
            sb.append(argNames[i]).append(':').append(args[i]).append(", ");
        }
        sb.append(']');
        if (sb.length() >= 3) {
            sb.delete(sb.length() - 3, sb.length() - 1);
        }
        log.debug("\n=====>{} : {}", methodName, sb);
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) throws JsonProcessingException {
        String methodName = joinPoint.getSignature().getName();
        if (result instanceof HttpEntity) {
            result = ((HttpEntity<?>) result).getBody();
        }
        String jsonStr = this.jsonMapper.writeValueAsString(result);
        log.debug("\n<====={}", methodName);
    }
}
