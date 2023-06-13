package cn.qkl.webserver.service.user;

import cn.qkl.webserver.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceTest {
    @Resource
    UserService userService;

    @Test
    void test1() {
        userService.test();
    }
}