package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class ContentCrossDailyStatistics {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long chainId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer txNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentCrossDailyStatistics withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getChainId() {
        return chainId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentCrossDailyStatistics withChainId(Long chainId) {
        this.setChainId(chainId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRiskAccountNum() {
        return riskAccountNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentCrossDailyStatistics withRiskAccountNum(Integer riskAccountNum) {
        this.setRiskAccountNum(riskAccountNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskAccountNum(Integer riskAccountNum) {
        this.riskAccountNum = riskAccountNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getTxNum() {
        return txNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentCrossDailyStatistics withTxNum(Integer txNum) {
        this.setTxNum(txNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTxNum(Integer txNum) {
        this.txNum = txNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentCrossDailyStatistics withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUpdateTime() {
        return updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentCrossDailyStatistics withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", chainId=").append(chainId);
        sb.append(", riskAccountNum=").append(riskAccountNum);
        sb.append(", txNum=").append(txNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}