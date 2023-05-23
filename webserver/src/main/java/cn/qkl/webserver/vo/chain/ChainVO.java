package cn.qkl.webserver.vo.chain;


import cn.qkl.common.repository.model.Chain;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * @Author sunxiaen
 * @Date 2023/5/18 10:29
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChainVO {
    @ApiModelProperty("区块链主键id")
    private Long chainId;

    @ApiModelProperty("区块链名称")
    private String chainName;

    @ApiModelProperty("英文字母表示的加密货币单位")
    private String chainCryptoUnit;

    @ApiModelProperty("区块链logoUrl")
    private String chainLogoUrl;

    public static ChainVO transformFromChain(Chain chain){
        ChainVO chainVO = new ChainVO();
        BeanUtils.copyProperties(chain,chainVO);
        chainVO.chainId = chain.getId();   //chainVO [chainId] <- chain [Id]
        return chainVO;
    }
}
