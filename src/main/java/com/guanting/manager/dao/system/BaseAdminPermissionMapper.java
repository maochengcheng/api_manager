package com.guanting.manager.dao.system;


import com.guanting.manager.dto.PermissionDTO;
import com.guanting.manager.pojo.system.BaseAdminPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mapper.MyMapper;

import java.util.List;

@Mapper
public interface BaseAdminPermissionMapper extends MyMapper<BaseAdminPermission> {
    List<PermissionDTO> getPermissionList();

    List<PermissionDTO> parentPermissionList();

    int updatePermission(BaseAdminPermission permission);

    List<PermissionDTO> getPermissionListByPId(@Param("pid") String pid);
}