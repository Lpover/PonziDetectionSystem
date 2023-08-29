package cn.qkl.webserver.dto.contenrisk;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:49
 * @wiki
 */
@Data
public class ContentBatchEvidenceDTO {
    @ApiModelProperty("待固证的数字内容id")
    private List<Long> contentIdList;
}
