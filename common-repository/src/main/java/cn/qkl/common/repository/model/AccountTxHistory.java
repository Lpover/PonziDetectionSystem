package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class AccountTxHistory {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String txHash;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String method;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long block;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date txTimestamp;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String from;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String to;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String value;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String txFee;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long chainId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountTxHistory withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTxHash() {
        return txHash;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountTxHistory withTxHash(String txHash) {
        this.setTxHash(txHash);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getMethod() {
        return method;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountTxHistory withMethod(String method) {
        this.setMethod(method);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMethod(String method) {
        this.method = method;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getBlock() {
        return block;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountTxHistory withBlock(Long block) {
        this.setBlock(block);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBlock(Long block) {
        this.block = block;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getTxTimestamp() {
        return txTimestamp;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountTxHistory withTxTimestamp(Date txTimestamp) {
        this.setTxTimestamp(txTimestamp);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTxTimestamp(Date txTimestamp) {
        this.txTimestamp = txTimestamp;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getFrom() {
        return from;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountTxHistory withFrom(String from) {
        this.setFrom(from);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFrom(String from) {
        this.from = from;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTo() {
        return to;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountTxHistory withTo(String to) {
        this.setTo(to);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTo(String to) {
        this.to = to;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getValue() {
        return value;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountTxHistory withValue(String value) {
        this.setValue(value);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setValue(String value) {
        this.value = value;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTxFee() {
        return txFee;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountTxHistory withTxFee(String txFee) {
        this.setTxFee(txFee);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTxFee(String txFee) {
        this.txFee = txFee;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getChainId() {
        return chainId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountTxHistory withChainId(Long chainId) {
        this.setChainId(chainId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountTxHistory withCreateTime(Date createTime) {
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
    public AccountTxHistory withUpdateTime(Date updateTime) {
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
        sb.append(", txHash=").append(txHash);
        sb.append(", method=").append(method);
        sb.append(", block=").append(block);
        sb.append(", txTimestamp=").append(txTimestamp);
        sb.append(", from=").append(from);
        sb.append(", to=").append(to);
        sb.append(", value=").append(value);
        sb.append(", txFee=").append(txFee);
        sb.append(", chainId=").append(chainId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}