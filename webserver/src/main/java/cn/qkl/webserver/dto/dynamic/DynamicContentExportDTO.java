package cn.qkl.webserver.dto.dynamic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class DynamicContentExportDTO {
    @ApiModelProperty("风险评级：1低风险 2中风险 3高风险, 不传表示都选")
    @Size(max = 3)
    private List<@Range(min = 1, max = 3) Integer> riskLevelList;
    @ApiModelProperty("平台主键id, 不传表示都选")
    private List<Long> platformIdList;
    @ApiModelProperty("时间范围 0全部 1近七天 2近一个月 3近半年")
    @Range(min = 0, max = 3)
    @NotNull
    private Integer time;
    @ApiModelProperty("文件名")
    @NotNull
    private String fileName;
}
