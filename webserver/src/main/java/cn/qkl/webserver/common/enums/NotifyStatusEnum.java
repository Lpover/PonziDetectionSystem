package cn.qkl.webserver.common.enums;

public enum NotifyStatusEnum {
    PREPARING(0, "待发送"),
    OK(1, "发送成功"),
    EXCEPTION(2, "发送异常"),
    ;

    private final int code;

    public int getCode() {
        return code;
    }

    NotifyStatusEnum(int code, String description) {
        this.code = code;
    }
}
