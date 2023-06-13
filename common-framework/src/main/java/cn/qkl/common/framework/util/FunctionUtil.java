package cn.qkl.common.framework.util;

import java.util.function.Consumer;

/**
 * @Author sunxiaen
 * @Date 2023/6/7 14:38
 **/
public class FunctionUtil {

    public static <T> T apply(T object, Consumer<T> block) {
        block.accept(object);
        return object;
    }
}
