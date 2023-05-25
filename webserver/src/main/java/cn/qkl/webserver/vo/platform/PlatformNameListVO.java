package cn.qkl.webserver.vo.platform;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.Platform;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlatformNameListVO {
    @ApiModelProperty("平台主键id")
    private Long id;
    @ApiModelProperty("平台名称")
    private String name;
    public static PlatformNameListVO transform(Platform platform) {
        PlatformNameListVO vo = new PlatformNameListVO();
        BeanUtil.copyProperties(platform, vo);
        return vo;
    }
}
