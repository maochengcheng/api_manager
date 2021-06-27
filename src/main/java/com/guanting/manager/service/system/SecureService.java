package com.guanting.manager.service.system;

import com.guanting.manager.pojo.system.BaseInterfaceInfo;
import com.guanting.manager.response.PageDataResult;
import com.guanting.manager.pojo.system.BaseSecretSecure;

import java.util.List;
import java.util.Map;


/**
 * @Description:
 * @author: maochengcheng
 * @version: 1.0
 * @date: 2018/11/21 11:04
 */
public interface SecureService {

    public PageDataResult getSecretSecurePage(BaseSecretSecure secretSecureSearch, Integer pageNum, Integer pageSize);

    public Map<String,Object> addSecretSercure(BaseSecretSecure bean);

    public Map<String,Object> updateSecretSercure(BaseSecretSecure bean);

    public Map<String, Object> recoverSecretSecure(String id, Integer status);

    public Map <String, Object> delSecretSecure(String id,Integer status);

    public List<BaseSecretSecure> getBaseSecretSecureList(BaseSecretSecure bean);

    List<BaseInterfaceInfo> parentInterfacePermissionList();
}
