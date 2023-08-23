package cn.qkl.webserver.dto.riskaccount;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:49
 * @wiki
 */
@Data
public class AddNoteDTO {

    @ApiModelProperty("目标地址")
    private String accountAddress;

    @ApiModelProperty("备注")
    private String note;

}
