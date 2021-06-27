package com.guanting.manager.dto;

;import lombok.Data;

/**
 * @Title: AdminUserDTO
 * @Description:
 * @author: maochengcheng
 * @version: 1.0
 */
@Data
public class AdminUserDTO {

    private String id;

    private String sysUserName;

    private String sysUserPwd;

    private String roleId;

    private String roleName;

    private String userPhone;


    private String regTime;


    private Integer userStatus;

}
