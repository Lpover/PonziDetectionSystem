package cn.qkl.webserver.service;

import cn.qkl.webserver.dto.detail.ContentReinforceDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class DetatilServiceTest {

    @Autowired
    DetailService detailService;

    @Test
    void reinforceDetail() throws IOException, NoSuchAlgorithmException {
        ContentReinforceDTO dto = new ContentReinforceDTO();
        dto.setId(1668088776725491714L);
        detailService.reinforceDetail(dto);
    }
}