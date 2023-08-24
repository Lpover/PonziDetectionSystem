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
public class DetailNoteDTO {

    @ApiModelProperty("交易哈希，是长度为66的字符串")
    private String txHash;

    @ApiModelProperty("备注")
    private String note;

}
