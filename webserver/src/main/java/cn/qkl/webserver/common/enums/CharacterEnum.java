package cn.qkl.webserver.common.enums;

public enum CharacterEnum {
    HUMAN(1, "人工"),
    MACHINE(0, "机器"),

    ;

    private final int code;

    public int getCode() {
        return code;
    }

    CharacterEnum(int code, String description) {
        this.code = code;
    }

}
