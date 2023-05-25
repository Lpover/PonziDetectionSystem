package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class Platform {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String url;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer monitor;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long riskContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer activation;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskLevel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer platformType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String logo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer location;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer frequency;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String crawlerFile;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer web3Type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long contentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer highAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer midAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer lowAccountNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer highContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer midContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer lowContentNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withName(String name) {
        this.setName(name);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUrl() {
        return url;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUrl(String url) {
        this.url = url;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMonitor() {
        return monitor;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withMonitor(Integer monitor) {
        this.setMonitor(monitor);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMonitor(Integer monitor) {
        this.monitor = monitor;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getRiskContentNum() {
        return riskContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withRiskContentNum(Long riskContentNum) {
        this.setRiskContentNum(riskContentNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskContentNum(Long riskContentNum) {
        this.riskContentNum = riskContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getActivation() {
        return activation;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withActivation(Integer activation) {
        this.setActivation(activation);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setActivation(Integer activation) {
        this.activation = activation;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRiskLevel() {
        return riskLevel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withRiskLevel(Integer riskLevel) {
        this.setRiskLevel(riskLevel);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPlatformType() {
        return platformType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withPlatformType(Integer platformType) {
        this.setPlatformType(platformType);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getLogo() {
        return logo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withLogo(String logo) {
        this.setLogo(logo);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getLocation() {
        return location;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withLocation(Integer location) {
        this.setLocation(location);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLocation(Integer location) {
        this.location = location;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getFrequency() {
        return frequency;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withFrequency(Integer frequency) {
        this.setFrequency(frequency);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCrawlerFile() {
        return crawlerFile;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withCrawlerFile(String crawlerFile) {
        this.setCrawlerFile(crawlerFile);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCrawlerFile(String crawlerFile) {
        this.crawlerFile = crawlerFile;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getWeb3Type() {
        return web3Type;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withWeb3Type(Integer web3Type) {
        this.setWeb3Type(web3Type);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWeb3Type(Integer web3Type) {
        this.web3Type = web3Type;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getContentNum() {
        return contentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withContentNum(Long contentNum) {
        this.setContentNum(contentNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setContentNum(Long contentNum) {
        this.contentNum = contentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHighAccountNum() {
        return highAccountNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withHighAccountNum(Integer highAccountNum) {
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
    public Platform withMidAccountNum(Integer midAccountNum) {
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
    public Platform withLowAccountNum(Integer lowAccountNum) {
        this.setLowAccountNum(lowAccountNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLowAccountNum(Integer lowAccountNum) {
        this.lowAccountNum = lowAccountNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHighContentNum() {
        return highContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withHighContentNum(Integer highContentNum) {
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
    public Platform withMidContentNum(Integer midContentNum) {
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
    public Platform withLowContentNum(Integer lowContentNum) {
        this.setLowContentNum(lowContentNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLowContentNum(Integer lowContentNum) {
        this.lowContentNum = lowContentNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withCreateTime(Date createTime) {
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
    public Platform withUpdateTime(Date updateTime) {
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
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", monitor=").append(monitor);
        sb.append(", riskContentNum=").append(riskContentNum);
        sb.append(", activation=").append(activation);
        sb.append(", riskLevel=").append(riskLevel);
        sb.append(", platformType=").append(platformType);
        sb.append(", logo=").append(logo);
        sb.append(", location=").append(location);
        sb.append(", frequency=").append(frequency);
        sb.append(", crawlerFile=").append(crawlerFile);
        sb.append(", web3Type=").append(web3Type);
        sb.append(", contentNum=").append(contentNum);
        sb.append(", highAccountNum=").append(highAccountNum);
        sb.append(", midAccountNum=").append(midAccountNum);
        sb.append(", lowAccountNum=").append(lowAccountNum);
        sb.append(", highContentNum=").append(highContentNum);
        sb.append(", midContentNum=").append(midContentNum);
        sb.append(", lowContentNum=").append(lowContentNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}