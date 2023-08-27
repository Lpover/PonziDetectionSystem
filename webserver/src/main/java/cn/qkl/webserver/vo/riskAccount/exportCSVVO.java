package cn.qkl.webserver.vo.riskAccount;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:49
 * @wiki
 */
@Data
public class exportCSVVO {

    //目标地址
    private String address;
    //区块链
    private String blockchain;
    //协议
    private String protocols;
    //账号余额
    private String currencyBalance;
    //标签
    private String label;
    //备注
    private String note;
    //更新时间-最近交易时间
    private Date updateTime;
    //创建时间-首次交易时间
    private Date createTime;
    //转入总金额
    private Long fromAmount;
    //转出总金额
    private Long toAmount;
    //转入笔数
    private Long fromNum;
    //转出笔数
    private Long toNum;
    //转入对手
    private Long fromCounter;
    //转出对手
    private Long toCounter;


}
