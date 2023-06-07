package cn.qkl.webserver.common.enums;

/**
 * @Author sunxiaen
 * @Date 2023/6/6 18:09
 **/
public enum TimeSeriesChoiceEnum {
    J12H(1,"近12小时"),
    J24H(2,"近24小时"),
    ;

    private final long code;

    private final String description;

    public long getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    TimeSeriesChoiceEnum(int code, String description) {

        this.code = code;
        this.description = description;
    }
}
