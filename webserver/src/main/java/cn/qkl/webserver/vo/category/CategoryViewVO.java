package cn.qkl.webserver.vo.category;

import cn.qkl.webserver.vo.stroage.StorageViewVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryViewVO {
    @ApiModelProperty("类别数量")
    private Integer categoryNumber;
    @ApiModelProperty("类别type")
    private Integer categoryType;
    @ApiModelProperty("类型名字")
    private String name;
}
