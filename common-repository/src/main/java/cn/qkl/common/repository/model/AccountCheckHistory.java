package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class AccountCheckHistory {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long accountId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date accountCheckTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean riskLevel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer relatedNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer releaseNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountCheckHistory withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getAccountId() {
        return accountId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountCheckHistory withAccountId(Long accountId) {
        this.setAccountId(accountId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getAccountCheckTime() {
        return accountCheckTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountCheckHistory withAccountCheckTime(Date accountCheckTime) {
        this.setAccountCheckTime(accountCheckTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAccountCheckTime(Date accountCheckTime) {
        this.accountCheckTime = accountCheckTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getRiskLevel() {
        return riskLevel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountCheckHistory withRiskLevel(Boolean riskLevel) {
        this.setRiskLevel(riskLevel);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskLevel(Boolean riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRelatedNum() {
        return relatedNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountCheckHistory withRelatedNum(Integer relatedNum) {
        this.setRelatedNum(relatedNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRelatedNum(Integer relatedNum) {
        this.relatedNum = relatedNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getReleaseNum() {
        return releaseNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountCheckHistory withReleaseNum(Integer releaseNum) {
        this.setReleaseNum(releaseNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReleaseNum(Integer releaseNum) {
        this.releaseNum = releaseNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountCheckHistory withCreateTime(Date createTime) {
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
    public AccountCheckHistory withUpdateTime(Date updateTime) {
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
        sb.append(", accountId=").append(accountId);
        sb.append(", accountCheckTime=").append(accountCheckTime);
        sb.append(", riskLevel=").append(riskLevel);
        sb.append(", relatedNum=").append(relatedNum);
        sb.append(", releaseNum=").append(releaseNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}