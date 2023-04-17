package cn.qkl.common.framework.exception;


import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.util.ServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 * @author zyl
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    String getMetaInfo() {
        HttpServletRequest request = ServletUtil.getRequest();
        return "url : [" + request.getRequestURI() + "], 类型: [" + request.getMethod() + "]";
    }

    String messageWrapper(String message) {
        return getMetaInfo() + ", " + message;
    }

    /**
     * 包装类参数校验异常处理， code=400
     *
     * @param e 异常
     * @return 异常说明信息
     */
    @ExceptionHandler({
            BindException.class,
            MethodArgumentNotValidException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class,
            ConstraintViolationException.class,
            HttpMessageNotReadableException.class,
            HttpMediaTypeNotSupportedException.class
    })
    public BaseResult<?> handleParamsException(Exception e) {
        String message = "";
        BindingResult bindResult = null;
        if (e instanceof MethodArgumentNotValidException) {
            bindResult = ((MethodArgumentNotValidException) e).getBindingResult();
        } else if (e instanceof BindException) {
            bindResult = ((BindException) e).getBindingResult();
        }
        if (bindResult == null) {
            message += e.getMessage();
        } else {
            message += bindResult.getFieldErrors().stream()
                    .filter(x -> x.getDefaultMessage() != null)
                    .map(x -> x.getDefaultMessage().contains(x.getField()) ? x.getDefaultMessage() : x.getField() + ": " + x.getDefaultMessage())
                    .collect(Collectors.joining(";"));
        }
        GlobalExceptionCallback.callback(new ClientException(message), ServletUtil.getRequest());
        message = messageWrapper(e.getMessage());
        log.warn("接口参数校验错误:{}", message);
        return BaseResult.error(CommonStatus.CLIENT_ERROR, message);
    }


    @ExceptionHandler(BusinessException.class)
    public BaseResult<?> businessExceptionHandle(BusinessException e) {
        GlobalExceptionCallback.callback(e, ServletUtil.getRequest());
        log.debug("{}\n{}:{}\n\tat {}", messageWrapper(e.getMsg()), e.getClass().getName(), e.getMsg(), e.getStackTrace()[0].toString());
        return BaseResult.error(e.getCode(), e.getMsg(), e.getMessage());
    }

    @ExceptionHandler(BaseException.class)
    public BaseResult<?> baseExceptionHandle(BaseException e) {
        GlobalExceptionCallback.callback(e, ServletUtil.getRequest());
        log.warn("{}\n{}:{}\n\tat {}", messageWrapper(e.getMessage()), e.getClass().getName(), e.getMessage(), e.getStackTrace()[0].toString());
        return BaseResult.error(e.getCode(), e.getMsg(), e.getMessage());
    }

    /**
     * 其他未知异常， code=500, 返回服务器异常
     *
     * @param e 未知Exception
     */
    @ExceptionHandler(Exception.class)
    public BaseResult<?> exceptionHandle(Exception e) {
        GlobalExceptionCallback.callback(e, ServletUtil.getRequest());
        String message = e.getMessage();
        if (e instanceof UndeclaredThrowableException) {
            message = ((UndeclaredThrowableException) e).getUndeclaredThrowable().getMessage();
        }
        message = messageWrapper(message);
        log.error(message, e);
        return BaseResult.error(CommonStatus.SERVER_ERROR, message);
    }
}
