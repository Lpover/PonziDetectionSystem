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
    private Long platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer releaseNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskLevel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String note;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long inflowAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String actionFeatures;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String contentTag;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskTxNumIn;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskTxNumOut;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date recentTxTime;

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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getPlatformId() {
        return platformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withPlatformId(Long platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getReleaseNum() {
        return releaseNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withReleaseNum(Integer releaseNum) {
        this.setReleaseNum(releaseNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReleaseNum(Integer releaseNum) {
        this.releaseNum = releaseNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRiskLevel() {
        return riskLevel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withRiskLevel(Integer riskLevel) {
        this.setRiskLevel(riskLevel);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getNote() {
        return note;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withNote(String note) {
        this.setNote(note);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNote(String note) {
        this.note = note;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getInflowAmount() {
        return inflowAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withInflowAmount(Long inflowAmount) {
        this.setInflowAmount(inflowAmount);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setInflowAmount(Long inflowAmount) {
        this.inflowAmount = inflowAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getActionFeatures() {
        return actionFeatures;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withActionFeatures(String actionFeatures) {
        this.setActionFeatures(actionFeatures);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setActionFeatures(String actionFeatures) {
        this.actionFeatures = actionFeatures;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getContentTag() {
        return contentTag;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withContentTag(String contentTag) {
        this.setContentTag(contentTag);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setContentTag(String contentTag) {
        this.contentTag = contentTag;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRiskTxNumIn() {
        return riskTxNumIn;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withRiskTxNumIn(Integer riskTxNumIn) {
        this.setRiskTxNumIn(riskTxNumIn);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskTxNumIn(Integer riskTxNumIn) {
        this.riskTxNumIn = riskTxNumIn;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRiskTxNumOut() {
        return riskTxNumOut;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withRiskTxNumOut(Integer riskTxNumOut) {
        this.setRiskTxNumOut(riskTxNumOut);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskTxNumOut(Integer riskTxNumOut) {
        this.riskTxNumOut = riskTxNumOut;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRiskContentNum() {
        return riskContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withRiskContentNum(Integer riskContentNum) {
        this.setRiskContentNum(riskContentNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskContentNum(Integer riskContentNum) {
        this.riskContentNum = riskContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getRecentTxTime() {
        return recentTxTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Account withRecentTxTime(Date recentTxTime) {
        this.setRecentTxTime(recentTxTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRecentTxTime(Date recentTxTime) {
        this.recentTxTime = recentTxTime;
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
        sb.append(", platformId=").append(platformId);
        sb.append(", releaseNum=").append(releaseNum);
        sb.append(", riskLevel=").append(riskLevel);
        sb.append(", note=").append(note);
        sb.append(", inflowAmount=").append(inflowAmount);
        sb.append(", actionFeatures=").append(actionFeatures);
        sb.append(", contentTag=").append(contentTag);
        sb.append(", riskTxNumIn=").append(riskTxNumIn);
        sb.append(", riskTxNumOut=").append(riskTxNumOut);
        sb.append(", riskContentNum=").append(riskContentNum);
        sb.append(", recentTxTime=").append(recentTxTime);
        sb.append("]");
        return sb.toString();
    }
}