package com.guanting.manager.pojo.system;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAccess implements Serializable {

    Integer jsbh ;
    String mjbh;
    String mjxm  ;
    String userid ;
    String mjsfzh ;
    String userName ;
    String userKey ;


    @Override
    public String toString() {
        return "UserAccess{" +
                "jsbh=" + jsbh +
                ", mjbh='" + mjbh + '\'' +
                ", mjxm='" + mjxm + '\'' +
                ", userid='" + userid + '\'' +
                ", mjsfzh='" + mjsfzh + '\'' +
                ", userName='" + userName + '\'' +
                ", userKey='" + userKey + '\'' +
                '}';
    }

    public UserAccess(Integer jsbh, String mjbh, String mjxm, String userid, String mjsfzh, String userName, String userKey) {
        this.jsbh = jsbh;
        this.mjbh = mjbh;
        this.mjxm = mjxm;
        this.userid = userid;
        this.mjsfzh = mjsfzh;
        this.userName = userName;
        this.userKey = userKey;
    }
}
