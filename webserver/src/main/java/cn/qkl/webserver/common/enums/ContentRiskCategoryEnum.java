package cn.qkl.webserver.common.enums;

public enum ContentRiskCategoryEnum {
    NO_RISK(0, "无风险"),

    ;

    private final int code;

    public int getCode() {
        return code;
    }

    ContentRiskCategoryEnum(int code, String description) {
        this.code = code;
    }
}
