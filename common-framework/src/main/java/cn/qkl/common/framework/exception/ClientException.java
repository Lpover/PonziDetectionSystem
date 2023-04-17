package cn.qkl.common.framework.exception;

/**
 * 客户端异常，区别于BusinessException, 主要用于接口调用错误，如参数不符合规范等情况
 *
 * @author zyl
 */
public class ClientException extends BaseException {

    public ClientException(String extra) {
        super(CommonStatus.CLIENT_ERROR, extra);
    }

    public ClientException(String extra, String arg) {
        super(CommonStatus.CLIENT_ERROR, extra, arg);
    }
}
