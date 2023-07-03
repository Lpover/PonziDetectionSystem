package cn.qkl.webserver.common.enums;

public enum ChainEnum {
    ETH(0, "以太坊"),
    BTC(1, "比特币"),

    ;

    private final int code;

    public int getCode() {
        return code;
    }

    ChainEnum(int code, String description) {
        this.code = code;
    }
}
