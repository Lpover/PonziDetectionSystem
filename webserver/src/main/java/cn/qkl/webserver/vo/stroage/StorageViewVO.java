package cn.qkl.webserver.vo.stroage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StorageViewVO {
    @Data
    public static class ViewData {
        @ApiModelProperty("存储商数量")
        private List<Integer> storageNumber;
        @ApiModelProperty("存储商名字")
        private String name;
        @ApiModelProperty("时间列表")
        List<Date> timeList;
    }
    @ApiModelProperty("画图数据")
    List<ViewData> list;

}
