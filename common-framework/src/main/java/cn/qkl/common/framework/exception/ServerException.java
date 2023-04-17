package cn.qkl.common.framework.exception;


/**
 * 服务端异常, 5xx
 * <p>
 * 通常由于服务器错误造成的可以使用该异常或子异常
 * <p>
 * 如IOException等
 *
 * @author zyl
 */
public class ServerException extends BaseException {

    public ServerException(String extra) {
        super(CommonStatus.SERVER_ERROR, extra);
    }

    public ServerException(String extra, String arg) {
        super(CommonStatus.SERVER_ERROR, extra, arg);
    }

}
