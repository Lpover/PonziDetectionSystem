package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class AccountContent {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long contentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long accountId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer sourceType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountContent withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getContentId() {
        return contentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountContent withContentId(Long contentId) {
        this.setContentId(contentId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getType() {
        return type;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountContent withType(Boolean type) {
        this.setType(type);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setType(Boolean type) {
        this.type = type;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getAccountId() {
        return accountId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountContent withAccountId(Long accountId) {
        this.setAccountId(accountId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getSourceType() {
        return sourceType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountContent withSourceType(Integer sourceType) {
        this.setSourceType(sourceType);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountContent withCreateTime(Date createTime) {
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
    public AccountContent withUpdateTime(Date updateTime) {
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
        sb.append(", contentId=").append(contentId);
        sb.append(", type=").append(type);
        sb.append(", accountId=").append(accountId);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}