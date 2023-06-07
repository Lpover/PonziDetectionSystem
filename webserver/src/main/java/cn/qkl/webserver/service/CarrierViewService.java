package cn.qkl.webserver.service;

import cn.qkl.common.repository.model.Carrier;
import cn.qkl.webserver.dto.carrier.CarrierViewDTO;
import cn.qkl.webserver.dto.stroage.StorageViewDTO;
import cn.qkl.webserver.vo.carrier.CarrierViewVO;
import cn.qkl.webserver.vo.stroage.StorageViewVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
@RefreshScope
public class CarrierViewService {
    public  void insertCarrier(Carrier carrier) {
        Random random = new Random();
        carrier.setCarrierNumber(random.nextInt(1000));
    }

    public  List<CarrierViewVO> getCarrierView(CarrierViewDTO dto){
        List <CarrierViewVO> list = new ArrayList<>();
        return list;
    }
}
