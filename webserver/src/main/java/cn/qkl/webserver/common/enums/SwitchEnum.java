package cn.qkl.webserver.common.enums;

/**
 * @Author sunxiaen
 * @Date 2023/7/6 17:11
 **/
public enum  SwitchEnum {
    ON(1,"开"),
    CLOSE(0,"关"),
            ;

    private final int code;

    private final String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    SwitchEnum(int code, String description) {

        this.code = code;
        this.description = description;
    }
}
