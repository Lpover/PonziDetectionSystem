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
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LegendNumberListVO {
    @ApiModelProperty("图例名称")
    String legend;

    @ApiModelProperty("数字序列")
    List<BigDecimal> number;
}
