package cn.qkl.webserver.async;

import cn.qkl.webserver.controller.BoardController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TsgzAsyncImplTest {

    @Autowired
    TsgzAsyncService tsgzAsyncService;

    @Autowired
    BoardController boardController;

    @Test
    void doAsync() {
        for (int i = 0; i < 10; i++) {
//            boardController.getCockpitIntegratedMultipleChoice();
            tsgzAsyncService.doAsync();
        }
    }

}