package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class Carrier {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer carrierNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer carrierType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Carrier withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getPlatformId() {
        return platformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Carrier withPlatformId(Long platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCarrierNumber() {
        return carrierNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Carrier withCarrierNumber(Integer carrierNumber) {
        this.setCarrierNumber(carrierNumber);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCarrierNumber(Integer carrierNumber) {
        this.carrierNumber = carrierNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCarrierType() {
        return carrierType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Carrier withCarrierType(Integer carrierType) {
        this.setCarrierType(carrierType);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCarrierType(Integer carrierType) {
        this.carrierType = carrierType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUpdateTime() {
        return updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Carrier withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Carrier withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", platformId=").append(platformId);
        sb.append(", carrierNumber=").append(carrierNumber);
        sb.append(", carrierType=").append(carrierType);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}