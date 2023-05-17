package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class Statistic {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer highNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer midNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer lowNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Statistic withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHighNum() {
        return highNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Statistic withHighNum(Integer highNum) {
        this.setHighNum(highNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHighNum(Integer highNum) {
        this.highNum = highNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMidNum() {
        return midNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Statistic withMidNum(Integer midNum) {
        this.setMidNum(midNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMidNum(Integer midNum) {
        this.midNum = midNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getLowNum() {
        return lowNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Statistic withLowNum(Integer lowNum) {
        this.setLowNum(lowNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLowNum(Integer lowNum) {
        this.lowNum = lowNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Statistic withCreateTime(Date createTime) {
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
    public Statistic withUpdateTime(Date updateTime) {
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
        sb.append(", highNum=").append(highNum);
        sb.append(", midNum=").append(midNum);
        sb.append(", lowNum=").append(lowNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}