package cn.qkl.webserver.common.enums;

public enum AlgorithmStateEnum {
    NO_USING(0, "已停用"),
    USING(1, "使用中"),

    ;

    private final int code;

    public int getCode() {
        return code;
    }

    AlgorithmStateEnum(int code, String description) {
        this.code = code;
    }
}
