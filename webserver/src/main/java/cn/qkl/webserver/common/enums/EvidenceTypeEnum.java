package cn.qkl.webserver.common.enums;

import java.util.Arrays;

public enum EvidenceTypeEnum {
//  0  网页取证 1 移动端取证 2 手动固证 3 内容监测
    WEBPAGE(0, "网页取证"),
    MOBILE(1,"移动端取证"),
    MANUAL(2,"手动固证"),
    MONITOR(3,"内容监测")
    ;

    private final int code;
    private final String description;

    public int getCode() {
        return code;
    }

    public static String valueOf(int code) {
        return Arrays.stream(values()).filter((x) -> x.getCode() == code).findFirst().orElseThrow(() -> new RuntimeException("枚举类型错误，code=[" + code + "]")).description;
    }

    EvidenceTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
