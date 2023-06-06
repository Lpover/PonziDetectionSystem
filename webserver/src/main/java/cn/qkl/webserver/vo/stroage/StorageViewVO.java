package cn.qkl.webserver.vo.stroage;

import cn.qkl.webserver.vo.riskcontentstatistics.RiskContentStatisticsVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StorageViewVO {
    @ApiModelProperty("存储主键id")
    private Long Id;
    @ApiModelProperty("存储商数量")
    private Integer storageNumber;
    @ApiModelProperty("存储商类别")
    private Integer storageType;
    @ApiModelProperty("存储商名字")
    private String name;
}
