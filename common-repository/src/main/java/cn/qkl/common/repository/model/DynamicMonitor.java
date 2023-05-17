package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class DynamicMonitor {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long contentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskLevel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String contentTag;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public DynamicMonitor withId(Long id) {
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
    public DynamicMonitor withContentId(Long contentId) {
        this.setContentId(contentId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRiskLevel() {
        return riskLevel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public DynamicMonitor withRiskLevel(Integer riskLevel) {
        this.setRiskLevel(riskLevel);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getContentTag() {
        return contentTag;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public DynamicMonitor withContentTag(String contentTag) {
        this.setContentTag(contentTag);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setContentTag(String contentTag) {
        this.contentTag = contentTag;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public DynamicMonitor withCreateTime(Date createTime) {
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
    public DynamicMonitor withUpdateTime(Date updateTime) {
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
        sb.append(", riskLevel=").append(riskLevel);
        sb.append(", contentTag=").append(contentTag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}