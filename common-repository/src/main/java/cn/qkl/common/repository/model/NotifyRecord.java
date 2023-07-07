package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class NotifyRecord {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String notifyItemIds;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userIds;
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public NotifyRecord withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getNotifyItemIds() {
        return notifyItemIds;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public NotifyRecord withNotifyItemIds(String notifyItemIds) {
        this.setNotifyItemIds(notifyItemIds);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNotifyItemIds(String notifyItemIds) {
        this.notifyItemIds = notifyItemIds;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserIds() {
        return userIds;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public NotifyRecord withUserIds(String userIds) {
        this.setUserIds(userIds);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public NotifyRecord withCreateTime(Date createTime) {
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
    public NotifyRecord withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getStatus() {
        return status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public NotifyRecord withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", notifyItemIds=").append(notifyItemIds);
        sb.append(", userIds=").append(userIds);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}