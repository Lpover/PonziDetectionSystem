package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class RiskContentStatistics {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer lowRiskNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer middleRiskNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer highRiskNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskContentStatistics withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskContentStatistics withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getLowRiskNum() {
        return lowRiskNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskContentStatistics withLowRiskNum(Integer lowRiskNum) {
        this.setLowRiskNum(lowRiskNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLowRiskNum(Integer lowRiskNum) {
        this.lowRiskNum = lowRiskNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMiddleRiskNum() {
        return middleRiskNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskContentStatistics withMiddleRiskNum(Integer middleRiskNum) {
        this.setMiddleRiskNum(middleRiskNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMiddleRiskNum(Integer middleRiskNum) {
        this.middleRiskNum = middleRiskNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHighRiskNum() {
        return highRiskNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskContentStatistics withHighRiskNum(Integer highRiskNum) {
        this.setHighRiskNum(highRiskNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHighRiskNum(Integer highRiskNum) {
        this.highRiskNum = highRiskNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getPlatformId() {
        return platformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskContentStatistics withPlatformId(Long platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUpdateTime() {
        return updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskContentStatistics withUpdateTime(Date updateTime) {
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
        sb.append(", createTime=").append(createTime);
        sb.append(", lowRiskNum=").append(lowRiskNum);
        sb.append(", middleRiskNum=").append(middleRiskNum);
        sb.append(", highRiskNum=").append(highRiskNum);
        sb.append(", platformId=").append(platformId);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}