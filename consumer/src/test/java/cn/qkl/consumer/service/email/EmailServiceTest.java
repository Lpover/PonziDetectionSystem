package cn.qkl.consumer.service.email;

import cn.qkl.consumer.service.notify.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class EmailServiceTest {

    @Autowired
    EmailService emailService;

    @Test
    void sendEmail() {
        List<String> strList = Arrays.asList("sunxiaen@163.com","1021974560@qq.com");
        StringBuilder emailStr = new StringBuilder("订单号:" + "123456789");
        emailStr.append("\n姓名：" + "尹可挺");
        emailStr.append("\n 2023年7月 第" + "1"+ "期");
        emailStr.append("\n 账单已扣款成功");
        emailService.sendEmail( String.join(",",strList),"坏帐扣款成功通知", emailStr.toString());

    }
}