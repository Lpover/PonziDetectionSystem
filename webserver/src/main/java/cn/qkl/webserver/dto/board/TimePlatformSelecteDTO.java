package cn.qkl.webserver.dto.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param
 * @return
 */
@Data
public class TimePlatformSelecteDTO {
    @ApiModelProperty("时间跨度：0 近七天; 1 近一月; 2 近半年; 3 近一年")
    Integer timeSpan;
    @ApiModelProperty("平台选择")
    Long platformid;
}
