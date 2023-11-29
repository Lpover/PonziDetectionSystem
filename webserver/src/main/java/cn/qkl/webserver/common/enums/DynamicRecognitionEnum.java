package cn.qkl.webserver.common.enums;

//同时也会用在DynamicMonitor的Status字段上，公用枚举

public enum DynamicRecognitionEnum {
    OK(0, "识别成功"),
    ING(1, "正在识别"),

    NETWORK_ERROR(2,"网络错误"),
    MODEL_ERROR(3,"模型错误"),
    ;

    private final int code;

    public int getCode() {
        return code;
    }

    DynamicRecognitionEnum(int code, String description) {
        this.code = code;
    }
}
