package cn.qkl.webserver.service.kafka;

import cn.qkl.common.repository.model.NotifyRecord;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author sunxiaen
 * @Date 2023/6/29 11:45
 **/
@Service
@Slf4j
public class WarnService {
        @Autowired
        KafkaTemplate<String, String> kafka;

        public boolean tsgzWarn(NotifyRecord obj) {
            String message = null;
            try {
                ObjectMapper mapper = new ObjectMapper();
                message = mapper.writeValueAsString(obj);
                mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                log.info("生产者准备待发送通知信息：" + message);
                kafka.send("tsgz-warn", message); //新topic默认配置下会自动创建
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

}
