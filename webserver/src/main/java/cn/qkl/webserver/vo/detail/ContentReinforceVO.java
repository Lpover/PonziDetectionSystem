package cn.qkl.webserver.vo.detail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @param
 * @return
 */
@Data
public class ContentReinforceVO {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("固证状态 0未固证 1固证中 2已固证")
    private Integer status;
    @ApiModelProperty("固证哈希")
    private String chainHash;
    @ApiModelProperty("固证时间")
    private Date chainTime;
    @ApiModelProperty("证据包oss")
    private String packOss;
    @ApiModelProperty("固证文书oss")
    private String certOss;
}
