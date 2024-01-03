package cn.qkl.webserver.common.enums;

public enum MiniappEvidenceEnum {
    NonPreserved(0, "待保全"),
    Preserved(1, "已保全"),

    ;

    private final int code;

    public int getCode() {
        return code;
    }

    MiniappEvidenceEnum(int code, String description) {
        this.code = code;
    }
}
