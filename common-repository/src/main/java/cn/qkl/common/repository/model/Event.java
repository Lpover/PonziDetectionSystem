package cn.qkl.common.repository.model;

import javax.annotation.Generated;

public class Event {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String abstractText;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer hotNum12h;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer hotNum24h;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String imageUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long platformId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Event withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTitle() {
        return title;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Event withTitle(String title) {
        this.setTitle(title);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAbstractText() {
        return abstractText;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Event withAbstractText(String abstractText) {
        this.setAbstractText(abstractText);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHotNum12h() {
        return hotNum12h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Event withHotNum12h(Integer hotNum12h) {
        this.setHotNum12h(hotNum12h);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHotNum12h(Integer hotNum12h) {
        this.hotNum12h = hotNum12h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHotNum24h() {
        return hotNum24h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Event withHotNum24h(Integer hotNum24h) {
        this.setHotNum24h(hotNum24h);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHotNum24h(Integer hotNum24h) {
        this.hotNum24h = hotNum24h;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getImageUrl() {
        return imageUrl;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Event withImageUrl(String imageUrl) {
        this.setImageUrl(imageUrl);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getPlatformId() {
        return platformId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Event withPlatformId(Long platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", abstractText=").append(abstractText);
        sb.append(", hotNum12h=").append(hotNum12h);
        sb.append(", hotNum24h=").append(hotNum24h);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", platformId=").append(platformId);
        sb.append("]");
        return sb.toString();
    }
}