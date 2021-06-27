package com.guanting.manager.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guanting.manager.dao.system.TableMapper;
import com.guanting.manager.pojo.system.TableExplain;
import com.guanting.manager.response.PageDataResult;
import com.guanting.manager.service.system.TableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: AdminUserServiceImpl
 * @Description:
 * @author: maochengcheng
 * @version: 1.0
 * @date:
 */
@Service
public class TableServiceImpl implements TableService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TableMapper tableMapper;

    @Override
    public PageDataResult getTableList(TableExplain userSearch, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        PageHelper.startPage(pageNum, pageSize);
        List<TableExplain> tableList = tableMapper.getTableList(userSearch);
        if(tableList.size() != 0){
            PageInfo<TableExplain> pageInfo = new PageInfo<>(tableList);
            pageDataResult.setList(tableList);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }

        return pageDataResult;
    }

    @Override
    public Map<String, Object> addTableExplain(TableExplain tableExplain) {
        Map<String,Object> data = new HashMap();
        int result = tableMapper.insert(tableExplain);
        if(result == 0){
            data.put("code",0);
            data.put("msg","新增失败！");
            logger.error("表信息[新增]，结果=新增失败！");
            return data;
        }
        data.put("code",1);
        data.put("msg","新增成功！");
        logger.info("表信息[新增]，结果=新增成功！");
        return null;
    }

    @Override
    public Map<String, Object> updateTableExplain(TableExplain tableExplain) {
        Map<String,Object> data = new HashMap();
        int result = tableMapper.updateTableExplain(tableExplain);
        if(result == 0){
            data.put("code",0);
            data.put("msg","更新失败！");
            logger.error("用户[更新]，结果=更新失败！");
            return data;
        }
        data.put("code",1);
        data.put("msg","更新成功！");
        logger.info("用户[更新]，结果=更新成功！");
        return null;
    }


}
