package cn.qkl.webserver.vo.detail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param
 * @return
 */
@Data
public class ContentReinforceStatusVO {
    @ApiModelProperty("固证状态 0未固证 1固证中 2已固证")
    private Integer status;
}
