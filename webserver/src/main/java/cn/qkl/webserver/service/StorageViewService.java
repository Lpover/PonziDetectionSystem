package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.Storage;
import cn.qkl.webserver.common.enums.StorageTypeEnum;
import cn.qkl.webserver.dao.RiskTxViewDao;
import cn.qkl.webserver.dao.StorageDao;
import cn.qkl.webserver.dto.stroage.StorageViewDTO;
import cn.qkl.webserver.vo.stroage.StorageViewVO;
import lombok.extern.slf4j.Slf4j;
import nonapi.io.github.classgraph.fastzipfilereader.ZipFileSlice;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
public class StorageViewService {
    @Resource
    StorageDao storageDao;
    public  StorageViewVO getStorageView(StorageViewDTO dto) {
        Date date = new Date();
        Date end = DateUtil.beginOfDay(date);
        Date start = DateUtil.offsetDay(end, -7);   //默认近7天
        if (dto.getTime() == 2) {    // 近30天
            start = DateUtil.offsetDay(end, -30);
        }
        Date finalStart = start;
        // 对时间和平台筛选
        List<Storage> storageList = storageDao.select(c -> c
                .where(Tables.storage.platformId, isEqualTo(dto.getId()))
                .and(Tables.storage.createTime, isGreaterThan(finalStart))
                .and(Tables.storage.createTime, isLessThan(end))
                .orderBy(Tables.storage.createTime.descending())
        );
        List<StorageViewVO.ViewData> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> hashNumber = new HashMap<>();
        HashMap<Integer, List<Date>> hashDate = new HashMap<>();
        for (Storage storage : storageList) {
            if (hashNumber.containsKey(storage.getStorageType())) {
                hashNumber.get(storage.getStorageType()).add(storage.getStorageNumber());
            } else {
                List<Integer> lis = new ArrayList<>();
                lis.add(storage.getStorageNumber());
                hashNumber.put(storage.getStorageType(), lis);
            }
            if (hashDate.containsKey(storage.getStorageType())) {
                hashDate.get(storage.getStorageType()).add(storage.getCreateTime());
            } else {
                List<Date> lis = new ArrayList<>();
                lis.add(storage.getCreateTime());
                hashDate.put(storage.getStorageType(), lis);
            }
        }
            Set<Map.Entry<Integer, List<Integer>>> entryseSet = hashNumber.entrySet();
            for (Map.Entry<Integer, List<Integer>> entry : entryseSet) {
                StorageViewVO.ViewData a = new StorageViewVO.ViewData();
                a.setName(StorageTypeEnum.valueOf(entry.getKey()).getDescription());
                List<Integer> l = new ArrayList<>();
                List<Date> dd = new ArrayList<>();
                for (Integer aaa : entry.getValue()) {
                    l.add(aaa);
                }
                for (Date t : hashDate.get(entry.getKey())) {
                    dd.add(t);
                }
                a.setStorageNumber(l);
                a.setTimeList(dd);
                list.add(a);
            }
        StorageViewVO vo = new StorageViewVO();
        vo.setList(list);
        return vo;
    }

    public Storage insertStorage(Storage storage) {
        return storage;
    }

}
