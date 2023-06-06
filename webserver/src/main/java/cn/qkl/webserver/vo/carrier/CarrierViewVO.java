package cn.qkl.webserver.vo.carrier;

import cn.qkl.webserver.vo.stroage.StorageViewVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CarrierViewVO {
    @ApiModelProperty("载体主键id")
    private Long Id;
    @ApiModelProperty("载体数量")
    private Integer carrierNumber;
    @ApiModelProperty("载体类别")
    private Integer carrierType;
    @ApiModelProperty("载体名字")
    private String name;
}
