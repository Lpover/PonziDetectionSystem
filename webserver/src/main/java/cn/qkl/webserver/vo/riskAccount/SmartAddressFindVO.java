package cn.qkl.webserver.vo.riskAccount;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.RiskReport;
import cn.qkl.webserver.vo.contentRiskStatictics.RiskCategoryVO;
import cn.qkl.webserver.vo.riskContentStatictics.PlatformReportVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class SmartAddressFindVO {

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("地址表-地址")
    private String address;

    @ApiModelProperty("地址表-风险等级,0-低风险 1-中风险 2-高风险")
    private Integer riskIndex;

    @ApiModelProperty("地址表-备注")
    private String note;

    @ApiModelProperty("地址表-流入总额")
    private BigDecimal fromAmount;

}
