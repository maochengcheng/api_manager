package com.guanting.manager.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.guanting.manager.common.catche.BaseModuleCache;
import com.guanting.manager.dao.system.BaseInterfaceInfoMapper;
import com.guanting.manager.dao.system.BaseSecretSecureMapper;
import com.guanting.manager.pojo.system.BaseInterfaceInfo;
import com.guanting.manager.pojo.system.BaseSecretSecure;
import com.guanting.manager.response.PageDataResult;
import com.guanting.manager.service.system.SecureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: AdminUserServiceImpl
 * @Description:
 * @author: maochengcheng
 * @version: 1.0
 * @date: 2020/03/11 11:04
 */
@Service
public class SecureServiceImpl implements SecureService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseSecretSecureMapper baseSecureMapper;
    @Autowired
    private BaseInterfaceInfoMapper baseInterfaceInfoMapper;
    @Override
    public PageDataResult getSecretSecurePage(BaseSecretSecure secretSecureSearch, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        PageHelper.startPage(pageNum, pageSize);
        List<BaseSecretSecure> list = baseSecureMapper.getBaseSecretSecureList(secretSecureSearch);
        for(BaseSecretSecure secretSecure :list){
            String interfacePermissions =secretSecure.getInterfacePermissions();
            if(!StringUtil.isEmpty(interfacePermissions)){
                String[] ids = interfacePermissions.split(",");
                List<String> p = new ArrayList<>();
                for(String id: ids){
                    p.add(BaseModuleCache.getModuleName(id));
                }
                secretSecure.setInterfacePermissionsName(p.toString());
            }
        }
        if(list.size() != 0){
            PageInfo<BaseSecretSecure> pageInfo = new PageInfo<>();
            pageDataResult.setList(list);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }

        return pageDataResult;
    }
    @Override
    public List<BaseSecretSecure> getBaseSecretSecureList(BaseSecretSecure bean){
        bean.setStatus("1");
        List<BaseSecretSecure> list = baseSecureMapper.getBaseSecretSecureList(bean);
        return list;

    }
    @Override
    public Map<String, Object> addSecretSercure(BaseSecretSecure bean) {
        Map<String, Object> data = new HashMap<>();
        try {
            Integer i = baseSecureMapper.insertSelective(bean);
            if(i>0){
                data.put("code",1);
                data.put("msg","????????????");
            }else{
                data.put("code",0);
                data.put("msg","????????????");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("???????????????", e);
        }
        return data;
    }

    @Override
    public Map<String, Object> updateSecretSercure(BaseSecretSecure bean) {
        Map<String, Object> data = new HashMap<>();
        try {
            Integer i = baseSecureMapper.updateSecretSercure(bean);
            if(i>0){
                data.put("code",1);
                data.put("msg","????????????");
            }else{
                data.put("code",0);
                data.put("msg","????????????");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("???????????????", e);
        }
        return data;
    }

    @Override
    public Map<String, Object> recoverSecretSecure(String id, Integer status) {
        Map<String, Object> data = new HashMap<>();
        try {
            int result = baseSecureMapper.updateSecretSecureStatus(id,status);
            if(result == 0){
                data.put("code",0);
                data.put("msg","??????????????????");
            }
            data.put("code",1);
            data.put("msg","??????????????????");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("?????????????????????", e);
        }
        return data;
    }

    @Override
    public Map<String, Object> delSecretSecure(String id, Integer status) {
        Map<String, Object> data = new HashMap<>();
        try {
            // ????????????
            int result = baseSecureMapper.updateSecretSecureStatus(id,status);
            if(result == 0){
                data.put("code",0);
                data.put("msg","??????????????????");
                logger.error("??????????????????");
                return data;
            }
            data.put("code",1);
            data.put("msg","??????????????????");
            logger.info("??????????????????");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("?????????????????????", e);
        }
        return data;
    }

    public List<BaseInterfaceInfo> parentInterfacePermissionList(){
        return baseInterfaceInfoMapper.parentInterfacePermissionList();
    }

}
