package cn.qkl.common.framework.schedul;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 用于运行job的调度程序
 * <p>
 * 该接口控制一个作业调度程序，允许调度周期性执行的重复后台作业或延迟的一次性操作。
 */
public interface Scheduler {
    /**
     * 初始化此调度器，以便它可以接受任务调度
     */
    void startup();

    /**
     * 关闭此调度程序。当该方法完成后，将不再执行后台任务。
     * 这包括计划延迟执行的任务。
     */
    void shutdown() throws InterruptedException;

    /**
     * 检查调度程序是否已经启动
     *
     * @return 是否启动
     */
    boolean isStarted();

    void setThreadNamePrefix(String threadNamePrefix);

    /**
     * 安排一个任务
     *
     * @param name   任务名称
     * @param fun    需要运行的函数
     * @param delay  第一次执行之前等待的时间
     * @param period 任务执行的周期。如果< 0，任务将只执行一次。
     * @param unit   调度时间单位
     * @return 一个Future对象，用于管理调度任务。
     */
    ScheduledFuture<?> schedule(String name, Runnable fun, long delay, long period, TimeUnit unit);

    default ScheduledFuture<?> schedule(String name, Runnable fun, long delay, long period) {
        return schedule(name, fun, delay, period, TimeUnit.MILLISECONDS);
    }

    default ScheduledFuture<?> schedule(String name, Runnable fun, long delay) {
        return schedule(name, fun, delay, -1);
    }

    default ScheduledFuture<?> schedule(String name, Runnable fun) {
        return schedule(name, fun, 0);
    }

    ScheduledThreadPoolExecutor getExecutor();
}
