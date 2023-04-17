package cn.qkl.common.framework.response;

public interface BaseCode {
    String getCode();

    String getMsg();

    default String getDefaultMsg() {
        return getMsg();
    }

    /**
     * 获取code的模块前缀标识，如A0001, 或USER-0001等
     *
     * @return prefix
     */
    String getModulePrefix();

    /**
     * 获取完整code，模块前缀标识+code
     *
     * @return prefix+code
     */
    default String getFullCode() {
        return getModulePrefix() + getCode();
    }
}
