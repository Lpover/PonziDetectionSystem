package cn.qkl.common.repository.model;

import javax.annotation.Generated;

public class User {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String pwd;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String phone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer role;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer state;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPwd() {
        return pwd;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withPwd(String pwd) {
        this.setPwd(pwd);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPhone() {
        return phone;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withPhone(String phone) {
        this.setPhone(phone);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRole() {
        return role;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withRole(Integer role) {
        this.setRole(role);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRole(Integer role) {
        this.role = role;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getState() {
        return state;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withState(Integer state) {
        this.setState(state);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pwd=").append(pwd);
        sb.append(", phone=").append(phone);
        sb.append(", role=").append(role);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}