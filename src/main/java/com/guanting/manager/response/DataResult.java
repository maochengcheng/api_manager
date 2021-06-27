package com.guanting.manager.response;


import java.io.Serializable;

/**
 * @author  maochengcheng
 */
public class DataResult implements Serializable {

    // 响应业务状态
    private Integer code;
    // 响应消息
    private String msg;

    // 响应中的数据的数量
    private Integer count;
    //业务主键
    private String id;
    //相应时间
    private long responseTime;
    // 响应中的数据
    private Object responseObject;

    public DataResult(){

    }

    public DataResult(Integer code, String msg, Integer count, Object responseObject) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.responseObject = responseObject;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }

    public static DataResult ok(Integer count, Object data){
        return new DataResult(200,"提交成功",count,data);
    }

    public static DataResult error(Object responseObject){
        return new DataResult(1,"ERROR",0,responseObject);
    }

    public static DataResult build(Integer code, String msg, Integer count, Object responseObject){
        return new DataResult(code,msg,count,responseObject);
    }

    public static DataResult success(Integer count,Object responseObject){
        return new DataResult(200,"success",count,responseObject);
    }

    public static DataResult aspect(String msg,Object responseObject){
        return new DataResult(300,msg,0,responseObject);
    }
    public static DataResult check(String msg,Object responseObject){
        return new DataResult(1,msg,0,responseObject);
    }
}
