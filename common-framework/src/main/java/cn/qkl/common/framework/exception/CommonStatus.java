package cn.qkl.common.framework.exception;


import cn.qkl.common.framework.response.BaseCode;

/**
 * 公共异常
 *
 * @author zyl
 */
public enum CommonStatus implements BaseCode {
    OK("200", "ok", "ok"),
    CLIENT_ERROR("400", "%s", "客户端异常"),
    UNAUTHORIZED("401", "%s", "未授权"),
    SERVER_ERROR("500", "%s", "服务器异常"),
    ;

    // 全局状态不带模块编号
    private static final String PREFIX = "";
    private final String code;
    private final String msg;

    private final String defaultMsg;

    CommonStatus(String code, String msg, String defaultMsg) {
        this.code = code;
        this.msg = msg;
        this.defaultMsg = defaultMsg;
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

    @Override
    public String getDefaultMsg() {
        return defaultMsg;
    }
}
