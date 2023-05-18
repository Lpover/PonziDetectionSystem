package cn.qkl.webserver.vo.algorithm;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.Algorithm;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AlgorithmVO {
    @ApiModelProperty("算法主键id")
    private Long id;

    @ApiModelProperty("算法版本: 1 2 3")
    private Integer version;

    @ApiModelProperty("算法识别率")
    private BigDecimal recognitionRate;

    @ApiModelProperty("算法类别：0动态风险识别算法 1账户风险识别算法")
    private Integer type;

    public static AlgorithmVO transform(Algorithm algorithm) {
        AlgorithmVO vo = new AlgorithmVO();
        BeanUtil.copyProperties(algorithm, vo);
        return vo;
    }
}
