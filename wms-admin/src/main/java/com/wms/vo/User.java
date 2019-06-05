package com.wms.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by cyh on 2019/3/25.
 */
public class User {
    private String id;
    private String username; //账号
    private String password; //密码
    private int passwordSalt; //盐 （暂时没用）
    private Date createTime; //创建时间
    private String createPerson; //创建人
    private String creator; //创建人ID
    private String editor; //修改人ID
    private String modifyPerson; //修改人
    private Date modifyTime; //修改时间

    private List<Permission> permissionList; //所属权限

    private List<Role> roleList; // 所属角色

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(int passwordSalt) {
        this.passwordSalt = passwordSalt;
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
        return "UserBean{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                ", passwordSalt=" + passwordSalt +
                ", createTime=" + createTime +
                ", createPerson='" + createPerson + '\'' +
                ", creator='" + creator + '\'' +
                ", editor='" + editor + '\'' +
                ", modifyPerson='" + modifyPerson + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
