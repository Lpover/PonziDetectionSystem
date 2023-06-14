package cn.qkl.webserver.common.enums;

import java.util.Arrays;

public enum StorageTypeEnum {
    IPFS(0, "ipfs"),
    ALI_YUN(1, "阿里云"),
    HUAWEI_YUN(2, "华为云"),
    OTHER(10, "其他"),
    ;
    private final int code;
    private final String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    StorageTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static StorageTypeEnum valueOf(int code) {
        return Arrays.stream(values()).filter((x) -> x.getCode() == code).findFirst().orElseThrow(() -> new RuntimeException("枚举类型错误，code=[" + code + "]"));
    }
}
