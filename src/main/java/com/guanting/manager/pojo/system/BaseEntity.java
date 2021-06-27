package com.guanting.manager.pojo.system;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private String operation;
    private String userkey;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUserkey() {
        return userkey;
    }

    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }
    public void saveOperation(){
        this.operation="I";
    }
    public void updateOperation(){
        this.operation="U";
    }
    public void deleteOperation(){
        this.operation="D";
    }
}
