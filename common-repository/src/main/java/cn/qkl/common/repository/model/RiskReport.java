package cn.qkl.common.repository.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;

public class RiskReport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer evolutionNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer highAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer midAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer lowAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String nftName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer nftNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String web3Name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer web3Num;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer highContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer midContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer lowContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer dynNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer monitorNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String highRiskPlat;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String midRiskPlat;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String lowRiskPlat;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal highRiskPlatPer;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal midRiskPlatPer;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal lowRiskPlatPer;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String highNamePlat;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer highNumPlat;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRiskContentNum() {
        return riskContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withRiskContentNum(Integer riskContentNum) {
        this.setRiskContentNum(riskContentNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskContentNum(Integer riskContentNum) {
        this.riskContentNum = riskContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getEvolutionNum() {
        return evolutionNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withEvolutionNum(Integer evolutionNum) {
        this.setEvolutionNum(evolutionNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEvolutionNum(Integer evolutionNum) {
        this.evolutionNum = evolutionNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHighAccountNum() {
        return highAccountNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withHighAccountNum(Integer highAccountNum) {
        this.setHighAccountNum(highAccountNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHighAccountNum(Integer highAccountNum) {
        this.highAccountNum = highAccountNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMidAccountNum() {
        return midAccountNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withMidAccountNum(Integer midAccountNum) {
        this.setMidAccountNum(midAccountNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMidAccountNum(Integer midAccountNum) {
        this.midAccountNum = midAccountNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getLowAccountNum() {
        return lowAccountNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withLowAccountNum(Integer lowAccountNum) {
        this.setLowAccountNum(lowAccountNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLowAccountNum(Integer lowAccountNum) {
        this.lowAccountNum = lowAccountNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getNftName() {
        return nftName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withNftName(String nftName) {
        this.setNftName(nftName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNftName(String nftName) {
        this.nftName = nftName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getNftNum() {
        return nftNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withNftNum(Integer nftNum) {
        this.setNftNum(nftNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNftNum(Integer nftNum) {
        this.nftNum = nftNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getWeb3Name() {
        return web3Name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withWeb3Name(String web3Name) {
        this.setWeb3Name(web3Name);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWeb3Name(String web3Name) {
        this.web3Name = web3Name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getWeb3Num() {
        return web3Num;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withWeb3Num(Integer web3Num) {
        this.setWeb3Num(web3Num);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWeb3Num(Integer web3Num) {
        this.web3Num = web3Num;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHighContentNum() {
        return highContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withHighContentNum(Integer highContentNum) {
        this.setHighContentNum(highContentNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHighContentNum(Integer highContentNum) {
        this.highContentNum = highContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMidContentNum() {
        return midContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withMidContentNum(Integer midContentNum) {
        this.setMidContentNum(midContentNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMidContentNum(Integer midContentNum) {
        this.midContentNum = midContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getLowContentNum() {
        return lowContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withLowContentNum(Integer lowContentNum) {
        this.setLowContentNum(lowContentNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLowContentNum(Integer lowContentNum) {
        this.lowContentNum = lowContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getDynNum() {
        return dynNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withDynNum(Integer dynNum) {
        this.setDynNum(dynNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDynNum(Integer dynNum) {
        this.dynNum = dynNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMonitorNum() {
        return monitorNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withMonitorNum(Integer monitorNum) {
        this.setMonitorNum(monitorNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMonitorNum(Integer monitorNum) {
        this.monitorNum = monitorNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getHighRiskPlat() {
        return highRiskPlat;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withHighRiskPlat(String highRiskPlat) {
        this.setHighRiskPlat(highRiskPlat);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHighRiskPlat(String highRiskPlat) {
        this.highRiskPlat = highRiskPlat;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getMidRiskPlat() {
        return midRiskPlat;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withMidRiskPlat(String midRiskPlat) {
        this.setMidRiskPlat(midRiskPlat);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMidRiskPlat(String midRiskPlat) {
        this.midRiskPlat = midRiskPlat;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getLowRiskPlat() {
        return lowRiskPlat;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withLowRiskPlat(String lowRiskPlat) {
        this.setLowRiskPlat(lowRiskPlat);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLowRiskPlat(String lowRiskPlat) {
        this.lowRiskPlat = lowRiskPlat;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getHighRiskPlatPer() {
        return highRiskPlatPer;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withHighRiskPlatPer(BigDecimal highRiskPlatPer) {
        this.setHighRiskPlatPer(highRiskPlatPer);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHighRiskPlatPer(BigDecimal highRiskPlatPer) {
        this.highRiskPlatPer = highRiskPlatPer;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getMidRiskPlatPer() {
        return midRiskPlatPer;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withMidRiskPlatPer(BigDecimal midRiskPlatPer) {
        this.setMidRiskPlatPer(midRiskPlatPer);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMidRiskPlatPer(BigDecimal midRiskPlatPer) {
        this.midRiskPlatPer = midRiskPlatPer;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getLowRiskPlatPer() {
        return lowRiskPlatPer;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withLowRiskPlatPer(BigDecimal lowRiskPlatPer) {
        this.setLowRiskPlatPer(lowRiskPlatPer);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLowRiskPlatPer(BigDecimal lowRiskPlatPer) {
        this.lowRiskPlatPer = lowRiskPlatPer;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getHighNamePlat() {
        return highNamePlat;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withHighNamePlat(String highNamePlat) {
        this.setHighNamePlat(highNamePlat);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHighNamePlat(String highNamePlat) {
        this.highNamePlat = highNamePlat;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHighNumPlat() {
        return highNumPlat;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withHighNumPlat(Integer highNumPlat) {
        this.setHighNumPlat(highNumPlat);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHighNumPlat(Integer highNumPlat) {
        this.highNumPlat = highNumPlat;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public RiskReport withCreateTime(Date createTime) {
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
    public RiskReport withUpdateTime(Date updateTime) {
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
        sb.append(", riskContentNum=").append(riskContentNum);
        sb.append(", evolutionNum=").append(evolutionNum);
        sb.append(", highAccountNum=").append(highAccountNum);
        sb.append(", midAccountNum=").append(midAccountNum);
        sb.append(", lowAccountNum=").append(lowAccountNum);
        sb.append(", nftName=").append(nftName);
        sb.append(", nftNum=").append(nftNum);
        sb.append(", web3Name=").append(web3Name);
        sb.append(", web3Num=").append(web3Num);
        sb.append(", highContentNum=").append(highContentNum);
        sb.append(", midContentNum=").append(midContentNum);
        sb.append(", lowContentNum=").append(lowContentNum);
        sb.append(", dynNum=").append(dynNum);
        sb.append(", monitorNum=").append(monitorNum);
        sb.append(", highRiskPlat=").append(highRiskPlat);
        sb.append(", midRiskPlat=").append(midRiskPlat);
        sb.append(", lowRiskPlat=").append(lowRiskPlat);
        sb.append(", highRiskPlatPer=").append(highRiskPlatPer);
        sb.append(", midRiskPlatPer=").append(midRiskPlatPer);
        sb.append(", lowRiskPlatPer=").append(lowRiskPlatPer);
        sb.append(", highNamePlat=").append(highNamePlat);
        sb.append(", highNumPlat=").append(highNumPlat);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}