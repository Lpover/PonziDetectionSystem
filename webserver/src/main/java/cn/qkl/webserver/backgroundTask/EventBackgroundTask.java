package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.repository.model.Event;
import cn.qkl.common.repository.model.VocabCloud;
import cn.qkl.webserver.dao.EventDao;
import cn.qkl.webserver.dao.VocabCloudDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

/**
 * @title:
 * @Author sunxiaen
 * @Date: 2023/5/25 15:00
 * @wiki
 */
@Slf4j
@Component
public class EventBackgroundTask implements BackgroundTask {

    @Autowired
    EventDao eventDao;

    /**
     * 间隔1 min
     */
    @Override
    public long getPeriod() {
        return 1 * 1 * 1 * 1000 * 60;
    }

    //每天18点执行
    @Override
    public long getDelay() {
        //当前时间
//        Calendar now = Calendar.getInstance();
//        Calendar midnight = Calendar.getInstance();
//        midnight.set(Calendar.HOUR_OF_DAY, 18);
//        midnight.set(Calendar.MINUTE, 0);
//        midnight.add(Calendar.DATE, 1);
//        return midnight.getTime().getTime() - now.getTime().getTime();
        return 0;
    }

    @Override
    public String getName() {
        return EventBackgroundTask.class.getName();
    }

    @Override
    public void run() {
        log.debug("insert event");
        //业务代码
        Date end = new Date();
        Event event= FunctionUtil.apply(new Event(), it -> {
            it.setId(IdUtil.getSnowflakeNextId());
            byte x = 'A';
            it.setAbstractText("XjpHelloHa Abstract"+(char)(x+new Random().nextInt(26))+"Xjp"+new Random().nextInt(2006));
            it.setHotNum12h(new Random().nextInt(1000));
            it.setHotNum24h(new Random().nextInt(1000));
            it.setImageUrl("https://pic2.zhimg.com/v2-8c2ee9a783c45bb49b5af6b828ab1191_r.jpg");
            it.setCreateTime(end);
            it.setUpdateTime(end);
            it.setTitle("Title"+(char)(x+new Random().nextInt(26))+new Random().nextInt(2006));
            it.setPlatformId((long) (1+new Random().nextInt(10)));
        });
        eventDao.insert(event);
    }
}
