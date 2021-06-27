package com.guanting.manager.service.system;

import com.guanting.manager.dto.UserSearchDTO;
import com.guanting.manager.pojo.system.BaseAdminUser;
import com.guanting.manager.response.PageDataResult;

import java.util.Map;


/**
 * @Title: AdminUserService
 * @Description:
 * @author: maochengcheng
 * @version: 1.0
 * @date: 2018/11/21 11:04
 */
public interface AdminUserService {

    PageDataResult getUserList(UserSearchDTO userSearch, Integer pageNum, Integer pageSize);

    Map<String,Object> addUser(BaseAdminUser user);

    Map<String,Object> updateUser(BaseAdminUser user);

    BaseAdminUser getUserById(Integer id);

    BaseAdminUser findByUserName(String userName);

    int updatePwd(String userName,String password);

    Map<String, Object> delUser(String id,Integer status);

    Map<String, Object> recoverUser(String id,Integer status);
}
