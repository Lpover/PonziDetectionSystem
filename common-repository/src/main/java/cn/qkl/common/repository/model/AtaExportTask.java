package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class AtaExportTask {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String address;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer direction;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long lowerLimit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date startTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date endTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String url;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long chainId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date orderTime;

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
    public Integer getDirection() {
        return direction;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withDirection(Integer direction) {
        this.setDirection(direction);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getLowerLimit() {
        return lowerLimit;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withLowerLimit(Long lowerLimit) {
        this.setLowerLimit(lowerLimit);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLowerLimit(Long lowerLimit) {
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUrl() {
        return url;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUrl(String url) {
        this.url = url;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withCreateTime(Date createTime) {
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
    public AtaExportTask withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getChainId() {
        return chainId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withChainId(Long chainId) {
        this.setChainId(chainId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getOrderTime() {
        return orderTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public AtaExportTask withOrderTime(Date orderTime) {
        this.setOrderTime(orderTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", address=").append(address);
        sb.append(", direction=").append(direction);
        sb.append(", lowerLimit=").append(lowerLimit);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", url=").append(url);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", chainId=").append(chainId);
        sb.append(", orderTime=").append(orderTime);
        sb.append("]");
        return sb.toString();
    }
}