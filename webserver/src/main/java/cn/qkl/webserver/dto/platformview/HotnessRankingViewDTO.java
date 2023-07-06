package cn.qkl.webserver.dto.platformview;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public class HotnessRankingViewDTO  extends PageDTO {
    @ApiModelProperty("平台选择：0-NFT平台,1-WEB3平台,默认选择NFT平台")
    private Integer selectType=0;
}
