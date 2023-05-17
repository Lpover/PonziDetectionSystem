package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class Account {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String accountAddress;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long chainId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String accountAlias;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String image;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String cryptoBalance;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String currencyBalance;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String exchangeRate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAccountAddress() {
        return accountAddress;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withAccountAddress(String accountAddress) {
        this.setAccountAddress(accountAddress);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getChainId() {
        return chainId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withChainId(Long chainId) {
        this.setChainId(chainId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAccountAlias() {
        return accountAlias;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withAccountAlias(String accountAlias) {
        this.setAccountAlias(accountAlias);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAccountAlias(String accountAlias) {
        this.accountAlias = accountAlias;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getImage() {
        return image;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withImage(String image) {
        this.setImage(image);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setImage(String image) {
        this.image = image;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCryptoBalance() {
        return cryptoBalance;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withCryptoBalance(String cryptoBalance) {
        this.setCryptoBalance(cryptoBalance);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCryptoBalance(String cryptoBalance) {
        this.cryptoBalance = cryptoBalance;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCurrencyBalance() {
        return currencyBalance;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withCurrencyBalance(String currencyBalance) {
        this.setCurrencyBalance(currencyBalance);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCurrencyBalance(String currencyBalance) {
        this.currencyBalance = currencyBalance;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getExchangeRate() {
        return exchangeRate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withExchangeRate(String exchangeRate) {
        this.setExchangeRate(exchangeRate);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withCreateTime(Date createTime) {
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
    public Account withUpdateTime(Date updateTime) {
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
        sb.append(", accountAddress=").append(accountAddress);
        sb.append(", chainId=").append(chainId);
        sb.append(", accountAlias=").append(accountAlias);
        sb.append(", image=").append(image);
        sb.append(", cryptoBalance=").append(cryptoBalance);
        sb.append(", currencyBalance=").append(currencyBalance);
        sb.append(", exchangeRate=").append(exchangeRate);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}