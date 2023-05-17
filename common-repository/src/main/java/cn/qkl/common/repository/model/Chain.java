package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class Chain {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String chainName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String chainCryptoUnit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String chainLogoUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Chain withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getChainName() {
        return chainName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Chain withChainName(String chainName) {
        this.setChainName(chainName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getChainCryptoUnit() {
        return chainCryptoUnit;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Chain withChainCryptoUnit(String chainCryptoUnit) {
        this.setChainCryptoUnit(chainCryptoUnit);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChainCryptoUnit(String chainCryptoUnit) {
        this.chainCryptoUnit = chainCryptoUnit;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getChainLogoUrl() {
        return chainLogoUrl;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Chain withChainLogoUrl(String chainLogoUrl) {
        this.setChainLogoUrl(chainLogoUrl);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChainLogoUrl(String chainLogoUrl) {
        this.chainLogoUrl = chainLogoUrl;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Chain withCreateTime(Date createTime) {
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
    public Chain withUpdateTime(Date updateTime) {
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
        sb.append(", chainName=").append(chainName);
        sb.append(", chainCryptoUnit=").append(chainCryptoUnit);
        sb.append(", chainLogoUrl=").append(chainLogoUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}