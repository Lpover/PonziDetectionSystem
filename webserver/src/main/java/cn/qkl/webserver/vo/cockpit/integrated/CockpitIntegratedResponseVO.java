package cn.qkl.webserver.vo.cockpit.integrated;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author sunxiaen
 * @Date 2023/6/6 16:13
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CockpitIntegratedResponseVO {
    @ApiModelProperty("社交舆情视图")
    SocialIndexViewVO socialIndexView;

    @ApiModelProperty("平台指数视图")
    PlatformIndexViewVO platformIndexView;

    @ApiModelProperty("词云图")
    VocabCloudViewVO vocabCloudView;

    @ApiModelProperty("热门内容视图")
    HotContentViewVO hotContentView;

    @ApiModelProperty("热门事件视图")
    HotEventViewVO hotEventView;

    @ApiModelProperty("情绪分析-敏感内容分析视图")
    TextAnalysisViewVO textAnalysisViewVO;
}
