package com.guanting.manager.pojo.system;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "base_operation_history")
public class BaseOperationHistory implements Serializable {
    @Id
    private String id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "code")
    private String code;

    @Column(name = "args")
    private String args;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "host")
    private String host;

    @Column(name = "address_url")
    private String addressUrl;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "zybh")
    private String zybh;

    @Column(name = "jsbh")
    private String jsbh;

    @Column(name = "param_key")
    private String paramKey;

    @Column(name = "user_key")
    private String userKey;

    @Column(name = "response_time")
    private long responseTime;

    @Column(name = "message")
    private String message;

    @Column(name = "response_object")
    private String responseObject;

    public String getId() {
        return id;
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
}