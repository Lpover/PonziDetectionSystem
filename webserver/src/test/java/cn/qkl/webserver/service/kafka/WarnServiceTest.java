package cn.qkl.webserver.service.kafka;

import cn.qkl.common.repository.model.NotifyRecord;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WarnServiceTest {

    @Resource
    WarnService warnService;
    @Test
    void warn() {
        NotifyRecord notifyRecord = new NotifyRecord();
        notifyRecord.setId(1212L);
        notifyRecord.setNotifyItemIds("1,2");
        notifyRecord.setUserIds("1,2");
        warnService.tsgzWarn(notifyRecord);
    }
}