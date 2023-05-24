package cn.qkl.webserver.common.enums;

public enum SuperviseTypeEnum {
    NOT_SUPERVISE(0, "未监管"),
    SUPERVISE(1, "监管"),

            ;

    private final int code;

    public int getCode() {
        return code;
    }

    SuperviseTypeEnum(int code, String description) {
        this.code = code;
    }
}
