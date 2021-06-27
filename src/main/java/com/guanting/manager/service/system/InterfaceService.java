package com.guanting.manager.service.system;

import com.guanting.manager.dto.BaseInterfaceDTO;
import com.guanting.manager.pojo.system.BaseInterfaceInfo;
import com.guanting.manager.pojo.system.BaseOperationHistory;
import com.guanting.manager.response.PageDataResult;

import java.util.Map;


/**
 * @Title: InterfaceService
 * @Description:
 * @author: maochengcheng
 * @version: 1.0
 * @date: 2020/03/15 11:04
 */
public interface InterfaceService {

    PageDataResult getBaseInterfaceInfoList(BaseInterfaceDTO baseInterfaceDTO, Integer pageNum, Integer pageSize);

    PageDataResult getInterfaceOperationHistoryList(BaseOperationHistory interfaceHistoryDTO, Integer pageNum, Integer pageSize);

    Map<String,Object> updateInterfaceInfo(BaseInterfaceInfo bean);

    Map<String,Object> delInterface(String id ,String status);

    Map<String,Object> recoverInterface(String id ,String status);

}
