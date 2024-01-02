package cn.qkl.webserver.vo.miniapp;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author sunxiaen
 * @Date 2024/1/2 14:11
 **/

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoVO {
    @ApiModelProperty("oss上的视频URL")
    private String url;
}
