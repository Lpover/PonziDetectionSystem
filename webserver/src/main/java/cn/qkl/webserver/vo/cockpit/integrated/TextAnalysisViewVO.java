package cn.qkl.webserver.vo.cockpit.integrated;

import static cn.qkl.common.framework.util.FunctionUtil.*;

import cn.qkl.common.framework.util.FunctionUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/6/6 11:30
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TextAnalysisViewVO extends ViewVO {
    @ApiModelProperty("视图内容")
    private ViewData viewData;
    //静态内部类也可以加上Data
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ViewData {

        @ApiModelProperty("敏感内容折线图")
        private List<LegendNumberListVO> sensitiveData;

        @ApiModelProperty("情感环形图")
        private List<LegendNumberVO> emotionData;

        @ApiModelProperty("敏感内容折线图的横坐标")
        private List<String> series;
    }

    public static TextAnalysisViewVO transform(Long countPos, Long countNeg, List<BigDecimal> sensitive, List<BigDecimal> nonSensitive, List<String> time) {
        return apply(new TextAnalysisViewVO(), it ->{
           it.setViewData(apply(new ViewData(), v -> {
               v.setSeries(time);
               v.setEmotionData(apply(new ArrayList<LegendNumberVO>(), l -> {
                   l.add(new LegendNumberVO("Positive",countPos));
                   l.add(new LegendNumberVO("Negative",countNeg));
               }));
               v.setSensitiveData(apply(new ArrayList<LegendNumberListVO>(),l -> {
                   l.add(new LegendNumberListVO("Sensitive",sensitive));
                   l.add(new LegendNumberListVO("NonSensitive",nonSensitive));
               }));
           }));
        });
    }
}
