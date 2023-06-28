package cn.qkl.cusumer.service.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailServiceTest {

    @Autowired
    EmailService emailService;

    @Test
    void sendEmail() {
        StringBuilder emailStr = new StringBuilder("订单号:" + "123456789");
        emailStr.append("\n姓名：" + "租租鸭");
        emailStr.append("\n 第" + "1"+ "期");
        emailStr.append("\n 已扣款成功");
        emailService.sendEmail("1021974560@qq.com", "坏帐扣款成功通知", emailStr.toString());

    }
}