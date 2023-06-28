package cn.qkl.cusumer.schedul;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchedulerThread extends Thread {

    public SchedulerThread(final String name, boolean daemon) {
        super(name);
        configureThread(name, daemon);
    }

    public SchedulerThread(final String name, Runnable runnable, boolean daemon) {
        super(runnable, name);
        configureThread(name, daemon);
    }

    public static SchedulerThread daemon(final String name, Runnable runnable) {
        return new SchedulerThread(name, runnable, true);
    }

    public static SchedulerThread nonDaemon(final String name, Runnable runnable) {
        return new SchedulerThread(name, runnable, false);
    }

    private void configureThread(final String name, boolean daemon) {
        setDaemon(daemon);
        setUncaughtExceptionHandler((t, e) -> log.error("Uncaught exception in thread '{}':", name, e));
    }
}
