package com.guanting.manager.pojo.system;

import com.guanting.manager.common.catche.BaseModuleCache;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "base_interface_info")
public class BaseInterfaceInfo {
    @Id
    private String id;

   @Transient
    private String moduleName;

    @Column(name = "post")
    private String post;

    @Column(name = "module_code")
    private String moduleCode;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "method_type")
    private String methodType;

    @Column(name = "param_key")
    private String paramKey;

    @Column(name = "user_key")
    private String userKey;

    @Column(name = "timeout")
    private Long timeout;

    @Column(name = "frequency")
    private Integer frequency;

    @Column(name = "url")
    private String url;

    @Column(name = "status")
    private String status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user_name")
    private String createUserName;

    @Column(name = "interface_type")
    private String interfaceType;

    @Column(name = "desc_info")
    private String descInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getModuleName() {
         moduleName = BaseModuleCache.getModuleName(this.moduleCode);
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType == null ? null : methodType.trim();
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey == null ? null : paramKey.trim();
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey == null ? null : userKey.trim();
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType == null ? null : interfaceType.trim();
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}