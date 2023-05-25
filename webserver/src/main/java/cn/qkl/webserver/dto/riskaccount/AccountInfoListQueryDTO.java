package cn.qkl.webserver.dto.riskaccount;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountInfoListQueryDTO extends PageDTO {

    @ApiModelProperty("风险评级：1低风险 2中风险 3高风险, 不传表示都选")
    @Size(max = 3)
    private List<@Range(min = 1, max = 3) Integer> riskLevelList;

    @ApiModelProperty("关联数字内容最小值")
    private Integer relatedNumMin;

    @ApiModelProperty("关联数字内容最大值")
    private Integer relatedNumMax;

    @ApiModelProperty("发布风险数字内容最小值")
    private Integer releaseNumMin;

    @ApiModelProperty("发布风险数字内容最大值")
    private Integer releaseNumMax;

}
