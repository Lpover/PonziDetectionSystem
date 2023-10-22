package cn.qkl.common.repository.model;

import java.math.BigDecimal;
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
    private BigDecimal riskIndexChina;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal riskIndexOversea;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long hotness;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer webEvidenceCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer mobileEvidenceCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer reinforceEvidenceCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal hotnessChange24h;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal hotnessChange7d;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal hotnessChange30d;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long hotness24h;

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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getRiskIndexChina() {
        return riskIndexChina;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withRiskIndexChina(BigDecimal riskIndexChina) {
        this.setRiskIndexChina(riskIndexChina);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskIndexChina(BigDecimal riskIndexChina) {
        this.riskIndexChina = riskIndexChina;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getRiskIndexOversea() {
        return riskIndexOversea;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withRiskIndexOversea(BigDecimal riskIndexOversea) {
        this.setRiskIndexOversea(riskIndexOversea);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskIndexOversea(BigDecimal riskIndexOversea) {
        this.riskIndexOversea = riskIndexOversea;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getHotness() {
        return hotness;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withHotness(Long hotness) {
        this.setHotness(hotness);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHotness(Long hotness) {
        this.hotness = hotness;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getWebEvidenceCount() {
        return webEvidenceCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withWebEvidenceCount(Integer webEvidenceCount) {
        this.setWebEvidenceCount(webEvidenceCount);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWebEvidenceCount(Integer webEvidenceCount) {
        this.webEvidenceCount = webEvidenceCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMobileEvidenceCount() {
        return mobileEvidenceCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withMobileEvidenceCount(Integer mobileEvidenceCount) {
        this.setMobileEvidenceCount(mobileEvidenceCount);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMobileEvidenceCount(Integer mobileEvidenceCount) {
        this.mobileEvidenceCount = mobileEvidenceCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getReinforceEvidenceCount() {
        return reinforceEvidenceCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withReinforceEvidenceCount(Integer reinforceEvidenceCount) {
        this.setReinforceEvidenceCount(reinforceEvidenceCount);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReinforceEvidenceCount(Integer reinforceEvidenceCount) {
        this.reinforceEvidenceCount = reinforceEvidenceCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getHotnessChange24h() {
        return hotnessChange24h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withHotnessChange24h(BigDecimal hotnessChange24h) {
        this.setHotnessChange24h(hotnessChange24h);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHotnessChange24h(BigDecimal hotnessChange24h) {
        this.hotnessChange24h = hotnessChange24h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getHotnessChange7d() {
        return hotnessChange7d;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withHotnessChange7d(BigDecimal hotnessChange7d) {
        this.setHotnessChange7d(hotnessChange7d);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHotnessChange7d(BigDecimal hotnessChange7d) {
        this.hotnessChange7d = hotnessChange7d;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getHotnessChange30d() {
        return hotnessChange30d;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withHotnessChange30d(BigDecimal hotnessChange30d) {
        this.setHotnessChange30d(hotnessChange30d);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHotnessChange30d(BigDecimal hotnessChange30d) {
        this.hotnessChange30d = hotnessChange30d;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getHotness24h() {
        return hotness24h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Platform withHotness24h(Long hotness24h) {
        this.setHotness24h(hotness24h);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHotness24h(Long hotness24h) {
        this.hotness24h = hotness24h;
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
        sb.append(", riskIndexChina=").append(riskIndexChina);
        sb.append(", riskIndexOversea=").append(riskIndexOversea);
        sb.append(", hotness=").append(hotness);
        sb.append(", webEvidenceCount=").append(webEvidenceCount);
        sb.append(", mobileEvidenceCount=").append(mobileEvidenceCount);
        sb.append(", reinforceEvidenceCount=").append(reinforceEvidenceCount);
        sb.append(", hotnessChange24h=").append(hotnessChange24h);
        sb.append(", hotnessChange7d=").append(hotnessChange7d);
        sb.append(", hotnessChange30d=").append(hotnessChange30d);
        sb.append(", hotness24h=").append(hotness24h);
        sb.append("]");
        return sb.toString();
    }
}