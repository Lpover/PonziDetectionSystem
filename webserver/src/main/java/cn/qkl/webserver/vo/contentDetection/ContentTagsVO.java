package cn.qkl.webserver.vo.contentDetection;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.ContentRisk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class ContentTagsVO {
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("风险标签的名字")
    private String category;

    @ApiModelProperty("该标签的数量")
    private Long num;
    public static ContentTagsVO transform(ContentRisk contentRisk) {
        ContentTagsVO vo = new ContentTagsVO();
        BeanUtil.copyProperties(contentRisk, vo);
        return vo;
    }
}
