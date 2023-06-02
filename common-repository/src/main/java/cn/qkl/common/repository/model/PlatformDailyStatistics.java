package cn.qkl.common.repository.model;

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
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer highRiskTx;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer middleRiskTx;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer lowRiskTx;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer storageRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer carrierRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer categoryRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String storageProviderName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String carrierName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String categoryName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskIndex;

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
    public Integer getStorageRatio() {
        return storageRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withStorageRatio(Integer storageRatio) {
        this.setStorageRatio(storageRatio);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStorageRatio(Integer storageRatio) {
        this.storageRatio = storageRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCarrierRatio() {
        return carrierRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withCarrierRatio(Integer carrierRatio) {
        this.setCarrierRatio(carrierRatio);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCarrierRatio(Integer carrierRatio) {
        this.carrierRatio = carrierRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCategoryRatio() {
        return categoryRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withCategoryRatio(Integer categoryRatio) {
        this.setCategoryRatio(categoryRatio);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategoryRatio(Integer categoryRatio) {
        this.categoryRatio = categoryRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getStorageProviderName() {
        return storageProviderName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withStorageProviderName(String storageProviderName) {
        this.setStorageProviderName(storageProviderName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStorageProviderName(String storageProviderName) {
        this.storageProviderName = storageProviderName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCarrierName() {
        return carrierName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withCarrierName(String carrierName) {
        this.setCarrierName(carrierName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCategoryName() {
        return categoryName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public PlatformDailyStatistics withCategoryName(String categoryName) {
        this.setCategoryName(categoryName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", highRiskTx=").append(highRiskTx);
        sb.append(", middleRiskTx=").append(middleRiskTx);
        sb.append(", lowRiskTx=").append(lowRiskTx);
        sb.append(", storageRatio=").append(storageRatio);
        sb.append(", carrierRatio=").append(carrierRatio);
        sb.append(", categoryRatio=").append(categoryRatio);
        sb.append(", storageProviderName=").append(storageProviderName);
        sb.append(", carrierName=").append(carrierName);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", riskIndex=").append(riskIndex);
        sb.append("]");
        return sb.toString();
    }
}