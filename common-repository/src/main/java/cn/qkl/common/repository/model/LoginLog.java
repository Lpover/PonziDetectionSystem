package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class LoginLog {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String ip;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String apiName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String apiRouter;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date time;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String detail;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LoginLog withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUserId() {
        return userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LoginLog withUserId(Long userId) {
        this.setUserId(userId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getIp() {
        return ip;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LoginLog withIp(String ip) {
        this.setIp(ip);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getApiName() {
        return apiName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LoginLog withApiName(String apiName) {
        this.setApiName(apiName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getApiRouter() {
        return apiRouter;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LoginLog withApiRouter(String apiRouter) {
        this.setApiRouter(apiRouter);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setApiRouter(String apiRouter) {
        this.apiRouter = apiRouter;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getTime() {
        return time;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LoginLog withTime(Date time) {
        this.setTime(time);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTime(Date time) {
        this.time = time;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDetail() {
        return detail;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LoginLog withDetail(String detail) {
        this.setDetail(detail);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", ip=").append(ip);
        sb.append(", apiName=").append(apiName);
        sb.append(", apiRouter=").append(apiRouter);
        sb.append(", time=").append(time);
        sb.append(", detail=").append(detail);
        sb.append("]");
        return sb.toString();
    }
}