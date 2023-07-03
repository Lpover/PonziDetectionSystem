package cn.qkl.webserver.service;

import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.webserver.dto.noticification.NotificationRecordDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NotificationServiceTest {
    @Autowired
    NotificationService notificationService;

    @Test
    void getNotificationRecord() {
        System.out.println(notificationService.getNotificationRecord(FunctionUtil.apply(new NotificationRecordDTO(),it ->{it.setPageId(1);it.setPageSize(3);})));
    }
}