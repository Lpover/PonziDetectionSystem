package cn.qkl.webserver.service;

import cn.qkl.common.framework.util.FunctionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isInWhenPresent;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CockpitIntegratedServiceTest {

    @Resource
    CockpitIntegratedService cockpitIntegratedService;


    @Test
    void getCockpitIntegratedResponseAll() {
    }

    @Test
    void getCockpitIntegratedResponseDynamic() {
    }

    @Test
    void getCockpitIntegratedMultipleChoice() {

//        System.out.println(cockpitIntegratedService.getCockpitIntegratedMultipleChoice());
//      System.out.println(Arrays.toString(Arrays.stream(TimeSeriesChoiceEnum.values()).toArray()));
//      Arrays.stream(TimeSeriesChoiceEnum.values());
    }

    @Test
    void getSocialIndexView() throws JsonProcessingException {
        com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(cockpitIntegratedService.getSocialIndexView(1L));
        HashMap<String , String> hashmap = FunctionUtil.apply(new HashMap<>(), it -> {
            it.put("key1","value1");
            it.put("key2","value2");
        });
        String json = mapper.writeValueAsString(hashmap);
        System.out.println(json);
//        System.out.println();
    }

    @Test
    void getPlatformIndexView() throws JsonProcessingException {
        com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
        long[] longNums = {1,2,3,4,5};
        for (long longNum : longNums) {
            System.out.println(longNum);
        }

        List<Long> longList = Arrays.stream(longNums)
                .boxed()
                .collect(Collectors.toList());
        String json = mapper.writeValueAsString(cockpitIntegratedService.getPlatformIndexView(new ArrayList<Long>(longList)));
        System.out.println(json);
    }

    @Test
    void getVocabCloudView() throws JsonProcessingException {
        List<Long> l = null; System.out.println(isInWhenPresent(l));
        com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(cockpitIntegratedService.getVocabCloudView());

        System.out.println(json);
    }


    @Test
    void testGetHotContentView() throws JsonProcessingException {
        com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(cockpitIntegratedService.getHotContentView(1L,1L));
        String json = mapper.writeValueAsString(cockpitIntegratedService.getHotContentView(1L,2L));
        System.out.println(json);
    }

    @Test
    void testGetHotEventView() throws JsonProcessingException {
        com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(cockpitIntegratedService.getHotContentView(1L,1L));
        String json = mapper.writeValueAsString(cockpitIntegratedService.getHotEventView(1L,2L));
        System.out.println(json);
    }

    @Test
    void testGetTextAnalysisView() throws JsonProcessingException {
        com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(cockpitIntegratedService.getTextAnalysisView(1L,1L));
        System.out.println(json);
    }
}