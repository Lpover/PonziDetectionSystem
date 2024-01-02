package cn.qkl.webserver.dto.miniapp;

import cn.qkl.webserver.common.enums.MiniappEvidenceEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author sunxiaen
 * @Date 2023/12/19 16:16
 **/
@Data
public class EvidenceDTO {
    @ApiModelProperty("保全记录查询-1 未保全记录查询-0")
    @NotNull
    private int preserved = MiniappEvidenceEnum.NonPreserved.getCode();
}
