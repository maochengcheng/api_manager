package com.guanting.manager.dao.system;


import com.guanting.manager.dto.AdminUserDTO;
import com.guanting.manager.dto.UserSearchDTO;
import com.guanting.manager.pojo.system.BaseAdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mapper.MyMapper;

import java.util.List;

@Mapper
public interface BaseAdminUserMapper extends MyMapper<BaseAdminUser> {

    List<AdminUserDTO> getUserList(UserSearchDTO userSearchDTO);

    BaseAdminUser getUserByUserName(@Param("sysUserName")String sysUserName,@Param("id") String id);

    int updateUserStatus(@Param("id") String id,@Param("status") Integer status);

    int updateUser(BaseAdminUser user);

    BaseAdminUser findByUserName(@Param("userName") String userName);

    int updatePwd(@Param("userName") String userName,@Param("password") String password);

    int saveUser(BaseAdminUser user);
}