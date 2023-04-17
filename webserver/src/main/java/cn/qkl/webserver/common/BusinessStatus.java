package cn.qkl.webserver.common;

import cn.qkl.common.framework.response.BaseCode;

/**
 * 全局业务异常
 *
 * @author zyl
 */
public enum BusinessStatus implements BaseCode {
    /**
     * 0xxx 用户相关
     **/
    User_Not_EXISTS("0001", "用户不存在"),
    EMAIL_OR_PASSWORD_IS_WRONG("0002", "账号或密码错误"),

    // 2xxx common
    STATUS_ERROR("2001", "Status error"),
    ACCOUNT_EXCEPTION("2002", "Account exception"),
    LOGIN_EXCEPTION("2003", "The account has been forced offline or multi-login"),
    UNAUTHORIZED("2004", "Unauthorized"),

    ;
    private static final String PREFIX = "USER";
    private final String code;
    private final String msg;

    BusinessStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getModulePrefix() {
        return PREFIX;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
