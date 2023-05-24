package cn.qkl.webserver.vo.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

/**
 * @Author sunxiaen
 * @Date 2023/5/19 11:55
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountCheckHistoryVO {
    @ApiModelProperty("检查时间")
    private Date accountCheckTime;

    @ApiModelProperty("风险等级  0-无风险 1-低风险 2-中风险 3-高风险")
    @Range(min = 0, max = 3)
    private Integer riskLevel;

    @ApiModelProperty("关联内容数量")
    private Integer relatedNum;

    @ApiModelProperty("发布内容数量")
    private Integer releaseNum;
}
