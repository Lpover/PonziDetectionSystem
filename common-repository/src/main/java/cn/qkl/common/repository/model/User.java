package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class User {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userPwd;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userPhone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userRole;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userImgUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userSex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date userRegdate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userIntro;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String randomnum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer state;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUserId() {
        return userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withUserId(Long userId) {
        this.setUserId(userId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserNum() {
        return userNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withUserNum(String userNum) {
        this.setUserNum(userNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserPwd() {
        return userPwd;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withUserPwd(String userPwd) {
        this.setUserPwd(userPwd);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserPhone() {
        return userPhone;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withUserPhone(String userPhone) {
        this.setUserPhone(userPhone);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserRole() {
        return userRole;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withUserRole(String userRole) {
        this.setUserRole(userRole);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserName() {
        return userName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserImgUrl() {
        return userImgUrl;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withUserImgUrl(String userImgUrl) {
        this.setUserImgUrl(userImgUrl);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserSex() {
        return userSex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withUserSex(String userSex) {
        this.setUserSex(userSex);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUserRegdate() {
        return userRegdate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withUserRegdate(Date userRegdate) {
        this.setUserRegdate(userRegdate);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserRegdate(Date userRegdate) {
        this.userRegdate = userRegdate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserIntro() {
        return userIntro;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withUserIntro(String userIntro) {
        this.setUserIntro(userIntro);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRandomnum() {
        return randomnum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withRandomnum(String randomnum) {
        this.setRandomnum(randomnum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRandomnum(String randomnum) {
        this.randomnum = randomnum;
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getEmail() {
        return email;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User withEmail(String email) {
        this.setEmail(email);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userNum=").append(userNum);
        sb.append(", userPwd=").append(userPwd);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userRole=").append(userRole);
        sb.append(", userName=").append(userName);
        sb.append(", userImgUrl=").append(userImgUrl);
        sb.append(", userSex=").append(userSex);
        sb.append(", userRegdate=").append(userRegdate);
        sb.append(", userIntro=").append(userIntro);
        sb.append(", randomnum=").append(randomnum);
        sb.append(", state=").append(state);
        sb.append(", email=").append(email);
        sb.append("]");
        return sb.toString();
    }
}