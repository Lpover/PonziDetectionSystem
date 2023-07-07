package cn.qkl.webserver.dto.threhold;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class IndexChangeDTO {
    @ApiModelProperty("ID选择：1-风险平台占比,2-风险内容数量,3-风险交易数量,4-综合风险指数,5-平台风险指数")
    private Long selectID= (long) -999;

    @ApiModelProperty("修改阈值的数值")
    private Integer changeValue= -999;
}
