package cn.qkl.webserver.vo.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author sunxiaen
 * @Date 2023/5/23 10:53
 **/

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TagVO {
    @ApiModelProperty("平台标签")
    private String platform;

    @ApiModelProperty("链标签")
    private String chain;

    @ApiModelProperty("是否是动态 0-静态 1-动态")
    private Integer dynamic;
}
