package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isGreaterThanOrEqualTo;

/**
 * @title:
 * @Author sunxiaen
 * @Date: 2023/5/25 15:00
 * @wiki
 */
@Slf4j
@Component
public class NotifyBackgroundTask implements BackgroundTask {

    @Autowired
    ThresholdsDao thresholdsDao;

    @Autowired
    SwitchTableDao switchTableDao;

    @Autowired
    NotifyRecordDao notifyRecordDao;

    @Autowired
    WarnService warnService;
    /**
     * 间隔1 min
     */
    @Override
    public long getPeriod() {
        return 1 * 1 * 60 * 1000;
    }

    //每天18点执行
    @Override
    public long getDelay() {
        //当前时间
        return 0;
    }

    @Override
    public String getName() {
        return NotifyBackgroundTask.class.getName();
    }

    @Override
    public void run() {
        log.debug("check notice");

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
        NotifyRecord obj = FunctionUtil.apply(new NotifyRecord(),it -> {
            it.setUserIds(String.join(",", userIds));
            it.setNotifyItemIds(String.join(",", notifyItemIds));
            it.setId(IdUtil.getSnowflakeNextId());
            it.setStatus(NotifyStatusEnum.PREPARING.getCode());
            it.setCreateTime(new Date());
            it.setUpdateTime(new Date());
        });
        notifyRecordDao.insert(obj);
        warnService.tsgzWarn(obj);
    }
}
