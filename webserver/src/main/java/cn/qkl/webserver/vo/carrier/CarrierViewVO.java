package cn.qkl.webserver.vo.carrier;

import cn.qkl.webserver.vo.stroage.StorageViewVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CarrierViewVO {
    @Data
    public static class ViewData {
        @ApiModelProperty("载体数量")
        private Integer carrierNumber;
        @ApiModelProperty("载体名字")
        private String name;
    }
    @ApiModelProperty("画图数据")
    List<ViewData> list;
    @ApiModelProperty("时间列表")
    List<Date> timeList;
}
