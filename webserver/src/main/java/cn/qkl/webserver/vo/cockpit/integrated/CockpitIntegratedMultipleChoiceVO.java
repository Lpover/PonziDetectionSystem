package cn.qkl.webserver.vo.cockpit.integrated;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/6/6 17:08
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CockpitIntegratedMultipleChoiceVO {
    @ApiModelProperty("时间跨度选择")
    List<ChoiceVO> timeSeries;

    @ApiModelProperty("平台选择")
    List<ChoiceVO> platforms;

    @ApiModelProperty("社交平台选择")
    List<ChoiceVO> socialPlatforms;
}
