package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class SocialPlatformHourStatistics {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer socialPlatformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer sensitiveNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer nonSensitiveNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer posEmotionNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer negEmotionNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getSocialPlatformId() {
        return socialPlatformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SocialPlatformHourStatistics withSocialPlatformId(Integer socialPlatformId) {
        this.setSocialPlatformId(socialPlatformId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSocialPlatformId(Integer socialPlatformId) {
        this.socialPlatformId = socialPlatformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SocialPlatformHourStatistics withCreateTime(Date createTime) {
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
    public SocialPlatformHourStatistics withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getSensitiveNum() {
        return sensitiveNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SocialPlatformHourStatistics withSensitiveNum(Integer sensitiveNum) {
        this.setSensitiveNum(sensitiveNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSensitiveNum(Integer sensitiveNum) {
        this.sensitiveNum = sensitiveNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getNonSensitiveNum() {
        return nonSensitiveNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SocialPlatformHourStatistics withNonSensitiveNum(Integer nonSensitiveNum) {
        this.setNonSensitiveNum(nonSensitiveNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNonSensitiveNum(Integer nonSensitiveNum) {
        this.nonSensitiveNum = nonSensitiveNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPosEmotionNum() {
        return posEmotionNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SocialPlatformHourStatistics withPosEmotionNum(Integer posEmotionNum) {
        this.setPosEmotionNum(posEmotionNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPosEmotionNum(Integer posEmotionNum) {
        this.posEmotionNum = posEmotionNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getNegEmotionNum() {
        return negEmotionNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SocialPlatformHourStatistics withNegEmotionNum(Integer negEmotionNum) {
        this.setNegEmotionNum(negEmotionNum);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNegEmotionNum(Integer negEmotionNum) {
        this.negEmotionNum = negEmotionNum;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", socialPlatformId=").append(socialPlatformId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", sensitiveNum=").append(sensitiveNum);
        sb.append(", nonSensitiveNum=").append(nonSensitiveNum);
        sb.append(", posEmotionNum=").append(posEmotionNum);
        sb.append(", negEmotionNum=").append(negEmotionNum);
        sb.append("]");
        return sb.toString();
    }
}