package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.Carrier;
import cn.qkl.common.repository.model.Category;
import cn.qkl.webserver.common.enums.CarrierTypeEnum;
import cn.qkl.webserver.common.enums.CategoryTypeEnum;
import cn.qkl.webserver.dao.CategoryDao;
import cn.qkl.webserver.dao.StorageDao;
import cn.qkl.webserver.dto.category.CategoryViewDTO;
import cn.qkl.webserver.dto.stroage.StorageViewDTO;
import cn.qkl.webserver.vo.carrier.CarrierViewVO;
import cn.qkl.webserver.vo.category.CategoryViewVO;
import cn.qkl.webserver.vo.stroage.StorageViewVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @title:
 * @Author li yang
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class CategoryViewService {
    @Resource
    CategoryDao categoryDao;
    public  CategoryViewVO getCategoryView(CategoryViewDTO dto){
        Date date = new Date();
        Date end = DateUtil.beginOfDay(date);
        Date start = DateUtil.offsetDay(end, -7);   //默认近7天
        if (dto.getTime() == 2) {    // 近30天
            start = DateUtil.offsetDay(end, -30);
        }
        Date finalStart = start;
        List<Category> categoryList=categoryDao.select(c->c
                .where(Tables.category.platformId, isEqualTo(dto.getId()))
                .and(Tables.category.createTime, isGreaterThan(finalStart))
                .and(Tables.category.createTime, isLessThan(end))
                .orderBy(Tables.category.createTime.descending())
        );
        List<CategoryViewVO.ViewData> list = new ArrayList<>();
        List<Date> t=new ArrayList<>();
        for (Category category : categoryList) {
            CategoryViewVO.ViewData v=new CategoryViewVO.ViewData();
            v.setCategoryNumber(category.getCategoryNumber());
            v.setName(CategoryTypeEnum.valueOf(category.getCategoryType()).getDescription());
            list.add(v);
            t.add(category.getCreateTime());
        }
        // 对时间和平台筛选
        CategoryViewVO vo = new CategoryViewVO();
        vo.setTimeList(t);
        vo.setList(list);
        return vo;
    }

    public Category insertCategory(Category category) {
        return category;
    }
}
