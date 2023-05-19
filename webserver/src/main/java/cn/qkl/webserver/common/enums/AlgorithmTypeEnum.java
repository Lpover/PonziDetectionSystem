package cn.qkl.webserver.common.enums;

public enum AlgorithmTypeEnum {
    DYNAMIC_ALGORITHM(0, "动态风险识别算法"),

    ;

    private final int code;

    public int getCode() {
        return code;
    }

    AlgorithmTypeEnum(int code, String description) {
        this.code = code;
    }
}
