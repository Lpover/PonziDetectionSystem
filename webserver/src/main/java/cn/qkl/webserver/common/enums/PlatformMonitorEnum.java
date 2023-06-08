package cn.qkl.webserver.common.enums;

public enum PlatformMonitorEnum {
    NOT_MONITOR(0, "不监控"),
    MONITOR(1, "监控"),

    ;

    private final int code;

    public int getCode() {
        return code;
    }

    PlatformMonitorEnum(int code, String description) {
        this.code = code;
    }
}
