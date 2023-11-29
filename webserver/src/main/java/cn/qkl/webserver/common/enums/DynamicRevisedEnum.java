package cn.qkl.webserver.common.enums;

public enum DynamicRevisedEnum {
    YES(1, "人工改过"),
    NO(0, "人工没改过"),

    ;

    private final int code;

    public int getCode() {
        return code;
    }

    DynamicRevisedEnum(int code, String description) {
        this.code = code;
    }
}
