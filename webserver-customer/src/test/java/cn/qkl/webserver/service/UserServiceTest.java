package cn.qkl.webserver.service;

import cn.qkl.webserver.controller.user.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Test
    void test1(){
        String a = "https://mindlax-bylh.s3.ap-northeast-1.amazonaws.com/ac7a6e8762a64f227efc0ccee73074eb.gif";
        String b = "https://mindlax-bylh.s3.ap-northeast-1.amazonaws.com/";
        System.out.println(a.substring(b.length()));
        System.out.println(a.substring(b.length()+1));
    }
}