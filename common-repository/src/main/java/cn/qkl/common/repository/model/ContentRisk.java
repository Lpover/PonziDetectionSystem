package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class ContentRisk {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String category;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long num;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentRisk withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCategory() {
        return category;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentRisk withCategory(String category) {
        this.setCategory(category);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategory(String category) {
        this.category = category;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getNum() {
        return num;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentRisk withNum(Long num) {
        this.setNum(num);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNum(Long num) {
        this.num = num;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentRisk withCreateTime(Date createTime) {
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
    public ContentRisk withUpdateTime(Date updateTime) {
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
        sb.append(", category=").append(category);
        sb.append(", num=").append(num);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}