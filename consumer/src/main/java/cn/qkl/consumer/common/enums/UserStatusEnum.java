package cn.qkl.consumer.common.enums;

public enum UserStatusEnum {
    NORMAL((byte) 1, "正常"),
    FORBIDDEN((byte) 2, "禁止"),
    DELETE((byte) 3, "删除"),
    ;

    private final byte code;

    public byte getCode() {
        return code;
    }

    UserStatusEnum(byte code, String description) {
        this.code = code;
    }
}
