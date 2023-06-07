package cn.qkl.webserver.dto.platformview;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public class HotnessRankingViewDTO {
    @ApiModelProperty("平台选择：0-NFT平台,2-WEB3平台")
    private Integer selectType=0;
}
