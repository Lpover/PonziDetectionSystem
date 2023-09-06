package cn.qkl.common.repository.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;

public class AccountToAccount {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String from;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String to;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer fromRiskIndex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer toRiskIndex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long txAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long txNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal fromRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal toRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String note;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String protocols;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String label;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long toAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long fromAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long toNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long fromNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long toCounter;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long fromCounter;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long chainId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getFrom() {
        return from;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withFrom(String from) {
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
    public AccountToAccount withTo(String to) {
        this.setTo(to);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTo(String to) {
        this.to = to;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getFromRiskIndex() {
        return fromRiskIndex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withFromRiskIndex(Integer fromRiskIndex) {
        this.setFromRiskIndex(fromRiskIndex);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFromRiskIndex(Integer fromRiskIndex) {
        this.fromRiskIndex = fromRiskIndex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getToRiskIndex() {
        return toRiskIndex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withToRiskIndex(Integer toRiskIndex) {
        this.setToRiskIndex(toRiskIndex);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setToRiskIndex(Integer toRiskIndex) {
        this.toRiskIndex = toRiskIndex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getTxAmount() {
        return txAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withTxAmount(Long txAmount) {
        this.setTxAmount(txAmount);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTxAmount(Long txAmount) {
        this.txAmount = txAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getTxNum() {
        return txNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withTxNum(Long txNum) {
        this.setTxNum(txNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTxNum(Long txNum) {
        this.txNum = txNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getFromRatio() {
        return fromRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withFromRatio(BigDecimal fromRatio) {
        this.setFromRatio(fromRatio);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFromRatio(BigDecimal fromRatio) {
        this.fromRatio = fromRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getToRatio() {
        return toRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withToRatio(BigDecimal toRatio) {
        this.setToRatio(toRatio);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setToRatio(BigDecimal toRatio) {
        this.toRatio = toRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getNote() {
        return note;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withNote(String note) {
        this.setNote(note);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNote(String note) {
        this.note = note;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withCreateTime(Date createTime) {
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
    public AccountToAccount withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getProtocols() {
        return protocols;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withProtocols(String protocols) {
        this.setProtocols(protocols);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setProtocols(String protocols) {
        this.protocols = protocols;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getLabel() {
        return label;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withLabel(String label) {
        this.setLabel(label);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLabel(String label) {
        this.label = label;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getToAmount() {
        return toAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withToAmount(Long toAmount) {
        this.setToAmount(toAmount);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setToAmount(Long toAmount) {
        this.toAmount = toAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getFromAmount() {
        return fromAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withFromAmount(Long fromAmount) {
        this.setFromAmount(fromAmount);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFromAmount(Long fromAmount) {
        this.fromAmount = fromAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getToNum() {
        return toNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withToNum(Long toNum) {
        this.setToNum(toNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setToNum(Long toNum) {
        this.toNum = toNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getFromNum() {
        return fromNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withFromNum(Long fromNum) {
        this.setFromNum(fromNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFromNum(Long fromNum) {
        this.fromNum = fromNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getToCounter() {
        return toCounter;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withToCounter(Long toCounter) {
        this.setToCounter(toCounter);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setToCounter(Long toCounter) {
        this.toCounter = toCounter;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getFromCounter() {
        return fromCounter;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withFromCounter(Long fromCounter) {
        this.setFromCounter(fromCounter);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFromCounter(Long fromCounter) {
        this.fromCounter = fromCounter;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getChainId() {
        return chainId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AccountToAccount withChainId(Long chainId) {
        this.setChainId(chainId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", from=").append(from);
        sb.append(", to=").append(to);
        sb.append(", fromRiskIndex=").append(fromRiskIndex);
        sb.append(", toRiskIndex=").append(toRiskIndex);
        sb.append(", txAmount=").append(txAmount);
        sb.append(", txNum=").append(txNum);
        sb.append(", fromRatio=").append(fromRatio);
        sb.append(", toRatio=").append(toRatio);
        sb.append(", note=").append(note);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", protocols=").append(protocols);
        sb.append(", label=").append(label);
        sb.append(", toAmount=").append(toAmount);
        sb.append(", fromAmount=").append(fromAmount);
        sb.append(", toNum=").append(toNum);
        sb.append(", fromNum=").append(fromNum);
        sb.append(", toCounter=").append(toCounter);
        sb.append(", fromCounter=").append(fromCounter);
        sb.append(", chainId=").append(chainId);
        sb.append("]");
        return sb.toString();
    }
}