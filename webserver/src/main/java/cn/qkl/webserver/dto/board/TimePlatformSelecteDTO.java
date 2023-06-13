package cn.qkl.webserver.dto.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param
 * @return
 */
@Data
public class TimePlatformSelecteDTO {
    @ApiModelProperty("时间跨度：1 近七天; 2 近一月; 3 近半年; 4 近一年")
    Integer timeSpan;
    @ApiModelProperty("平台选择")
    Long platformid;
}
