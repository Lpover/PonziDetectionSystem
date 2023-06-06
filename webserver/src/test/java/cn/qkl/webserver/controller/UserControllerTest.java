package cn.qkl.webserver.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserControllerTest {

    @Resource
    UserController userController;

    @Test
    void testAge() {
//        userController.testAge();
    }
}