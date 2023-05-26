package cn.qkl.webserver.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AccountCheckServiceTest {

    @Resource
    AccountCheckService accountCheckService;

    @Test
    void getAccountCheckOnce() throws SQLException {
        accountCheckService.getAccountCheckOnce(1L);
    }
}