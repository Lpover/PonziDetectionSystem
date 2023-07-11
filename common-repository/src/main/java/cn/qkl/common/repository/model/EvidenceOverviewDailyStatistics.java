package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class EvidenceOverviewDailyStatistics {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer webEvidenceCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer mobileEvidenceCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer reinforceEvidenceCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public EvidenceOverviewDailyStatistics withId(Long id) {
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
    public EvidenceOverviewDailyStatistics withPlatformId(Long platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getWebEvidenceCount() {
        return webEvidenceCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public EvidenceOverviewDailyStatistics withWebEvidenceCount(Integer webEvidenceCount) {
        this.setWebEvidenceCount(webEvidenceCount);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWebEvidenceCount(Integer webEvidenceCount) {
        this.webEvidenceCount = webEvidenceCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMobileEvidenceCount() {
        return mobileEvidenceCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public EvidenceOverviewDailyStatistics withMobileEvidenceCount(Integer mobileEvidenceCount) {
        this.setMobileEvidenceCount(mobileEvidenceCount);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMobileEvidenceCount(Integer mobileEvidenceCount) {
        this.mobileEvidenceCount = mobileEvidenceCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getReinforceEvidenceCount() {
        return reinforceEvidenceCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public EvidenceOverviewDailyStatistics withReinforceEvidenceCount(Integer reinforceEvidenceCount) {
        this.setReinforceEvidenceCount(reinforceEvidenceCount);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReinforceEvidenceCount(Integer reinforceEvidenceCount) {
        this.reinforceEvidenceCount = reinforceEvidenceCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public EvidenceOverviewDailyStatistics withCreateTime(Date createTime) {
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
    public EvidenceOverviewDailyStatistics withUpdateTime(Date updateTime) {
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
        sb.append(", platformId=").append(platformId);
        sb.append(", webEvidenceCount=").append(webEvidenceCount);
        sb.append(", mobileEvidenceCount=").append(mobileEvidenceCount);
        sb.append(", reinforceEvidenceCount=").append(reinforceEvidenceCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}