package cn.qkl.webserver.dto.dynamic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class DynamicTypeModelDTO {
    @ApiModelProperty("数字内容主键id")
    @Size(min = 1)
    private List<Long> contentIdsList;
}
