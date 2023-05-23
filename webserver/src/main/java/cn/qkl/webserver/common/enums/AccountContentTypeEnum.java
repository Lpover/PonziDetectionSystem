package cn.qkl.webserver.common.enums;

public enum AccountContentTypeEnum {
    CREATOR(0, "发布"),
    INTERACT(1,"参与")
    ;

    private final int code;

    public int getCode() {
        return code;
    }

    AccountContentTypeEnum(int code, String description) {
        this.code = code;
    }
}
