package cn.qkl.webserver.vo.cockpit.integrated;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author sunxiaen
 * @Date 2023/6/5 17:51
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewVO {
    @ApiModelProperty("视图ID")
    private Integer viewId;

    @ApiModelProperty("视图名称")
    private String viewName;

    @ApiModelProperty("如果视图支持筛选，显示筛选字段的字符串拼接")
    private String viewChoice;
}
