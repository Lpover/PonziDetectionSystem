package cn.qkl.webserver.common.enums;

public enum DynamicTypeArtificialEnum {
    TBD(-1, "待定"),
    NOT_DYNAMIC(0, "静态"),
    READ_DYNAMIC(1, "读动态"),
    WRITE_DYNAMIC(2, "写动态")
    ;

    private final int code;

    public int getCode() {
        return code;
    }

    DynamicTypeArtificialEnum(int code, String description) {
        this.code = code;
    }
}
