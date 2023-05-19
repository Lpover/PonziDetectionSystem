package cn.qkl.webserver.common.enums;

public enum DynamicTypeEnum {
    NOT_DYNAMIC(0, "静态"),
    DYNAMIC(1, "动态"),

    ;

    private final int code;

    public int getCode() {
        return code;
    }

    DynamicTypeEnum(int code, String description) {
        this.code = code;
    }
}
