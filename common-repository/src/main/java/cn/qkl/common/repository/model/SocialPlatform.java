package cn.qkl.common.repository.model;

import java.math.BigDecimal;
import javax.annotation.Generated;

public class SocialPlatform {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal socialPlatformIndex12h;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal socialPlatformIndex24h;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SocialPlatform withId(Long id) {
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
    public SocialPlatform withName(String name) {
        this.setName(name);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getSocialPlatformIndex12h() {
        return socialPlatformIndex12h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SocialPlatform withSocialPlatformIndex12h(BigDecimal socialPlatformIndex12h) {
        this.setSocialPlatformIndex12h(socialPlatformIndex12h);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSocialPlatformIndex12h(BigDecimal socialPlatformIndex12h) {
        this.socialPlatformIndex12h = socialPlatformIndex12h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getSocialPlatformIndex24h() {
        return socialPlatformIndex24h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SocialPlatform withSocialPlatformIndex24h(BigDecimal socialPlatformIndex24h) {
        this.setSocialPlatformIndex24h(socialPlatformIndex24h);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSocialPlatformIndex24h(BigDecimal socialPlatformIndex24h) {
        this.socialPlatformIndex24h = socialPlatformIndex24h;
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
        sb.append(", socialPlatformIndex12h=").append(socialPlatformIndex12h);
        sb.append(", socialPlatformIndex24h=").append(socialPlatformIndex24h);
        sb.append("]");
        return sb.toString();
    }
}