package cn.qkl.common.repository.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;

public class PlatformDailyStatistics {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer highRiskNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer middleRiskNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer lowRiskNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer contentSum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer contentRiskSum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer highRiskTx;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer middleRiskTx;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer lowRiskTx;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskIndex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal hotnessChange24h;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal hotnessChange7d;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal hotnessChange30d;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long hotness24h;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getPlatformId() {
        return platformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withPlatformId(Long platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHighRiskNum() {
        return highRiskNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withHighRiskNum(Integer highRiskNum) {
        this.setHighRiskNum(highRiskNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHighRiskNum(Integer highRiskNum) {
        this.highRiskNum = highRiskNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMiddleRiskNum() {
        return middleRiskNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withMiddleRiskNum(Integer middleRiskNum) {
        this.setMiddleRiskNum(middleRiskNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMiddleRiskNum(Integer middleRiskNum) {
        this.middleRiskNum = middleRiskNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getLowRiskNum() {
        return lowRiskNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withLowRiskNum(Integer lowRiskNum) {
        this.setLowRiskNum(lowRiskNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLowRiskNum(Integer lowRiskNum) {
        this.lowRiskNum = lowRiskNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getContentSum() {
        return contentSum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withContentSum(Integer contentSum) {
        this.setContentSum(contentSum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setContentSum(Integer contentSum) {
        this.contentSum = contentSum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getContentRiskSum() {
        return contentRiskSum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withContentRiskSum(Integer contentRiskSum) {
        this.setContentRiskSum(contentRiskSum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setContentRiskSum(Integer contentRiskSum) {
        this.contentRiskSum = contentRiskSum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHighRiskTx() {
        return highRiskTx;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withHighRiskTx(Integer highRiskTx) {
        this.setHighRiskTx(highRiskTx);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHighRiskTx(Integer highRiskTx) {
        this.highRiskTx = highRiskTx;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMiddleRiskTx() {
        return middleRiskTx;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withMiddleRiskTx(Integer middleRiskTx) {
        this.setMiddleRiskTx(middleRiskTx);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMiddleRiskTx(Integer middleRiskTx) {
        this.middleRiskTx = middleRiskTx;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getLowRiskTx() {
        return lowRiskTx;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withLowRiskTx(Integer lowRiskTx) {
        this.setLowRiskTx(lowRiskTx);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLowRiskTx(Integer lowRiskTx) {
        this.lowRiskTx = lowRiskTx;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRiskIndex() {
        return riskIndex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withRiskIndex(Integer riskIndex) {
        this.setRiskIndex(riskIndex);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskIndex(Integer riskIndex) {
        this.riskIndex = riskIndex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUpdateTime() {
        return updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getHotnessChange24h() {
        return hotnessChange24h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withHotnessChange24h(BigDecimal hotnessChange24h) {
        this.setHotnessChange24h(hotnessChange24h);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHotnessChange24h(BigDecimal hotnessChange24h) {
        this.hotnessChange24h = hotnessChange24h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getHotnessChange7d() {
        return hotnessChange7d;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withHotnessChange7d(BigDecimal hotnessChange7d) {
        this.setHotnessChange7d(hotnessChange7d);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHotnessChange7d(BigDecimal hotnessChange7d) {
        this.hotnessChange7d = hotnessChange7d;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getHotnessChange30d() {
        return hotnessChange30d;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withHotnessChange30d(BigDecimal hotnessChange30d) {
        this.setHotnessChange30d(hotnessChange30d);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHotnessChange30d(BigDecimal hotnessChange30d) {
        this.hotnessChange30d = hotnessChange30d;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getHotness24h() {
        return hotness24h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withHotness24h(Long hotness24h) {
        this.setHotness24h(hotness24h);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHotness24h(Long hotness24h) {
        this.hotness24h = hotness24h;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", platformId=").append(platformId);
        sb.append(", highRiskNum=").append(highRiskNum);
        sb.append(", middleRiskNum=").append(middleRiskNum);
        sb.append(", lowRiskNum=").append(lowRiskNum);
        sb.append(", contentSum=").append(contentSum);
        sb.append(", contentRiskSum=").append(contentRiskSum);
        sb.append(", highRiskTx=").append(highRiskTx);
        sb.append(", middleRiskTx=").append(middleRiskTx);
        sb.append(", lowRiskTx=").append(lowRiskTx);
        sb.append(", riskIndex=").append(riskIndex);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", hotnessChange24h=").append(hotnessChange24h);
        sb.append(", hotnessChange7d=").append(hotnessChange7d);
        sb.append(", hotnessChange30d=").append(hotnessChange30d);
        sb.append(", hotness24h=").append(hotness24h);
        sb.append("]");
        return sb.toString();
    }
}