package cn.qkl.webserver.common.enums;

import java.util.Arrays;
import java.util.List;

public enum ContentRiskCategoryEnum {
    NO_RISK(0, "无风险"),
    POLITICS(1, "政治"),
    VIOLENCE(2, "暴力"),
    EROTICISM(3, "涉黄"),

    ;


    private final int code;
    private final String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    ContentRiskCategoryEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ContentRiskCategoryEnum valueOf(int code) {
        return Arrays.stream(values()).filter((x) -> x.getCode() == code).findFirst().orElseThrow(() -> new RuntimeException("枚举类型错误，code=[" + code + "]"));
    }
}
