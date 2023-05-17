package cn.qkl.webserver.dto.dynamic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ManualReviseDynamicTypeDTO{
    @ApiModelProperty("数字内容主键id")
    @NotNull
    private List<Long> contentIdList;
}
