package com.guanting.common.utils;

import java.io.Serializable;


public class DataGridResult implements Serializable {

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据的数量
    private Long count;

    //业务主键
    private String id;
    //相应时间
    private long responseTime;
    // 响应中的数据
    private Object responseObject;
    // 响应中的数据
    private Object dataObject;

    public DataGridResult(){

    }

    public DataGridResult(Integer code, String msg, Long count, Object dataObject) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.dataObject = dataObject;
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

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getDataObject() {
        return dataObject;
    }

    public void setDataObject(Object dataObject) {
        this.dataObject = dataObject;
    }

    public static DataGridResult ok(Long count, Object dataObject){
        return new DataGridResult(200,"提交成功",count,dataObject);
    }

    public static DataGridResult error(){
        return new DataGridResult(1,"ERROR",0L,null);
    }

    public static DataGridResult build(Integer code, String msg, Long count, Object dataObject){
        return new DataGridResult(code,msg,count,dataObject);
    }
    public static DataGridResult build(Integer status, String msg) {
        return new DataGridResult(status, msg, 0l,null);
    }
    public static DataGridResult check(String msg, Object responseObject){
        return new DataGridResult(100,msg,0l,responseObject);
    }

    public static DataGridResult success(Long count, Object responseObject){
        return new DataGridResult(200,"success",count,responseObject);
    }

    public static DataGridResult aspect(String msg,Object responseObject){
        return new DataGridResult(300,msg,0l,responseObject);
    }
}
