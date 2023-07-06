package cn.qkl.common.repository.model;

import java.util.Date;
import javax.annotation.Generated;

public class SwitchTable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer open;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer openWeek;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date startTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date endTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String text;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SwitchTable withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getOpen() {
        return open;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SwitchTable withOpen(Integer open) {
        this.setOpen(open);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOpen(Integer open) {
        this.open = open;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getOpenWeek() {
        return openWeek;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SwitchTable withOpenWeek(Integer openWeek) {
        this.setOpenWeek(openWeek);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOpenWeek(Integer openWeek) {
        this.openWeek = openWeek;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getStartTime() {
        return startTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SwitchTable withStartTime(Date startTime) {
        this.setStartTime(startTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getEndTime() {
        return endTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SwitchTable withEndTime(Date endTime) {
        this.setEndTime(endTime);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getText() {
        return text;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public SwitchTable withText(String text) {
        this.setText(text);
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setText(String text) {
        this.text = text;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", open=").append(open);
        sb.append(", openWeek=").append(openWeek);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", text=").append(text);
        sb.append("]");
        return sb.toString();
    }
}