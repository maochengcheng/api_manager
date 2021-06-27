package com.guanting.manager.service.system;

import com.guanting.manager.pojo.system.TableExplain;
import com.guanting.manager.response.PageDataResult;

import java.util.Map;


/**
 * @Title: AdminUserService
 * @Description:
 * @author: maochengcheng
 * @version: 1.0
 * @date: 2018/11/21 11:04
 */
public interface TableService {

    PageDataResult getTableList(TableExplain tableExplainSearch, Integer pageNum, Integer pageSize);

    Map<String,Object> addTableExplain(TableExplain tableExplain);

    Map<String,Object> updateTableExplain(TableExplain tableExplain);


}
