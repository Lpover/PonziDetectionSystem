package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.common.repository.model.Carrier;
import cn.qkl.common.repository.model.Category;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.common.repository.model.PlatformDailyStatistics;
import cn.qkl.webserver.common.enums.CategoryTypeEnum;
import cn.qkl.webserver.dao.CarrierDao;
import cn.qkl.webserver.dao.CategoryDao;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.service.CarrierViewService;
import cn.qkl.webserver.service.CategoryViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title:
 * @Author li yang
 * @Date: 2022/11/3 15:00
 * @wiki
 */
@Slf4j
@Component
public class CategoryBackgroundTask implements BackgroundTask {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    CategoryViewService categoryViewService;
    @Autowired
    private PlatformDao platformDao;
    @Override
    public long getPeriod() {
        return 24 * 60 * 60 * 1000;
    }

    //从第二天开始每天凌晨2点执行
    @Override
    public long getDelay() {
        //当前服务器时间
        Date start = new Date();
        //一天的结束，结果：00:00:00
        Date end = DateUtil.beginOfDay(start);
        //当天2：00：00
        end = DateUtil.offsetHour(end, 2);
        //第二天1：00：00
        end = DateUtil.offsetDay(end, 1);

        //延迟至第二天凌晨2点开始执行
        return end.getTime() - start.getTime();
    }

    @Override
    public String getName() {
        return CategoryBackgroundTask.class.getName();
    }

    @Override
    public void run() {
        log.debug("模拟插入category表数据");
        List<Category> list=new ArrayList<>();
        List<Long> platformIDList= platformDao.select(c -> c).stream().map(Platform::getId).collect(Collectors.toList());
        //每天插入十条数据
            for (Long platformid : platformIDList) {
                for(CategoryTypeEnum cc:CategoryTypeEnum.values()) {
                    Date end = new Date();
                    Category category = new Category();
                    category.setId(IdUtil.getSnowflakeNextId());
                    category.setPlatformId(platformid);
                    category.setCreateTime(end);
                    category.setUpdateTime(end);
                    category = categoryViewService.insertCategory(category,cc);
                    list.add(category);
                }
            }
        categoryDao.insertMultiple(list);
    }
}
