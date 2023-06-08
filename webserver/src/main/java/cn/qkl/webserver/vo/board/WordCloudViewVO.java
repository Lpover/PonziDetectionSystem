package cn.qkl.webserver.vo.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param
 * @return
 */
@Data
public class WordCloudViewVO {
    @ApiModelProperty("词标签")
    private String word;

    @ApiModelProperty("词数量")
    private Integer num;
}
