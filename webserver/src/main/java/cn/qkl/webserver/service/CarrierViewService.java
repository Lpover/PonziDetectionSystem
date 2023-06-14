package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.Carrier;
import cn.qkl.common.repository.model.Storage;
import cn.qkl.webserver.common.enums.CarrierTypeEnum;
import cn.qkl.webserver.common.enums.StorageTypeEnum;
import cn.qkl.webserver.dao.CarrierDao;
import cn.qkl.webserver.dao.StorageDao;
import cn.qkl.webserver.dto.carrier.CarrierViewDTO;
import cn.qkl.webserver.dto.stroage.StorageViewDTO;
import cn.qkl.webserver.vo.carrier.CarrierViewVO;
import cn.qkl.webserver.vo.stroage.StorageViewVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
@Slf4j
@RefreshScope
public class CarrierViewService {
    @Resource
    CarrierDao carrierDao;
    public  void insertCarrier(Carrier carrier) {
        Random random = new Random();
        carrier.setCarrierNumber(random.nextInt(1000));
    }

    public  CarrierViewVO getCarrierView(CarrierViewDTO dto){

        Date date = new Date();
        Date end = DateUtil.beginOfDay(date);
        Date start = DateUtil.offsetDay(end, -7);   //默认近7天
        if (dto.getTime() == 2) {    // 近30天
            start = DateUtil.offsetDay(end, -30);
        }
        Date finalStart = start;
        List<Carrier> carrierList=carrierDao.select(c->c
                .where(Tables.carrier.platformId, isEqualTo(dto.getId()))
                .and(Tables.carrier.createTime, isGreaterThan(finalStart))
                .and(Tables.carrier.createTime, isLessThan(end))
                .orderBy(Tables.carrier.createTime.descending())
        );
        List<CarrierViewVO.ViewData> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> hashNumber = new HashMap<>();
        HashMap<Integer, List<Date>> hashDate = new HashMap<>();
        for (Carrier carrier : carrierList) {
            if (hashNumber.containsKey(carrier.getCarrierType())) {
                hashNumber.get(carrier.getCarrierType()).add(carrier.getCarrierNumber());
            } else {
                List<Integer> lis = new ArrayList<>();
                lis.add(carrier.getCarrierNumber());
                hashNumber.put(carrier.getCarrierType(), lis);
            }
            if (hashDate.containsKey(carrier.getCarrierType())) {
                hashDate.get(carrier.getCarrierType()).add(carrier.getCreateTime());
            } else {
                List<Date> lis = new ArrayList<>();
                lis.add(carrier.getCreateTime());
                hashDate.put(carrier.getCarrierType(), lis);
            }
        }
        // 对时间和平台筛选
        Set<Map.Entry<Integer, List<Integer>>> entryseSet = hashNumber.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entryseSet) {
            CarrierViewVO.ViewData a = new CarrierViewVO.ViewData();
            a.setName(CarrierTypeEnum.valueOf(entry.getKey()).getDescription());
            List<Integer> ll = new ArrayList<>();
            List<Date> dd = new ArrayList<>();
            for (Integer aaa : entry.getValue()) {
                ll.add(aaa);
            }
            for (Date t : hashDate.get(entry.getKey())) {
                dd.add(t);
            }
            a.setCarrierNumber(ll);
            a.setTimeList(dd);
            list.add(a);
        }
        CarrierViewVO vo = new CarrierViewVO();
        vo.setList(list);
        return vo;
    }
}
