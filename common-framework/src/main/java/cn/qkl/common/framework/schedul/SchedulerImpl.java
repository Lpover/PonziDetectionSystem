package cn.qkl.common.framework.schedul;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class SchedulerImpl implements Scheduler {

    private final int threads;


    private String threadNamePrefix = "scheduler-";
    private boolean daemon = true;

    @Override
    public void setThreadNamePrefix(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    private ScheduledThreadPoolExecutor executor = null;
    private final AtomicInteger schedulerThreadId = new AtomicInteger(0);


    public SchedulerImpl(int threads, String threadNamePrefix, boolean daemon) {
        this.threads = threads;
        this.threadNamePrefix = threadNamePrefix;
        this.daemon = daemon;
    }

    public SchedulerImpl(int threads) {
        this.threads = threads;
    }


    @Override
    public void startup() {
        log.debug("Initializing " + threadNamePrefix);
        synchronized (this) {
            if (isStarted())
                throw new IllegalStateException("This scheduler has already been started!");
            executor = new ScheduledThreadPoolExecutor(threads);
            executor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
            executor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            executor.setRemoveOnCancelPolicy(true);
            executor.setThreadFactory(runnable ->
                    new SchedulerThread(threadNamePrefix + "-" + schedulerThreadId.getAndIncrement(), runnable, daemon));
        }
    }

    @Override
    public ScheduledThreadPoolExecutor getExecutor() {
        return executor;
    }

    @Override
    public void shutdown() throws InterruptedException {
        log.debug("Shutting down task scheduler.");
        //避免空指针错误
        ScheduledThreadPoolExecutor cachedExecutor = this.executor;
        if (cachedExecutor != null) {
            synchronized (this) {
                cachedExecutor.shutdown();
                this.executor = null;
            }
            //不关掉就得block住，绝对不能return
            cachedExecutor.awaitTermination(1, TimeUnit.DAYS);
        }
    }

    /**
     * 运行一次
     *
     * @param name 任务名称
     * @param fun  task
     */
    public void scheduleOnce(String name, Runnable fun) {
        schedule(name, fun, 0L);
    }

    @Override
    public ScheduledFuture<?> schedule(String name, Runnable fun, long delay, long period, TimeUnit unit) {
        log.debug("Scheduling task {} with initial delay {} ms and period {} ms.",
                name, TimeUnit.MILLISECONDS.convert(delay, unit), TimeUnit.MILLISECONDS.convert(period, unit));
        synchronized (this) {
            ensureRunning();
            Runnable runnable = () -> {
                try {
                    log.trace("Beginning execution of scheduled task '{}'.", name);
                    fun.run();
                } catch (Throwable t) {
                    log.error("Uncaught exception in scheduled task " + name, t);
                } finally {
                    log.trace("Completed execution of scheduled task '{}'.", name);
                }
            };
            if (period >= 0)
                return executor.scheduleAtFixedRate(runnable, delay, period, unit);
            else
                return executor.schedule(runnable, delay, unit);
        }
    }


    /**
     * 检验task是否还在任务中
     *
     * @param task task
     * @return true 如果task还在任务中
     */
    public boolean taskRunning(ScheduledFuture<?> task) {
        return executor.getQueue().contains(task);
    }

    /**
     * 重新设置线程池大小
     *
     * @param newSize 新的线程池大小
     */
    public void resizeThreadPool(int newSize) {
        executor.setCorePoolSize(newSize);
    }

    @Override
    public boolean isStarted() {
        synchronized (this) {
            return executor != null;
        }
    }


    private void ensureRunning() {
        if (!isStarted())
            throw new IllegalStateException("scheduler is not running.");
    }
}


