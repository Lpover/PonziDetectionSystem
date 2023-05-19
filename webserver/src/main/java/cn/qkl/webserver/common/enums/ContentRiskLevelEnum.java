package cn.qkl.webserver.common.enums;

import java.util.Arrays;

public enum ContentRiskLevelEnum {
    NO_RISK(0, "无风险"),
    LOW_RISK(1, "低风险"),
    MIDDLE_RISK(2, "中风险"),
    HIGH_RISK(3, "高风险"),
    ;

    private final int code;
    private final String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    ContentRiskLevelEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ContentRiskLevelEnum valueOf(int code) {
        return Arrays.stream(values()).filter((x) -> x.getCode() == code).findFirst().orElseThrow(() -> new RuntimeException("枚举类型错误，code=[" + code + "]"));
    }
}
