package cn.qkl.webserver.common.enums;

import java.util.Arrays;

public enum CategoryTypeEnum {
    DYNAMIC(0, "动态"),
    STATIC(1, "静态"),
    OTHER(2, "其他"),
    ;

    private final int code;
    private final String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    CategoryTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static CategoryTypeEnum valueOf(int code) {
        return Arrays.stream(values()).filter((x) -> x.getCode() == code).findFirst().orElseThrow(() -> new RuntimeException("枚举类型错误，code=[" + code + "]"));
    }
}
