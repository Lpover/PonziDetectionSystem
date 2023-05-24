package cn.qkl.webserver.service.account;

import cn.qkl.webserver.schedul.Scheduler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
class AccountSchedulerTest {
    @Resource(name = "AccountContentSchedulerImpl")
    Scheduler accountContentSchedulerImpl;
    @Test
    void shutdownSchedulerTest() throws InterruptedException {
        accountContentSchedulerImpl.startup();
        accountContentSchedulerImpl.schedule("test_name", () -> System.out.println(new Date()),10,1000);
        Thread.sleep(2000);
        accountContentSchedulerImpl.shutdown();
    }
}