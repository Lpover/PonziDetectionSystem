package cn.qkl.webserver.dto.algorithm;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AlgorithmListQueryDTO{
    @ApiModelProperty("算法类别：0动态风险识别算法 1账户风险识别算法")
    private List<Integer> type;
}
