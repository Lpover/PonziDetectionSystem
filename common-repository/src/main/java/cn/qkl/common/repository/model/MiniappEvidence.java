package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class MiniappEvidence {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date time;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date expiredTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String url;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long userid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer preserved;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public MiniappEvidence withId(Long id) {
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
    public MiniappEvidence withName(String name) {
        this.setName(name);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getTime() {
        return time;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public MiniappEvidence withTime(Date time) {
        this.setTime(time);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTime(Date time) {
        this.time = time;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getExpiredTime() {
        return expiredTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public MiniappEvidence withExpiredTime(Date expiredTime) {
        this.setExpiredTime(expiredTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUrl() {
        return url;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public MiniappEvidence withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUrl(String url) {
        this.url = url;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUserid() {
        return userid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public MiniappEvidence withUserid(Long userid) {
        this.setUserid(userid);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPreserved() {
        return preserved;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public MiniappEvidence withPreserved(Integer preserved) {
        this.setPreserved(preserved);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPreserved(Integer preserved) {
        this.preserved = preserved;
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
        sb.append(", time=").append(time);
        sb.append(", expiredTime=").append(expiredTime);
        sb.append(", url=").append(url);
        sb.append(", userid=").append(userid);
        sb.append(", preserved=").append(preserved);
        sb.append("]");
        return sb.toString();
    }
}