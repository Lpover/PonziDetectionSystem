package cn.qkl.webserver.vo.category;

import cn.qkl.webserver.vo.carrier.CarrierViewVO;
import cn.qkl.webserver.vo.stroage.StorageViewVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CategoryViewVO {
    @Data
    public static class ViewData {
        @ApiModelProperty("类别数量")
        private List<Integer> categoryNumber;
        @ApiModelProperty("类型名字")
        private String name;
        @ApiModelProperty("时间列表")
        List<Date> timeList;
    }
    @ApiModelProperty("画图数据")
    List<ViewData> list;
}
