package cn.qkl.webserver.dto.contenrisk;

import cn.qkl.common.framework.request.PageDTO;
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
public class ContentBatchEvidenceDTO extends PageDTO {
    @ApiModelProperty("待固证的数字内容id")
    private List<Long> contentIdList;
}
