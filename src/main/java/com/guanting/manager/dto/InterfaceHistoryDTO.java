package com.guanting.manager.dto;


import lombok.Data;

/**
 * @Title: UserSearchDTO
 * @Description:
 * @author: maochengcheng
 * @version: 1.0
 * @date: 2020/02/21 11:19
 */
@Data
public class InterfaceHistoryDTO {
    private String id;

    private String module;

    private String methodName;

    private String methodType;

    private String paramKey;

    private String url;

    private String status;

    private String startTime;

    private String endTime;

}
