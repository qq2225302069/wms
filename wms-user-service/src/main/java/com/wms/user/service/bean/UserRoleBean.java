package com.wms.user.service.bean;

import java.io.Serializable;
import java.util.Date;

public class UserRoleBean implements Serializable {

    private String id;
    private String userId; //用户ID
    private String roleId; //角色ID
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
        return "UserRoleBean{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", createTime=" + createTime +
                ", createPerson='" + createPerson + '\'' +
                ", creator='" + creator + '\'' +
                ", editor='" + editor + '\'' +
                ", modifyPerson='" + modifyPerson + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
