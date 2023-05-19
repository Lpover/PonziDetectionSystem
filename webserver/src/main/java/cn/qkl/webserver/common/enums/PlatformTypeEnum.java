package cn.qkl.webserver.common.enums;

public enum PlatformTypeEnum {
    NOT_NFT(0, "web3平台"),
    NFT(1, "nft平台"),

    ;

    private final int code;

    public int getCode() {
        return code;
    }

    PlatformTypeEnum(int code, String description) {
        this.code = code;
    }
}
