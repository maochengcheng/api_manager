package com.guanting.manager.pojo.system;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "base_secret_secure")
public class BaseSecretSecure implements Serializable {
    /**
     * ID
     */
    @Id
    private String id;
    @Column(name = "user_key")
    private String userKey;
    private String jsbh;
    private String ip;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "user_name")
    private String userName;
    private String level;
    private String status;
    @Column(name = "interface_permissions")
    private String interfacePermissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getJsbh() {
        return jsbh;
    }

    public void setJsbh(String jsbh) {
        this.jsbh = jsbh;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInterfacePermissions() {
        return interfacePermissions;
    }

    public void setInterfacePermissions(String interfacePermissions) {
        this.interfacePermissions = interfacePermissions;
    }

    @Transient
    private String startTime;
    @Transient
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Transient
    public String interfacePermissionsName;

    public String getInterfacePermissionsName() {
        return interfacePermissionsName;
    }

    public void setInterfacePermissionsName(String interfacePermissionsName) {
        this.interfacePermissionsName = interfacePermissionsName;
    }
}