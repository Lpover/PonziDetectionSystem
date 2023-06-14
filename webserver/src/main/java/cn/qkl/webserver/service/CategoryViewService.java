package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.Carrier;
import cn.qkl.common.repository.model.Category;
import cn.qkl.webserver.common.enums.CarrierTypeEnum;
import cn.qkl.webserver.common.enums.CategoryTypeEnum;
import cn.qkl.webserver.common.enums.StorageTypeEnum;
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
import java.util.*;

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
        HashMap<Integer, List<Integer>> hashNumber = new HashMap<>();
        HashMap<Integer, List<Date>> hashDate = new HashMap<>();
        for (Category category : categoryList) {
            if (hashNumber.containsKey(category.getCategoryType())) {
                hashNumber.get(category.getCategoryType()).add(category.getCategoryNumber());
            } else {
                List<Integer> lis = new ArrayList<>();
                lis.add(category.getCategoryNumber());
                hashNumber.put(category.getCategoryType(), lis);
            }
            if (hashDate.containsKey(category.getCategoryType())) {
                hashDate.get(category.getCategoryType()).add(category.getCreateTime());
            } else {
                List<Date> lis = new ArrayList<>();
                lis.add(category.getCreateTime());
                hashDate.put(category.getCategoryType(), lis);
            }
        }
        Set<Map.Entry<Integer, List<Integer>>> entryseSet = hashNumber.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entryseSet) {
            CategoryViewVO.ViewData a = new CategoryViewVO.ViewData();
            a.setName(CategoryTypeEnum.valueOf(entry.getKey()).getDescription());
            List<Integer> l = new ArrayList<>();
            List<Date> dd = new ArrayList<>();
            for (Integer aaa : entry.getValue()) {
                l.add(aaa);
            }
            for (Date t : hashDate.get(entry.getKey())) {
                dd.add(t);
            }
            a.setCategoryNumber(l);
            a.setTimeList(dd);
            list.add(a);
        }
        // 对时间和平台筛选
        CategoryViewVO vo = new CategoryViewVO();
        vo.setList(list);
        return vo;
    }

    public Category insertCategory(Category category) {
        return category;
    }
}
