package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class AtaExportTask {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String blockchain;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String currencyType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String address;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String direction;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String lowerLimit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date startTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date endTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getBlockchain() {
        return blockchain;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withBlockchain(String blockchain) {
        this.setBlockchain(blockchain);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBlockchain(String blockchain) {
        this.blockchain = blockchain;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCurrencyType() {
        return currencyType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withCurrencyType(String currencyType) {
        this.setCurrencyType(currencyType);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAddress() {
        return address;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAddress(String address) {
        this.address = address;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDirection() {
        return direction;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withDirection(String direction) {
        this.setDirection(direction);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getLowerLimit() {
        return lowerLimit;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withLowerLimit(String lowerLimit) {
        this.setLowerLimit(lowerLimit);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLowerLimit(String lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getStartTime() {
        return startTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withStartTime(Date startTime) {
        this.setStartTime(startTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getEndTime() {
        return endTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withEndTime(Date endTime) {
        this.setEndTime(endTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", blockchain=").append(blockchain);
        sb.append(", currencyType=").append(currencyType);
        sb.append(", address=").append(address);
        sb.append(", direction=").append(direction);
        sb.append(", lowerLimit=").append(lowerLimit);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append("]");
        return sb.toString();
    }
}