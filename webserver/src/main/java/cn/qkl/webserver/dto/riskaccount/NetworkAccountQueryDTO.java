package cn.qkl.webserver.dto.riskaccount;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.AssertTrue;

/**
 * @Author sunxiaen
 * @Date 2023/8/23 14:34
 **/
@Data
public class NetworkAccountQueryDTO {
    @ApiModelProperty("选择某一区块链进行账户网状分析，请求chain/list接口获取链列表")
    private Long chainId;
    @ApiModelProperty("账户链上地址")
    private String accountAddress;

    @AssertTrue(message = "所有条件必填其一")
    public Boolean getUserValid(){
        return !StrUtil.isAllBlank(this.chainId.toString(), this.accountAddress);
    }
}
