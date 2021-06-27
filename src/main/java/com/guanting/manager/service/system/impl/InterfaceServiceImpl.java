package com.guanting.manager.service.system.impl;

import com.guanting.manager.dao.system.BaseInterfaceInfoMapper;
import com.guanting.manager.dao.system.BaseOperationHistoryMapper;
import com.guanting.manager.dto.BaseInterfaceDTO;
import com.guanting.manager.pojo.system.BaseInterfaceInfo;
import com.guanting.manager.pojo.system.BaseOperationHistory;
import com.guanting.manager.response.PageDataResult;
import com.guanting.manager.service.system.InterfaceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: InterfaceServiceImpl
 * @Description:
 * @author: maochengcheng
 * @version: 1.0
 * @date: 2018/11/21 11:04
 */
@Service
public class InterfaceServiceImpl implements InterfaceService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseInterfaceInfoMapper baseInterfaceInfoMapper;
    @Autowired
    private BaseOperationHistoryMapper baseOperationHistoryMapper;
    @Override
    public PageDataResult getBaseInterfaceInfoList(BaseInterfaceDTO baseInterfaceDTO, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        PageHelper.startPage(pageNum, pageSize);
        List<BaseInterfaceInfo> baseInterfaceInfos = baseInterfaceInfoMapper.getBaseInterfaceInfoList(baseInterfaceDTO);
        if(baseInterfaceInfos.size() != 0){
            PageInfo<BaseInterfaceInfo> pageInfo = new PageInfo<>(baseInterfaceInfos);
            pageDataResult.setList(baseInterfaceInfos);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }

        return pageDataResult;
    }
    @Override
    public PageDataResult getInterfaceOperationHistoryList(BaseOperationHistory interfaceHistoryDTO, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        PageHelper.startPage(pageNum, pageSize);
        List<BaseOperationHistory> baseInterfaceOperationInfos = baseOperationHistoryMapper.getBaseOperationHistoryList(interfaceHistoryDTO);

        if(baseInterfaceOperationInfos.size() != 0){
            PageInfo<BaseOperationHistory> pageInfo = new PageInfo<>(baseInterfaceOperationInfos);
            pageDataResult.setList(baseInterfaceOperationInfos);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }

        return pageDataResult;
    }

    @Override
    public Map <String, Object> updateInterfaceInfo(BaseInterfaceInfo bean) {
        Map<String,Object> data = new HashMap();

        int result = baseInterfaceInfoMapper.updateInterfaceInfo(bean);
        if(result == 0){
            data.put("code",0);
            data.put("msg","更新失败！");
            logger.error("用户[更新]，结果=更新失败！");
            return data;
        }
        data.put("code",1);
        data.put("msg","更新成功！");
        logger.info("用户[更新]，结果=更新成功！");
        return data;
    }
    @Override
    public Map<String,Object> delInterface(String id ,String status){
        Map<String,Object> data = new HashMap();
        int result = baseInterfaceInfoMapper.updateInterfaceStatus(id,status);
        if(result>0){
            data.put("code",1);
            data.put("msg","删除成功！");
        }else{
            data.put("code",0);
            data.put("msg","删除失败！");
        }

        return data;
    }

    @Override
    public Map<String,Object> recoverInterface(String id ,String status){
        Map<String,Object> data = new HashMap();
        int result = baseInterfaceInfoMapper.updateInterfaceStatus(id,status);
        if(result>0){
            data.put("code",1);
            data.put("msg","恢复成功！");
        }else{
            data.put("code",0);
            data.put("msg","恢复失败！");
        }
        return data;
    }


}
