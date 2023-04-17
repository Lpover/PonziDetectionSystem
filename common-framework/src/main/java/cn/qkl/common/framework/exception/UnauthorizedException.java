package cn.qkl.common.framework.exception;

public class UnauthorizedException extends BaseException {

    public UnauthorizedException(String arg) {
        super(CommonStatus.UNAUTHORIZED, arg, arg);
    }

    public UnauthorizedException(String extra, String arg) {
        super(CommonStatus.UNAUTHORIZED, extra, arg);
    }
}
