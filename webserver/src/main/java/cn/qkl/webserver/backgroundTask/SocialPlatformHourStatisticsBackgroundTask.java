package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.repository.model.SocialPlatform;
import cn.qkl.common.repository.model.SocialPlatformHourStatistics;
import cn.qkl.webserver.dao.SocialPlatformDao;
import cn.qkl.webserver.dao.SocialPlatformHourStatisticsDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @title:
 * @Author sunxiaen
 * @Date: 2023/6/9 15:00
 * @wiki
 */
@Slf4j
@Component
public class SocialPlatformHourStatisticsBackgroundTask implements BackgroundTask {

    @Autowired
    SocialPlatformDao socialPlatformDao;

    @Autowired
    SocialPlatformHourStatisticsDao socialPlatformHourStatisticsDao;

    /**
     * 间隔1 min
     */
    @Override
    public long getPeriod() {
        return 1 * 60 * 60 * 1000;
    }

    //每天18点执行
    @Override
    public long getDelay() {
        //当前时间
        Calendar now = Calendar.getInstance();
        Calendar midnight = Calendar.getInstance();
        midnight.set(Calendar.HOUR_OF_DAY, 1);
        midnight.set(Calendar.MINUTE, 0);
        midnight.add(Calendar.DATE, 1);
        return midnight.getTime().getTime() - now.getTime().getTime();
//        return 0;
    }

    @Override
    public String getName() {
        return SocialPlatformHourStatisticsBackgroundTask.class.getName();
    }

    @Override
    public void run() {
        log.debug("insert socialPlatformHourStatistics");
        Date date = new Date();
        //业务代码
        List<Long> collectSp = socialPlatformDao.select(c -> c).stream().map(SocialPlatform::getId).collect(Collectors.toList());
        int spSize = collectSp.size();
        SocialPlatformHourStatistics socialPlatformHourStatistics = FunctionUtil.apply(new SocialPlatformHourStatistics(), it -> {
            Random random = new Random();
            it.setId(IdUtil.getSnowflakeNextId());
            it.setSocialPlatformId(collectSp.get(random.nextInt(spSize)));

            it.setCreateTime(date);
            it.setUpdateTime(date);

            it.setPosEmotionNum(random.nextInt(1000));
            it.setNegEmotionNum(random.nextInt(1000));
            it.setSensitiveNum(random.nextInt(1000));
            it.setNonSensitiveNum(random.nextInt(1000));
        });
        socialPlatformHourStatisticsDao.insert(socialPlatformHourStatistics);
    }
}
