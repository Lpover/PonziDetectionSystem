package cn.qkl.webserver.common.log;

/**
 * @Author sunxiaen
 * @Date 2023/12/19 14:35
 **/

import cn.qkl.common.framework.auth.TokenHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@ControllerAdvice
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private final ObjectMapper objectMapper;

    private ApiRecorder apiRecorder;

    public ApiResponseBodyAdvice(ObjectMapper objectMapper, ApiRecorder apiRecorder) {
        this.objectMapper = objectMapper;
        this.apiRecorder = apiRecorder;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // Check if the controller method or class is annotated with your specific annotation
        return (returnType.getMethod().isAnnotationPresent(ApiRecord.class)
                || returnType.getContainingClass().isAnnotationPresent(ApiRecord.class));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // Obtain the HttpServletRequest from the ServerHttpRequest
        HttpServletRequest httpServletRequest = ((ServletServerHttpRequest) request).getServletRequest();
        Method method = returnType.getMethod();
        Class<?> clazz = null;
        if (method != null) {
            clazz = method.getDeclaringClass();
        }

        ApiRecord apiRecord = null;
        // 如果方法上有注解，不考虑类上
        if (method != null && method.isAnnotationPresent(ApiRecord.class)) {
            apiRecord = method.getAnnotation(ApiRecord.class);
        } else if (clazz != null && clazz.isAnnotationPresent(ApiRecord.class)) {
            apiRecord = clazz.getAnnotation(ApiRecord.class);
        } else {
            //
            return body;
        }

        String apiRouter = httpServletRequest.getRequestURI();
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        String apiName = ApiRecordConstants.PLACE_HOLDER_API_OPERATION;
        if (apiOperation != null) {
            apiName = apiOperation.value();
        }
        String clientIp = null;
        String X_REAL_IP = httpServletRequest.getHeader(ApiRecordConstants.X_REAL_IP);
        Long userId = TokenHandler.getUserId();

        if (X_REAL_IP == null) {
            //直接获取 真实ip
            clientIp = httpServletRequest.getRemoteAddr();
        } else {
            //借助xff 获取真实ip
            clientIp = X_REAL_IP;
        }

        if (apiRecord.apiType() == LoginApiType.class) {
            String responseBody = null;
            // Check if the body is a JSON object
            if (MediaType.APPLICATION_JSON.isCompatibleWith(selectedContentType)) {
                try {
                    responseBody = objectMapper.writeValueAsString(body);
//                    System.out.println("JSON Response Body: " + responseBody);
                    // You can store or log the JSON response body based on your requirements.
                } catch (Exception e) {
                    // Handle the exception, e.g., log an error
                    e.printStackTrace();
                }
            }
            apiRecorder.doLoginLog(userId, clientIp, apiName, apiRouter, responseBody);
        } else if (apiRecord.apiType() == OperationApiType.class) {
            apiRecorder.doOperationLog(userId, clientIp, apiName, apiRouter);
        }
        return body;
    }
}
