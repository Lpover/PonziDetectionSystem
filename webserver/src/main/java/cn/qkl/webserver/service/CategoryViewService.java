package cn.qkl.webserver.service;

import cn.qkl.webserver.dto.category.CategoryViewDTO;
import cn.qkl.webserver.dto.stroage.StorageViewDTO;
import cn.qkl.webserver.vo.category.CategoryViewVO;
import cn.qkl.webserver.vo.stroage.StorageViewVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public  List<CategoryViewVO> getCategoryView(CategoryViewDTO dto){
        List <CategoryViewVO> list = new ArrayList<>();
        return list;
    }
}
