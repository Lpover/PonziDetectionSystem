package cn.qkl.webserver.service.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserServiceTest {
    @Resource
    UserService userService;

    @Test
    void test1() {
        userService.test();
    }
}