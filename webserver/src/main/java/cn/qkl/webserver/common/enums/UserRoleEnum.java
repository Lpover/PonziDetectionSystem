package cn.qkl.webserver.common.enums;

import java.util.Arrays;

public enum UserRoleEnum {
    ADMIN(0, "管理员"),
    USER(5, "用户"),
    ;

    private final int code;

    public int getCode() {
        return code;
    }

    UserRoleEnum(int code, String description) {
        this.code = code;
    }

    public static UserRoleEnum valueOf(int code) {
        return Arrays.stream(values()).filter((x) -> x.getCode() == code).findFirst().orElseThrow(() -> new RuntimeException("枚举类型错误，code=[" + code + "]"));
    }
}
