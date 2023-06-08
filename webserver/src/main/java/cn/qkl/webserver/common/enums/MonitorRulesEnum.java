package cn.qkl.webserver.common.enums;

import java.util.Arrays;

/**
 * @param
 * @return
 */

public enum MonitorRulesEnum {
    DYNAMIC(0, "动态内容"),
    HIGH_RISK_ACCOUNT(5, "高风险账户"),
    MIDDLE_RISK_ACCOUNT(6, "中风险账户"),
    LOW_RISK_ACCOUNT(7, "低风险账户"),
    HIGH_RISK_PLATFORM(10, "高风险平台"),
    MIDDLE_RISK_PLATFORM(11, "中风险平台"),
    LOW_RISK_PLATFORM(12, "低风险平台"),
    ;
    private final int code;
    private final String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    MonitorRulesEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static MonitorRulesEnum valueOf(int code) {
        return Arrays.stream(values()).filter((x) -> x.getCode() == code).findFirst().orElseThrow(() -> new RuntimeException("枚举类型错误，code=[" + code + "]"));
    }
}
