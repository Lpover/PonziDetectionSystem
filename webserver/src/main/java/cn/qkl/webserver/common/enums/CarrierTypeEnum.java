package cn.qkl.webserver.common.enums;

import java.util.Arrays;

public enum CarrierTypeEnum {
    PICTURE(0, "图片"),
    VIDEO(1, "视频"),
    OTHER(10, "其他"),
    ;

    private final int code;
    private final String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    CarrierTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static CarrierTypeEnum valueOf(int code) {
        return Arrays.stream(values()).filter((x) -> x.getCode() == code).findFirst().orElseThrow(() -> new RuntimeException("枚举类型错误，code=[" + code + "]"));
    }
}
