package cn.qkl.webserver.dto.dynamic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ManualMarkDynamicTypeArtificialDTO {
    @ApiModelProperty("数字内容主键id")
    @Size(min = 1)
    private List<Long> contentIdList;
    @ApiModelProperty("批量标记的类型 -1待定 0静态 1读动态 2 写动态")
    private Integer dynamicTypeArtificial = -1;
}
