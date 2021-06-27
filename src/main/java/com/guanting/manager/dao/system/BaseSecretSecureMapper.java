package com.guanting.manager.dao.system;


import com.guanting.manager.pojo.system.BaseSecretSecure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mapper.MyMapper;

import java.util.List;

@Mapper
public interface BaseSecretSecureMapper extends MyMapper<BaseSecretSecure> {

    List<BaseSecretSecure> getBaseSecretSecureList(BaseSecretSecure bean);

    int updateSecretSecureStatus(@Param("id") String id, @Param("status") Integer status);

    int updateSecretSercure(BaseSecretSecure bean);

    int deleteSecretSecure(@Param("id") String id);
}