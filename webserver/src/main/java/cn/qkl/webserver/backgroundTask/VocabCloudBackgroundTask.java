package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.repository.mapper.EventMapper;
import cn.qkl.common.repository.mapper.VocabCloudMapper;
import cn.qkl.common.repository.model.VocabCloud;
import cn.qkl.webserver.dao.VocabCloudDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @title:
 * @Author sunxiaen
 * @Date: 2023/5/25 15:00
 * @wiki
 */
@Slf4j
@Component
public class VocabCloudBackgroundTask implements BackgroundTask {

    @Autowired
    VocabCloudDao vocabCloudDao;

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
        return VocabCloudBackgroundTask.class.getName();
    }

    @Override
    public void run() {
        log.debug("insert vocabCloud");
        //业务代码
        Date end = new Date();
        VocabCloud vocabCloud = FunctionUtil.apply(new VocabCloud(), it -> {
            it.setId(IdUtil.getSnowflakeNextId());
            byte x = 'A';
            it.setVocab((x+new Random().nextInt(26))+"Xjp"+(x+new Random().nextInt(26)));
            it.setNum(new Random().nextInt(1000));
            it.setCreateTime(end);
            it.setUpdateTime(end);
        });
        System.out.println(vocabCloud);
        vocabCloudDao.insert(vocabCloud);
    }
}
