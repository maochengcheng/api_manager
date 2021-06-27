package com.guanting.manager.dao.system;

import com.guanting.manager.dto.BaseInterfaceDTO;
import com.guanting.manager.pojo.system.BaseInterfaceInfo;
import org.apache.ibatis.annotations.Mapper;
import tk.mapper.MyMapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface BaseInterfaceInfoMapper extends MyMapper<BaseInterfaceInfo> {
    int deleteByPrimaryKey(String id);

    List<BaseInterfaceInfo> getBaseInterfaceInfoListbyMap(Map map);

    List<BaseInterfaceInfo> getBaseInterfaceInfoList(BaseInterfaceDTO map);

    int updateInterfaceInfo(BaseInterfaceInfo bean);

    int updateInterfaceStatus(String id,String status);

    int insertInterfaceInfo(BaseInterfaceInfo record);

    int insertSelective(BaseInterfaceInfo record);

    BaseInterfaceInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BaseInterfaceInfo record);

    int updateByPrimaryKey(BaseInterfaceInfo record);

    List<BaseInterfaceInfo> parentInterfacePermissionList();
}