package cn.qkl.webserver.vo.algorithm;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.Algorithm;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AlgorithmVO {
    @ApiModelProperty("算法主键id")
    private Long id;

    @ApiModelProperty("算法名称")
    private String name;

    @ApiModelProperty("算法描述")
    private String describe;

    @ApiModelProperty("算法版本: 2 3 4")
    private Integer version;

    @ApiModelProperty("算法识别率")
    private BigDecimal recognitionRate;

    @ApiModelProperty("算法类别：0动态风险识别算法 1账户风险识别算法")
    private Integer type;

    @ApiModelProperty("算法更新时间")
    private Date updateTime;

    @ApiModelProperty("算法状态 1表示使用中 0表示未使用")
    private Integer state;

    public static AlgorithmVO transform(Algorithm algorithm) {
        AlgorithmVO vo = new AlgorithmVO();
        BeanUtil.copyProperties(algorithm, vo);
        return vo;
    }
}
