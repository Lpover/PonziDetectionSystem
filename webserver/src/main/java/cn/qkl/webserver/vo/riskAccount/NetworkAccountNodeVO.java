package cn.qkl.webserver.vo.riskAccount;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author sunxiaen
 * @Date 2023/9/4 18:18
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkAccountNodeVO {
    @ApiModelProperty("账户ID")
    private Long id;
    @ApiModelProperty("账户地址")
    private String label;
    @ApiModelProperty("账户riskindex")
    private Integer riskIndex;
}
