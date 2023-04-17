package cn.qkl.common.framework.exception;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class GlobalExceptionCallback {
    private static final List<BiConsumer<Exception, HttpServletRequest>> callbackList = new ArrayList<>();

    public synchronized static void register(BiConsumer<Exception, HttpServletRequest> consumer) {
        callbackList.add(consumer);
    }

    static void callback(Exception e, HttpServletRequest request) {
        callbackList.forEach(x -> x.accept(e, request));
    }
}
