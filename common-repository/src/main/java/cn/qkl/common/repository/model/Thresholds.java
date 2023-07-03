package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class Thresholds {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer nowIndex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer setIndex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte on;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer num;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Thresholds withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Thresholds withName(String name) {
        this.setName(name);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getNowIndex() {
        return nowIndex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Thresholds withNowIndex(Integer nowIndex) {
        this.setNowIndex(nowIndex);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNowIndex(Integer nowIndex) {
        this.nowIndex = nowIndex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getSetIndex() {
        return setIndex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Thresholds withSetIndex(Integer setIndex) {
        this.setSetIndex(setIndex);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSetIndex(Integer setIndex) {
        this.setIndex = setIndex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUpdateTime() {
        return updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Thresholds withUpdateTime(Date updateTime) {
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
    public Thresholds withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getOn() {
        return on;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Thresholds withOn(Byte on) {
        this.setOn(on);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOn(Byte on) {
        this.on = on;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getNum() {
        return num;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Thresholds withNum(Integer num) {
        this.setNum(num);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", nowIndex=").append(nowIndex);
        sb.append(", setIndex=").append(setIndex);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", on=").append(on);
        sb.append(", num=").append(num);
        sb.append("]");
        return sb.toString();
    }
}