package com.guanting.manager.dto;


import lombok.Data;

import java.util.List;

/**
 * @Title: PermissionDTO
 * @Description:
 * @author: maochengcheng
 * @version: 1.0
 * @date: 2020/02/30 11:22
 */
@Data
public class PermissionDTO {
    private String id;

    private String name;

    private String pid;

    private String pname;

    private String descpt;

    private String url;

    private String createTime;

    private String updateTime;

    private Integer delFlag;

    List<PermissionDTO> childrens;
}
