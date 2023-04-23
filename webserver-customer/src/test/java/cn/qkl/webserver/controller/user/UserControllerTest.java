package cn.qkl.webserver.controller.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    @Resource
    UserController userController;

    @Test
    void testAge() {
        userController.testAge();
    }
}