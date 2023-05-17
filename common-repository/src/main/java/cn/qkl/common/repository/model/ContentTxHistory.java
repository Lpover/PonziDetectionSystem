package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class ContentTxHistory {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long contentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean event;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String price;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String from;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String to;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String ownerLogo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentTxHistory withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getContentId() {
        return contentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentTxHistory withContentId(Long contentId) {
        this.setContentId(contentId);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getEvent() {
        return event;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentTxHistory withEvent(Boolean event) {
        this.setEvent(event);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEvent(Boolean event) {
        this.event = event;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPrice() {
        return price;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentTxHistory withPrice(String price) {
        this.setPrice(price);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPrice(String price) {
        this.price = price;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getFrom() {
        return from;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentTxHistory withFrom(String from) {
        this.setFrom(from);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFrom(String from) {
        this.from = from;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTo() {
        return to;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentTxHistory withTo(String to) {
        this.setTo(to);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTo(String to) {
        this.to = to;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getOwnerLogo() {
        return ownerLogo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentTxHistory withOwnerLogo(String ownerLogo) {
        this.setOwnerLogo(ownerLogo);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOwnerLogo(String ownerLogo) {
        this.ownerLogo = ownerLogo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public ContentTxHistory withCreateTime(Date createTime) {
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
    public ContentTxHistory withUpdateTime(Date updateTime) {
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
        sb.append(", contentId=").append(contentId);
        sb.append(", event=").append(event);
        sb.append(", price=").append(price);
        sb.append(", from=").append(from);
        sb.append(", to=").append(to);
        sb.append(", ownerLogo=").append(ownerLogo);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}