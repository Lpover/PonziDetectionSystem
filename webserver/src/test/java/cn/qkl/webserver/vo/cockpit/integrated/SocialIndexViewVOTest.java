package cn.qkl.webserver.vo.cockpit.integrated;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SocialIndexViewVOTest {

    @Test
    void getViewData() {
        SocialIndexViewVO socialIndexViewVO = new SocialIndexViewVO();
        socialIndexViewVO.setViewData(new SocialIndexViewVO.ViewData());
    }

    @Test
    void getJson() throws JsonProcessingException {
        SocialIndexViewVO socialIndexViewVO = new SocialIndexViewVO();
        socialIndexViewVO.setViewData(new SocialIndexViewVO.ViewData());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(socialIndexViewVO);
        System.out.println(json);
    }

    @Test
    void setViewData() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void canEqual() {
    }

    @Test
    void testHashCode() {
    }
}