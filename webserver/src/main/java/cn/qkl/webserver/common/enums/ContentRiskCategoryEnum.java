package cn.qkl.webserver.common.enums;

import java.util.Arrays;

public enum ContentRiskCategoryEnum {
    NO_RISK(0, "无"),
    POLITICS(1, "政治风险"),
    TERROR(2, "恐怖风险"),
    VIOLENCE(3, "暴力风险"),
    CRIME(4, "犯罪风险"),
    VULGAR(5, "低俗风险"),
    GAMBLING(6, "赌博风险"),
    DRUGS(7, "毒品风险"),
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
