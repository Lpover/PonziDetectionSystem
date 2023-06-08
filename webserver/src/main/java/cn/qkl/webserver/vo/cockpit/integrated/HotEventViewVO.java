package cn.qkl.webserver.vo.cockpit.integrated;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/6/6 11:20
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotEventViewVO extends ViewVO {

    @ApiModelProperty("视图内容")
    private List<EventInfo> viewData;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class EventInfo {
        @ApiModelProperty("事件标题")
        private String title;

        @ApiModelProperty("事件图片")
        private String imageUrl;

        @ApiModelProperty("事件摘要")
        private String abstractText;

        @ApiModelProperty("事件热度")
        private Long hotNum;
    }
}