package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.Account;
import cn.qkl.common.repository.model.Content;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.webserver.dao.AccountDao;
import cn.qkl.webserver.dao.ContentDao;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.service.PlatformViewService;
import cn.qkl.webserver.service.PlatformViewService.AccountGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/11/3 15:00
 * @wiki
 */
@Slf4j
@Component
public class ContentOnetimeBackgroundTask implements BackgroundTask {

    @Autowired
    private ContentDao contentDao;

    @Autowired
    private PlatformDao platformDao;

    @Autowired
    private PlatformViewService platformViewService;

    /**
     * 间隔1天
     */
    @Override
    public long getPeriod() {
        return 24 * 60 * 60 * 1000;
    }

    //从第二天开始每天凌晨2点执行
    @Override
    public long getDelay() {
        //一次性任务，delay为0
        return 0;
    }

    @Override
    public String getName() {
        return ContentOnetimeBackgroundTask.class.getName();
    }

    @Override
    public void run() {
        log.debug("模拟插入content表数据，一次性使用，注意修改数据");
        List<Content> list = new ArrayList<>();
        // 只获取正在监测的平台id
        List<Long> platformIDList= platformDao.select(c -> c.where(Tables.platform.monitor, isEqualTo(1))).stream().map(Platform::getId).collect(Collectors.toList());
        // 每个平台插入一条账号

        for (Long platformId : platformIDList) {
            Content content = new Content();
            insertCommon(content, platformId);

            PlatformViewService.ContentGenerator contentGenerator = new PlatformViewService.ContentGenerator();
            contentGenerator.insertContent(content);//账号内容

            list.add(content);
        }

        contentDao.insertMultiple(list);
    }

    private void insertCommon(Content content, Long platformID){
        Date end = new Date();
        content.setId(IdUtil.getSnowflakeNextId());
        content.setPlatformId(platformID);
        content.setListingTime(end);
        content.setCreateTime(end);
        content.setUpdateTime(end);
        content.setMintTime(end);
    }

}
