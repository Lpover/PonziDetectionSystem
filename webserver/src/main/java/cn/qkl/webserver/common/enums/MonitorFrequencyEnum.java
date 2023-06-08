package cn.qkl.webserver.common.enums;

import java.util.Arrays;

public enum MonitorFrequencyEnum {

    NO_MONITOR(0,"不监测"),
    EVERY_DAY(2,"每天"),
    EVERY_WEEK(3,"每周"),
    EVERY_MONTH(4,"每月"),
    EVERY_SEASON(5,"每季度"),
    EVERY_YEAR(6,"每年"),
    ;


    private final int code;
    private final String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    MonitorFrequencyEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static MonitorFrequencyEnum valueOf(int code) {
        return Arrays.stream(values()).filter((x) -> x.getCode() == code).findFirst().orElseThrow(() -> new RuntimeException("枚举类型错误，code=[" + code + "]"));
    }
}
