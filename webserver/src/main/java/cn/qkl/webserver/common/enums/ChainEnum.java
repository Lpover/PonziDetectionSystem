package cn.qkl.webserver.common.enums;

public enum ChainEnum {
    ETH(0L, "以太坊"),
    BTC(1L, "比特币"),

    XINZHENG(5L, "信证链")
    ;

    private final Long code;

    public Long getCode() {
        return code;
    }

    ChainEnum(Long code, String description) {
        this.code = code;
    }
}
