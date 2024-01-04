package cn.qkl.webserver.backgroundTask.schedule;

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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isGreaterThanOrEqualTo;

/**
 * @Author sunxiaen
 * @Date 2024/1/4 16:18
 **/
@Component
@Slf4j
public class NotificationScheduleTaskV2 {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Runnable task;
    private long initialDelay = 0; //默认scheduler立即启动
    private long period = 15; // 默认时间间隔为15秒

    private boolean running = false;

    public boolean checkRunning() {
        return running;
    }

    public NotificationScheduleTaskV2(SwitchTableDao switchTableDao, ThresholdsDao thresholdsDao, NotifyRecordDao notifyRecordDao, WarnService warnService) {
        Optional<SwitchTable> config =  switchTableDao.selectOne(c -> c
                .where(Tables.switchTable.open,isEqualTo(SwitchEnum.ON.getCode()))
        );
        config.ifPresent(switchTable -> period = switchTable.getFrequency() * 60L);

        task = () -> {
            // 执行定时任务的操作
            log.info("Current time： {}", LocalDateTime.now());
            log.debug("check notice");
            log.debug("check period: " + period + "seconds");
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
            thresholds.forEach((model) -> {
                notifyItemIds.add(model.getId().toString());
            });
            if (notifyItemIds.isEmpty()) {
                log.info("所有指标都没有超过阈值");
                return;
            }

            List<String> userIds = new ArrayList<>();
            userIds.add(String.valueOf(1));
            userIds.add(String.valueOf(2+new Random().nextInt(3)));

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
        };
        startTask();
    }

    public boolean isRunning() {
        return scheduler.isShutdown();
    }
    public synchronized void startTask() {
        if (!running) {
            running = true;
            scheduler.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
        }
    }

    public synchronized void stopTask() {
        if (running) {
            scheduler.shutdown();
            running = false;
        }
    }

    public synchronized void changePeriod(long newPeriod) {
        // 动态修改时间间隔
        period = newPeriod;
        // 取消当前的任务，如有
        stopTask();
        // 重新启动任务
        scheduler = Executors.newScheduledThreadPool(1);
        startTask();
    }
}
