package cn.qkl.common.framework.util;

/**
 * @Author sunxiaen
 * @Date 2023/6/9 17:57
 **/
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUtil {

    private static ExecutorService executorService;

    // 私有构造函数，防止实例化
    private ThreadPoolUtil() {
    }

    // 获取单例的线程池对象
    public static synchronized ExecutorService getThreadPool() {
        if (executorService == null) {
            // 创建一个可缓存线程池
            executorService = Executors.newCachedThreadPool();
        }
        return executorService;
    }

    // 关闭线程池
    public static synchronized void shutdownThreadPool() {
        if (executorService != null) {
            executorService.shutdown();
            executorService = null;
        }
    }
}
