package cn.qkl.common.framework.exception;


import cn.qkl.common.framework.response.BaseCode;

/**
 * 业务异常，如账号密码错误等
 *
 * @author zyl
 */
public class BusinessException extends BaseException {

    public BusinessException(BaseCode code) {
        super(code);
    }

    public BusinessException(BaseCode code, Object... args) {
        super(code, null, args);
    }
}