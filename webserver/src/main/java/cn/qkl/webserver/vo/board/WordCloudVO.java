package cn.qkl.webserver.vo.board;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param
 * @return
 */
@Data
public class WordCloudVO {
    @ApiModelProperty("词标签：" +
            "0 无风险\n" +
            "1 政治\n" +
            "2 恐怖\n" +
            "3 暴力\n" +
            "4 低俗\n" +
            "5 犯罪\n" +
            "6 赌博\n" +
            "7 毒品")
    private Integer word;

    @ApiModelProperty("词标签数量")
    private Integer num;
}
