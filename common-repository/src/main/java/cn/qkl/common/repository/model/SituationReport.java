package cn.qkl.common.repository.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;

public class SituationReport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String platformName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer carrierPic;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer carrierVie;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer carrierOth;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer categoryDyn;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer categorySta;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer categoryOth;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer txRatioLow;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer txRatioMid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer txRatioHigh;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskWordMostNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String riskWordMostName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long riskWordLeastNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String riskWordLeastName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer contentNumRatio;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer ratioPositive;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer ratioNegative;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer platRatioHigh;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer platRatioMid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer platRatioLow;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer warningNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String top5TopicsContent;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String top5TopicsSocial;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String top3Words;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer monitorNumHigh;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer monitorNumMid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer monitorNumLow;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String platNameLow;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String platNameMid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String platNameHigh;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String nftPlatformName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long nftPlatformHotness;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal nftPlatformHotnessChange;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String web3PlatformName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long web3PlatformHotness;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal web3PlatformHotnessChange;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String riskNameHigh;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskIndexHigh;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String riskNameLow;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer riskIndexLow;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPlatformName() {
        return platformName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withPlatformName(String platformName) {
        this.setPlatformName(platformName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCarrierPic() {
        return carrierPic;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withCarrierPic(Integer carrierPic) {
        this.setCarrierPic(carrierPic);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCarrierPic(Integer carrierPic) {
        this.carrierPic = carrierPic;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCarrierVie() {
        return carrierVie;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withCarrierVie(Integer carrierVie) {
        this.setCarrierVie(carrierVie);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCarrierVie(Integer carrierVie) {
        this.carrierVie = carrierVie;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCarrierOth() {
        return carrierOth;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withCarrierOth(Integer carrierOth) {
        this.setCarrierOth(carrierOth);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCarrierOth(Integer carrierOth) {
        this.carrierOth = carrierOth;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCategoryDyn() {
        return categoryDyn;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withCategoryDyn(Integer categoryDyn) {
        this.setCategoryDyn(categoryDyn);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategoryDyn(Integer categoryDyn) {
        this.categoryDyn = categoryDyn;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCategorySta() {
        return categorySta;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withCategorySta(Integer categorySta) {
        this.setCategorySta(categorySta);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategorySta(Integer categorySta) {
        this.categorySta = categorySta;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCategoryOth() {
        return categoryOth;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withCategoryOth(Integer categoryOth) {
        this.setCategoryOth(categoryOth);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategoryOth(Integer categoryOth) {
        this.categoryOth = categoryOth;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getTxRatioLow() {
        return txRatioLow;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withTxRatioLow(Integer txRatioLow) {
        this.setTxRatioLow(txRatioLow);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTxRatioLow(Integer txRatioLow) {
        this.txRatioLow = txRatioLow;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getTxRatioMid() {
        return txRatioMid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withTxRatioMid(Integer txRatioMid) {
        this.setTxRatioMid(txRatioMid);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTxRatioMid(Integer txRatioMid) {
        this.txRatioMid = txRatioMid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getTxRatioHigh() {
        return txRatioHigh;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withTxRatioHigh(Integer txRatioHigh) {
        this.setTxRatioHigh(txRatioHigh);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTxRatioHigh(Integer txRatioHigh) {
        this.txRatioHigh = txRatioHigh;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRiskWordMostNum() {
        return riskWordMostNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withRiskWordMostNum(Integer riskWordMostNum) {
        this.setRiskWordMostNum(riskWordMostNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskWordMostNum(Integer riskWordMostNum) {
        this.riskWordMostNum = riskWordMostNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRiskWordMostName() {
        return riskWordMostName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withRiskWordMostName(String riskWordMostName) {
        this.setRiskWordMostName(riskWordMostName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskWordMostName(String riskWordMostName) {
        this.riskWordMostName = riskWordMostName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getRiskWordLeastNum() {
        return riskWordLeastNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withRiskWordLeastNum(Long riskWordLeastNum) {
        this.setRiskWordLeastNum(riskWordLeastNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskWordLeastNum(Long riskWordLeastNum) {
        this.riskWordLeastNum = riskWordLeastNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRiskWordLeastName() {
        return riskWordLeastName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withRiskWordLeastName(String riskWordLeastName) {
        this.setRiskWordLeastName(riskWordLeastName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskWordLeastName(String riskWordLeastName) {
        this.riskWordLeastName = riskWordLeastName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getContentNumRatio() {
        return contentNumRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withContentNumRatio(Integer contentNumRatio) {
        this.setContentNumRatio(contentNumRatio);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setContentNumRatio(Integer contentNumRatio) {
        this.contentNumRatio = contentNumRatio;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRatioPositive() {
        return ratioPositive;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withRatioPositive(Integer ratioPositive) {
        this.setRatioPositive(ratioPositive);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRatioPositive(Integer ratioPositive) {
        this.ratioPositive = ratioPositive;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRatioNegative() {
        return ratioNegative;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withRatioNegative(Integer ratioNegative) {
        this.setRatioNegative(ratioNegative);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRatioNegative(Integer ratioNegative) {
        this.ratioNegative = ratioNegative;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPlatRatioHigh() {
        return platRatioHigh;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withPlatRatioHigh(Integer platRatioHigh) {
        this.setPlatRatioHigh(platRatioHigh);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatRatioHigh(Integer platRatioHigh) {
        this.platRatioHigh = platRatioHigh;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPlatRatioMid() {
        return platRatioMid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withPlatRatioMid(Integer platRatioMid) {
        this.setPlatRatioMid(platRatioMid);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatRatioMid(Integer platRatioMid) {
        this.platRatioMid = platRatioMid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPlatRatioLow() {
        return platRatioLow;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withPlatRatioLow(Integer platRatioLow) {
        this.setPlatRatioLow(platRatioLow);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatRatioLow(Integer platRatioLow) {
        this.platRatioLow = platRatioLow;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getWarningNum() {
        return warningNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withWarningNum(Integer warningNum) {
        this.setWarningNum(warningNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWarningNum(Integer warningNum) {
        this.warningNum = warningNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTop5TopicsContent() {
        return top5TopicsContent;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withTop5TopicsContent(String top5TopicsContent) {
        this.setTop5TopicsContent(top5TopicsContent);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTop5TopicsContent(String top5TopicsContent) {
        this.top5TopicsContent = top5TopicsContent;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTop5TopicsSocial() {
        return top5TopicsSocial;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withTop5TopicsSocial(String top5TopicsSocial) {
        this.setTop5TopicsSocial(top5TopicsSocial);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTop5TopicsSocial(String top5TopicsSocial) {
        this.top5TopicsSocial = top5TopicsSocial;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTop3Words() {
        return top3Words;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withTop3Words(String top3Words) {
        this.setTop3Words(top3Words);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTop3Words(String top3Words) {
        this.top3Words = top3Words;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUpdateTime() {
        return updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withUpdateTime(Date updateTime) {
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
    public SituationReport withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMonitorNumHigh() {
        return monitorNumHigh;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withMonitorNumHigh(Integer monitorNumHigh) {
        this.setMonitorNumHigh(monitorNumHigh);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMonitorNumHigh(Integer monitorNumHigh) {
        this.monitorNumHigh = monitorNumHigh;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMonitorNumMid() {
        return monitorNumMid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withMonitorNumMid(Integer monitorNumMid) {
        this.setMonitorNumMid(monitorNumMid);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMonitorNumMid(Integer monitorNumMid) {
        this.monitorNumMid = monitorNumMid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMonitorNumLow() {
        return monitorNumLow;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withMonitorNumLow(Integer monitorNumLow) {
        this.setMonitorNumLow(monitorNumLow);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMonitorNumLow(Integer monitorNumLow) {
        this.monitorNumLow = monitorNumLow;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPlatNameLow() {
        return platNameLow;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withPlatNameLow(String platNameLow) {
        this.setPlatNameLow(platNameLow);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatNameLow(String platNameLow) {
        this.platNameLow = platNameLow;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPlatNameMid() {
        return platNameMid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withPlatNameMid(String platNameMid) {
        this.setPlatNameMid(platNameMid);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatNameMid(String platNameMid) {
        this.platNameMid = platNameMid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPlatNameHigh() {
        return platNameHigh;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withPlatNameHigh(String platNameHigh) {
        this.setPlatNameHigh(platNameHigh);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatNameHigh(String platNameHigh) {
        this.platNameHigh = platNameHigh;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getNftPlatformName() {
        return nftPlatformName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withNftPlatformName(String nftPlatformName) {
        this.setNftPlatformName(nftPlatformName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNftPlatformName(String nftPlatformName) {
        this.nftPlatformName = nftPlatformName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getNftPlatformHotness() {
        return nftPlatformHotness;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withNftPlatformHotness(Long nftPlatformHotness) {
        this.setNftPlatformHotness(nftPlatformHotness);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNftPlatformHotness(Long nftPlatformHotness) {
        this.nftPlatformHotness = nftPlatformHotness;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getNftPlatformHotnessChange() {
        return nftPlatformHotnessChange;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withNftPlatformHotnessChange(BigDecimal nftPlatformHotnessChange) {
        this.setNftPlatformHotnessChange(nftPlatformHotnessChange);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNftPlatformHotnessChange(BigDecimal nftPlatformHotnessChange) {
        this.nftPlatformHotnessChange = nftPlatformHotnessChange;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getWeb3PlatformName() {
        return web3PlatformName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withWeb3PlatformName(String web3PlatformName) {
        this.setWeb3PlatformName(web3PlatformName);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWeb3PlatformName(String web3PlatformName) {
        this.web3PlatformName = web3PlatformName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getWeb3PlatformHotness() {
        return web3PlatformHotness;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withWeb3PlatformHotness(Long web3PlatformHotness) {
        this.setWeb3PlatformHotness(web3PlatformHotness);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWeb3PlatformHotness(Long web3PlatformHotness) {
        this.web3PlatformHotness = web3PlatformHotness;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getWeb3PlatformHotnessChange() {
        return web3PlatformHotnessChange;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withWeb3PlatformHotnessChange(BigDecimal web3PlatformHotnessChange) {
        this.setWeb3PlatformHotnessChange(web3PlatformHotnessChange);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWeb3PlatformHotnessChange(BigDecimal web3PlatformHotnessChange) {
        this.web3PlatformHotnessChange = web3PlatformHotnessChange;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRiskNameHigh() {
        return riskNameHigh;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withRiskNameHigh(String riskNameHigh) {
        this.setRiskNameHigh(riskNameHigh);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskNameHigh(String riskNameHigh) {
        this.riskNameHigh = riskNameHigh;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRiskIndexHigh() {
        return riskIndexHigh;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withRiskIndexHigh(Integer riskIndexHigh) {
        this.setRiskIndexHigh(riskIndexHigh);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskIndexHigh(Integer riskIndexHigh) {
        this.riskIndexHigh = riskIndexHigh;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRiskNameLow() {
        return riskNameLow;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withRiskNameLow(String riskNameLow) {
        this.setRiskNameLow(riskNameLow);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskNameLow(String riskNameLow) {
        this.riskNameLow = riskNameLow;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRiskIndexLow() {
        return riskIndexLow;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SituationReport withRiskIndexLow(Integer riskIndexLow) {
        this.setRiskIndexLow(riskIndexLow);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRiskIndexLow(Integer riskIndexLow) {
        this.riskIndexLow = riskIndexLow;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", platformName=").append(platformName);
        sb.append(", carrierPic=").append(carrierPic);
        sb.append(", carrierVie=").append(carrierVie);
        sb.append(", carrierOth=").append(carrierOth);
        sb.append(", categoryDyn=").append(categoryDyn);
        sb.append(", categorySta=").append(categorySta);
        sb.append(", categoryOth=").append(categoryOth);
        sb.append(", txRatioLow=").append(txRatioLow);
        sb.append(", txRatioMid=").append(txRatioMid);
        sb.append(", txRatioHigh=").append(txRatioHigh);
        sb.append(", riskWordMostNum=").append(riskWordMostNum);
        sb.append(", riskWordMostName=").append(riskWordMostName);
        sb.append(", riskWordLeastNum=").append(riskWordLeastNum);
        sb.append(", riskWordLeastName=").append(riskWordLeastName);
        sb.append(", contentNumRatio=").append(contentNumRatio);
        sb.append(", ratioPositive=").append(ratioPositive);
        sb.append(", ratioNegative=").append(ratioNegative);
        sb.append(", platRatioHigh=").append(platRatioHigh);
        sb.append(", platRatioMid=").append(platRatioMid);
        sb.append(", platRatioLow=").append(platRatioLow);
        sb.append(", warningNum=").append(warningNum);
        sb.append(", top5TopicsContent=").append(top5TopicsContent);
        sb.append(", top5TopicsSocial=").append(top5TopicsSocial);
        sb.append(", top3Words=").append(top3Words);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", monitorNumHigh=").append(monitorNumHigh);
        sb.append(", monitorNumMid=").append(monitorNumMid);
        sb.append(", monitorNumLow=").append(monitorNumLow);
        sb.append(", platNameLow=").append(platNameLow);
        sb.append(", platNameMid=").append(platNameMid);
        sb.append(", platNameHigh=").append(platNameHigh);
        sb.append(", nftPlatformName=").append(nftPlatformName);
        sb.append(", nftPlatformHotness=").append(nftPlatformHotness);
        sb.append(", nftPlatformHotnessChange=").append(nftPlatformHotnessChange);
        sb.append(", web3PlatformName=").append(web3PlatformName);
        sb.append(", web3PlatformHotness=").append(web3PlatformHotness);
        sb.append(", web3PlatformHotnessChange=").append(web3PlatformHotnessChange);
        sb.append(", riskNameHigh=").append(riskNameHigh);
        sb.append(", riskIndexHigh=").append(riskIndexHigh);
        sb.append(", riskNameLow=").append(riskNameLow);
        sb.append(", riskIndexLow=").append(riskIndexLow);
        sb.append("]");
        return sb.toString();
    }
}