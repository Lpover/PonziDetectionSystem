//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.qkl.common.framework.initAndBackground;


import cn.qkl.common.framework.schedul.Scheduler;
import cn.qkl.common.framework.schedul.SchedulerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BackgroundTaskManager implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(BackgroundTaskManager.class);
    @Autowired
    BackgroundProperties backgroundProperties;
    private Scheduler backgroundScheduler;
    private final List<BackgroundTask> backgroundTaskList;

    public BackgroundTaskManager(List<BackgroundTask> backgroundTaskList) {
        this.backgroundTaskList = backgroundTaskList;
    }

    public void run(String... args) {
        if (this.backgroundTaskList.isEmpty()) {
            log.info("no background task register");
        } else {
            this.backgroundScheduler = new SchedulerImpl(this.backgroundProperties.getThreadNum());
            this.backgroundScheduler.setThreadNamePrefix("InitAndBackground");
            this.backgroundScheduler.startup();
            this.backgroundTaskList.forEach((task) -> {
                log.info("[{}]-[{}] start...", task.getTaskType(), task.getName());
                this.backgroundScheduler.schedule(task.getName(), task, task.getDelay(), task.getPeriod());
            });
        }
    }
}
