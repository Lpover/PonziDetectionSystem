package cn.qkl.webserver.vo.cockpit.integrated;

import cn.qkl.common.repository.model.Platform;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import static cn.qkl.common.framework.util.FunctionUtil.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author sunxiaen
 * @Date 2023/6/5 17:47
 **/

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlatformIndexViewVO extends ViewVO {

    private ViewData viewData;

    //静态内部类也可以加上Data
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ViewData {

        private List<LegendNumberListVO> indexData;

        private List<String> series;
    }

    public static PlatformIndexViewVO transformFromPlatforms(List<Platform> platforms) {
        List<BigDecimal> riskIndexChinaList = new ArrayList<BigDecimal>();
        List<BigDecimal> riskIndexOverseaList = new ArrayList<BigDecimal>();
        return apply(new PlatformIndexViewVO(), it -> {
            it.setViewData(apply(new ViewData(), v -> {
                v.indexData = new ArrayList<LegendNumberListVO>();
                v.series = new ArrayList<String>();
                for (Platform platform : platforms) {
                     v.series.add(platform.getName());
                     riskIndexChinaList.add(platform.getRiskIndexChina());
                     riskIndexOverseaList.add(platform.getRiskIndexOversea());
                }
                v.indexData.add(new LegendNumberListVO("index1",riskIndexChinaList));
                v.indexData.add(new LegendNumberListVO("index2",riskIndexOverseaList));
            }));
        });
    }

}
