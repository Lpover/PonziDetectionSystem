package cn.qkl.webserver.vo.cockpit.integrated;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/6/6 10:58
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LegendNumberVO {
    @ApiModelProperty("图例名称")
    String name;

    @ApiModelProperty("数字")
    Long number;
}
