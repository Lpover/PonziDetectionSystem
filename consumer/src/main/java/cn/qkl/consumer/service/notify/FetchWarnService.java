package cn.qkl.consumer.service.notify;

import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.NotifyRecord;
import cn.qkl.common.repository.model.User;
import cn.qkl.consumer.common.enums.NotifyStatusEnum;
import cn.qkl.consumer.dao.NotifyRecordDao;
import cn.qkl.consumer.dao.ThresholdsDao;
import cn.qkl.consumer.dao.UserDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author sunxiaen
 * @Date 2023/6/29 12:23
 **/
@Service
@Slf4j
public class FetchWarnService {

    @Autowired
    EmailService emailService;

    @Autowired
    UserDao userDao;

    @Autowired
    ThresholdsDao thresholdsDao;

    @Autowired
    NotifyRecordDao notifyRecordDao;

    public static final String tsgzWarnTopic = "tsgz-warn";

    @KafkaListener(topics = tsgzWarnTopic)
    public boolean fetch(String value) {
        // todo 幂等问题 校验原先的状态 然后再update update的where里面加上check条件
        NotifyRecord notifyRecord= null;
        try {
            //todo new序列化 写到工具类
            notifyRecord = new ObjectMapper().readValue(value, NotifyRecord.class);
            log.info("消费者接收到待发送通知信息：" + notifyRecord);
            List<String> itemList = new ArrayList<>();

            List<Long> notifyItemIds = Arrays.stream(notifyRecord.getNotifyItemIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
            thresholdsDao.select( c -> c.where(Tables.thresholds.id, SqlBuilder.isInWhenPresent(notifyItemIds))).forEach(item -> {
                itemList.add(item.getName()+" 指标为："+item.getNowIndex()+" 异常!");
            });
            List<Long> userIds = Arrays.stream(notifyRecord.getUserIds().split(",")).map(Long::valueOf).collect(Collectors.toList());

            //Java 8 新特性 effectively final 下面这句被自动加上final
            //首先思考外部的局部变量 final 和匿名内部类里面的 final 是否是同一个变量？ ---内部类构造函数使用外部的变量传入 所以是副本
            //为何还需要用 final 修饰？  ---数据一致性
            NotifyRecord finalNotifyRecord = notifyRecord;
            try {
                userDao.select(c -> c.where(Tables.user.id, SqlBuilder.isInWhenPresent(userIds))).forEach(user -> {
                    String name = user.getName();
                    String email = user.getEmail();
                    String warnings = String.join("\n",itemList);

                    String content = "%s，您好。\n 数字内容推感知与分析系监测到异常！\n" +
                            "具体表现为：%s。\n" +
                            "%s\n" +
                            "  \n" +
                            "若您不是我们的客户，请忽略此条。退订回复T。";

                    emailService.sendEmail(email,new Date()+"态势感知预警",String.format(content,name,warnings, new Date()));
                });
                notifyRecordDao.update(u -> u.set(Tables.notifyRecord.status).equalTo(NotifyStatusEnum.OK.getCode())
                        .where(Tables.notifyRecord.id,SqlBuilder.isEqualTo(finalNotifyRecord.getId())));

            }catch (Exception e) {
                notifyRecordDao.update(u -> u.set(Tables.notifyRecord.status).equalTo(NotifyStatusEnum.EXCEPTION.getCode())
                        .where(Tables.notifyRecord.id,SqlBuilder.isEqualTo(finalNotifyRecord.getId())));
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return true;
    }
}
