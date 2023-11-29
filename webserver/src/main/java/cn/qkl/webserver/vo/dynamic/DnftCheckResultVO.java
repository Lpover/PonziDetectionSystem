package cn.qkl.webserver.vo.dynamic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author sunxiaen
 * @Date 2023/11/20 16:52
 **/
@Data
public class DnftCheckResultVO {
    @ApiModelProperty("模型结果")
    Integer result;
}
