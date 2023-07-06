package cn.qkl.webserver.vo.evidence;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author sunxiaen
 * @Date 2023/7/5 18:17
 **/

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvidenceCertVO {
    @ApiModelProperty("URL")
    private String url;
}
