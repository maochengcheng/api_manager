package com.guanting.manager.dao.system;

import com.guanting.manager.pojo.system.BaseAdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mapper.MyMapper;

import java.util.List;

@Mapper
public interface BaseAdminRoleMapper extends MyMapper<BaseAdminRole> {

    List<BaseAdminRole> getRoleList();

    List<BaseAdminRole> getRoles();

    int updateRole(BaseAdminRole role);

    int updateRoleStatus(@Param("id") String id,@Param("roleStatus") Integer roleStatus);

}