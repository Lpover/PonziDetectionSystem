package cn.qkl.webserver.vo.cockpit.integrated;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author sunxiaen
 * @Date 2023/6/6 17:09
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChoiceVO {
    @ApiModelProperty("筛选id- 如果是时间，直接手动发参数 如果是平台，需要与数据库对应")
    private Long choiceId;

    @ApiModelProperty("筛选标签")
    private String text;
}
