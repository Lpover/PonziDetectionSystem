package cn.qkl.common.framework.util;


import cn.qkl.common.framework.schedul.Scheduler;
import cn.qkl.common.framework.schedul.SchedulerImpl;

public class SchedulerUtil {
    //全局公用线程
    public static Scheduler commonScheduler = new SchedulerImpl(5);

    static {
        commonScheduler.setThreadNamePrefix("common-scheduler");
        commonScheduler.startup();
    }

}
