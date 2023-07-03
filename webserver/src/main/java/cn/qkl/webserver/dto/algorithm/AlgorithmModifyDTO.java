package cn.qkl.webserver.dto.algorithm;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AlgorithmModifyDTO {
    @ApiModelProperty("算法主键id")
    @NotNull
    private Long id;

    @ApiModelProperty("算法名称")
    private String name;

    @ApiModelProperty("算法描述")
    private String describe;

    @ApiModelProperty("算法文件url")
    private String fileUrl;
}
