package cn.qkl.common.framework.response;

import cn.qkl.common.framework.exception.CommonStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class BaseResult<T> implements Serializable {
    public static boolean isShowExceptionDetail = false;
    private static final BaseResult<Void> OK = new BaseResult<>(CommonStatus.OK);
    private String code;
    private String message;
    private T data;


    private BaseResult(BaseCode code) {
        this(code.getFullCode(), code.getDefaultMsg(), null);
    }

    private BaseResult(BaseCode code, T data) {
        this(code.getFullCode(), code.getDefaultMsg(), data);
    }

    private BaseResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResult<Void> ok() {
        return BaseResult.OK;
    }

    public static <T> BaseResult<T> ok(T data) {
        return new BaseResult<>(CommonStatus.OK, data);
    }

    public static BaseResult<String> error(BaseCode code) {
        return new BaseResult<>(code);
    }

    public static BaseResult<String> error(BaseCode code, String extra) {
        if (isShowExceptionDetail) {
            return new BaseResult<>(code, extra);
        }
        return new BaseResult<>(code);
    }

    public static BaseResult<String> error(String code, String message, String extra) {
        if (isShowExceptionDetail) {
            return new BaseResult<>(code, message, extra);
        }
        return new BaseResult<>(code, message, null);
    }
}
