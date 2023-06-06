package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class ContentRiskStatistics {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long categoryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long num;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentRiskStatistics withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getCategoryId() {
        return categoryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentRiskStatistics withCategoryId(Long categoryId) {
        this.setCategoryId(categoryId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getNum() {
        return num;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentRiskStatistics withNum(Long num) {
        this.setNum(num);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNum(Long num) {
        this.num = num;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getPlatformId() {
        return platformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentRiskStatistics withPlatformId(Long platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentRiskStatistics withCreateTime(Date createTime) {
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
    public ContentRiskStatistics withUpdateTime(Date updateTime) {
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
        sb.append(", categoryId=").append(categoryId);
        sb.append(", num=").append(num);
        sb.append(", platformId=").append(platformId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}