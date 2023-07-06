package cn.qkl.webserver.vo.Notification;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class TextPreviewVO {

    @ApiModelProperty("文本预览的文字")
    private String text;

}
