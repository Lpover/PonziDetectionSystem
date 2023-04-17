package cn.qkl.common.framework.exception;


import cn.qkl.common.framework.response.BaseCode;
import lombok.Data;

/**
 * 基础异常类型
 *
 * @author zyl
 */
@Data
public abstract class BaseException extends RuntimeException {

    private final String code;
    private final String msg;

    protected BaseException(BaseCode code) {
        this.code = code.getFullCode();
        this.msg = code.getDefaultMsg();
    }

    protected BaseException(BaseCode code, String extra, Object... args) {
        super(extra);
        this.code = code.getFullCode();
        this.msg = args.length == 0 ? code.getDefaultMsg() : String.format(code.getMsg(), args);
    }

}
