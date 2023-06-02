package cn.qkl.webserver.vo.riskAccount;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.PlatformDailyStatistics;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class AccountNumVO {
    @ApiModelProperty("主键uuid，不要手动设置")
    private Long id;

    @ApiModelProperty("总高风险账号数量")
    private Integer totalHighAccount;

    @ApiModelProperty("总中风险账号数量")
    private Integer totalMiddleAccount;

    @ApiModelProperty("总低风险账号数量")
    private Integer totalLowAccount;

    public static AccountNumVO transform(PlatformDailyStatistics numStatistics) {
        AccountNumVO vo = new AccountNumVO();
        BeanUtil.copyProperties(numStatistics, vo);
        return vo;
    }
}
