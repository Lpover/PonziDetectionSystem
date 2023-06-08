package cn.qkl.webserver.vo.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;

/**
 * @param
 * @return
 */
@Data
public class WordCloudViewVO {
    // todo 结构体
    @ApiModelProperty("词标签作为key，词数量作为value")
    private HashMap<String, Integer> wordDict;
}
