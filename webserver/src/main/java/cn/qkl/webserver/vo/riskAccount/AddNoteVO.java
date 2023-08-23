package cn.qkl.webserver.vo.riskAccount;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:49
 * @wiki
 */
@Data
public class AddNoteVO {

    @ApiModelProperty("备注")
    private String note;

}
