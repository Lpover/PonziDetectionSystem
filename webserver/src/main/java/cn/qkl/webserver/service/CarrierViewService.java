package cn.qkl.webserver.service;

import cn.qkl.webserver.dto.carrier.CarrierViewDTO;
import cn.qkl.webserver.dto.stroage.StorageViewDTO;
import cn.qkl.webserver.vo.carrier.CarrierViewVO;
import cn.qkl.webserver.vo.stroage.StorageViewVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RefreshScope
public class CarrierViewService {
    public  List<CarrierViewVO> getCarrierView(CarrierViewDTO dto){
        List <CarrierViewVO> list = new ArrayList<>();
        return list;
    }
}
