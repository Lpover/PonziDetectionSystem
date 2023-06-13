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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
        List<Date> t=new ArrayList<>();
        for (Carrier carrier : carrierList) {
            CarrierViewVO.ViewData v=new CarrierViewVO.ViewData();
            v.setCarrierNumber(carrier.getCarrierNumber());
            v.setName(CarrierTypeEnum.valueOf(carrier.getCarrierType()).getDescription());
            list.add(v);
            t.add(carrier.getCreateTime());
        }
        // 对时间和平台筛选
        CarrierViewVO vo = new CarrierViewVO();
        vo.setTimeList(t);
        vo.setList(list);
        return vo;
    }
}
