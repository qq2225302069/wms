package com.wms.user.service.bean;

import java.io.Serializable;
import java.util.Date;

public class RoleBean implements Serializable {
    private String id;
    private String name; //角色名称
    private String description; //角色
    private Date createTime; //创建时间
    private String createPerson; //创建人
    private String creator; //创建人ID
    private String editor; //修改人ID
    private String modifyPerson; //修改人
    private Date modifyTime; //修改时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getModifyPerson() {
        return modifyPerson;
    }

    public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "RoleBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", createPerson='" + createPerson + '\'' +
                ", creator='" + creator + '\'' +
                ", editor='" + editor + '\'' +
                ", modifyPerson='" + modifyPerson + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
