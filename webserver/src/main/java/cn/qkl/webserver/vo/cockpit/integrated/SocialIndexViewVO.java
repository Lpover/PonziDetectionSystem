package cn.qkl.webserver.vo.cockpit.integrated;

import cn.qkl.common.repository.model.SocialPlatform;
import cn.qkl.webserver.common.enums.TimeSeriesChoiceEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import static cn.qkl.common.framework.util.FunctionUtil.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/6/5 17:47
 **/

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SocialIndexViewVO extends ViewVO {
//    "legend":"Twitter",
//    "number":[2.8,5.2]
//    "series":["近12h","近24h"]
    @ApiModelProperty("视图内容")
    private ViewData viewData;


    //静态内部类也可以加上Data
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ViewData {
        @ApiModelProperty("图例")
        private String legend;

        @ApiModelProperty("指数")
        private List<BigDecimal> number;

        @ApiModelProperty("横坐标")
        private List<String> series;
    }

    public static SocialIndexViewVO transformFromSocialPlatform(SocialPlatform socialPlatform) {
        return apply(new SocialIndexViewVO(), it -> {
            it.setViewData(apply(new ViewData(), v -> {
                v.setLegend(socialPlatform.getName());
                v.setNumber(apply(new ArrayList<>(), l -> {
                    l.add(socialPlatform.getSocialPlatformIndex12h());
                    l.add(socialPlatform.getSocialPlatformIndex24h());
                }));
                v.setSeries(apply(new ArrayList<>(), sl -> {
                    sl.add(TimeSeriesChoiceEnum.J12H.getDescription());
                    sl.add(TimeSeriesChoiceEnum.J24H.getDescription());
                }));
            }));
        });
    }
}
