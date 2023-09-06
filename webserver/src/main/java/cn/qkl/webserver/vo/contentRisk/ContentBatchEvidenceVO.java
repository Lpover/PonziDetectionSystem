package cn.qkl.webserver.vo.contentRisk;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class ContentBatchEvidenceVO {
    @ApiModelProperty("固证的id列表")
    private List<Long> contentIdList;
    @ApiModelProperty("固证是否成功 0否 1是")
    private List<Integer> reinforceStatusList;

}
