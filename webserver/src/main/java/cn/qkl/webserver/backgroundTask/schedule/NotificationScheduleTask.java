package cn.qkl.webserver.backgroundTask.schedule;

/**
 * @Author sunxiaen
 * @Date 2023/8/28 15:45
 **/
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.NotifyRecord;
import cn.qkl.common.repository.model.SwitchTable;
import cn.qkl.common.repository.model.Thresholds;
import cn.qkl.webserver.common.enums.NotifyStatusEnum;
import cn.qkl.webserver.common.enums.SwitchEnum;
import cn.qkl.webserver.dao.NotifyRecordDao;
import cn.qkl.webserver.dao.SwitchTableDao;
import cn.qkl.webserver.dao.ThresholdsDao;
import cn.qkl.webserver.service.kafka.WarnService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isGreaterThanOrEqualTo;

/**
 * 定时任务
 */
@Data
@Slf4j
@Component
public class NotificationScheduleTask implements SchedulingConfigurer {

    // 配置文件中配置表达式，默认是0/15 * * * * ?（15秒执行一次）
    // @Value("${notification.cron:0 */10 * * * ?}")
    // 这个项目的话记录在mysql的switch表中
    private String cron;

    @Autowired
    ThresholdsDao thresholdsDao;

    @Autowired
    SwitchTableDao switchTableDao;

    @Autowired
    NotifyRecordDao notifyRecordDao;

    @Autowired
    WarnService warnService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        Optional<SwitchTable> config =  switchTableDao.selectOne(c -> c);
        Integer frequency = config.get().getFrequency();
        String cron = String.format("0 */%d * * * ?", frequency);
        this.setCron(cron);
        System.out.println(cron);

        // 动态使用cron表达式设置循环间隔
        taskRegistrar.addTriggerTask(() -> {
            // todo 任务
            log.info("Current time： {}", LocalDateTime.now());
            log.debug("check notice");
            log.debug("check cron: " + this.cron);
            //业务代码
            Optional<SwitchTable> st =  switchTableDao.selectOne(c -> c
                    .where(Tables.switchTable.open,isEqualTo(SwitchEnum.ON.getCode()))
            );

            if (!st.isPresent()) {
                log.info("通知没有开");
                return;
            }
            Calendar ca = Calendar.getInstance();
            ca.setTime(new Date());
            int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK);
            if (st.get().getOpenWeek() == 0 && (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY)) {
                log.info("周末预警没开，休息");
                return;
            }
            LocalTime now = LocalTime.now();

            ZoneId zoneId = ZoneId.systemDefault();
            Date start = st.get().getStartTime();
            LocalDateTime localDateTime1 = LocalDateTime.ofInstant(start.toInstant(),zoneId);
            LocalTime localTime1 = localDateTime1.toLocalTime();

            Date end = st.get().getEndTime();
            LocalDateTime localDateTime2 = LocalDateTime.ofInstant(end.toInstant(),zoneId);
            LocalTime localTime2 = localDateTime2.toLocalTime();


            if (now.isAfter(localTime2) || now.isBefore(localTime1)) {
                log.info("不在时间内");
                return;
            }

            List<Thresholds> thresholds = thresholdsDao.select(c -> c
                    .where(Tables.thresholds.nowIndex, isGreaterThanOrEqualTo(Tables.thresholds.setIndex))
                    .and(Tables.thresholds.on,isEqualTo(SwitchEnum.ON.getCode()))
            );
            List<String> notifyItemIds = new ArrayList<>();
            List<String> userIds = new ArrayList<>();
            userIds.add(String.valueOf(1));
            userIds.add(String.valueOf(2+new Random().nextInt(3)));

            thresholds.forEach((model) -> {
                notifyItemIds.add(model.getId().toString());
            });
            NotifyRecord obj = FunctionUtil.apply(new NotifyRecord(), it -> {
                it.setUserIds(String.join(",", userIds));
                it.setNotifyItemIds(String.join(",", notifyItemIds));
                it.setId(IdUtil.getSnowflakeNextId());
                it.setStatus(NotifyStatusEnum.PREPARING.getCode());
                it.setCreateTime(new Date());
                it.setUpdateTime(new Date());
            });
            notifyRecordDao.insert(obj);
            warnService.tsgzWarn(obj);
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(@NonNull TriggerContext triggerContext) {
                // 使用CronTrigger触发器，可动态修改cron表达式来操作循环规则
                CronTrigger cronTrigger = new CronTrigger(NotificationScheduleTask.this.cron);
                System.out.println(NotificationScheduleTask.this.cron);
                return cronTrigger.nextExecutionTime(triggerContext);
            }
        });
    }
}
