package com.guanting.manager.controller.system;

import com.guanting.manager.pojo.system.TableExplain;
import com.guanting.manager.response.PageDataResult;
import com.guanting.manager.service.system.TableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: TableController
 * @Description: 系统用户管理
 * @author: maochengcheng
 * @version: 1.0
 * @date: 2020/11/20 15:17
 */
@Controller
@RequestMapping("table")
public class TableController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TableService tableService;


    /**
     *
     * 功能描述: 跳到系统用户列表
     * @param:
     * @return:
     * @auther: maochengcheng
     * @date: 2021/11/21 13:50
     */
    @RequestMapping("/tableManage")
    public String userManage() {
        return "table/tableManage";
    }

    /**
     *
     * 功能描述: 分页查询表列表
     *
     * @param:
     * @return:
     * @auther: maochengcheng
     * @date: 2018/11/21 11:10
     */
    @RequestMapping(value = "/getTableList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getTableList(@RequestParam("pageNum") Integer pageNum,
                                      @RequestParam("pageSize") Integer pageSize, TableExplain tableSearch) {
        PageDataResult pdr = new PageDataResult();
        try {
            if(null == pageNum) {
                pageNum = 1;
            }
            if(null == pageSize) {
                pageSize = 10;
            }

            // 获取用户列表
            pdr = tableService.getTableList(tableSearch, pageNum ,pageSize);
            logger.info("用户列表查询=pdr:" + pdr);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户列表查询异常！", e);
        }
        return pdr;
    }
    /**
     *
     * 功能描述: 新增和更新系统用户
     *
     * @param:
     * @return:
     * @auther: maochengcheng
     * @date: 2018/11/22 10:14
     */
    @RequestMapping(value = "/setTableExplain", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> setTableExplain(TableExplain user) {
        logger.info("设置用户[新增或更新]！user:" + user);
        Map<String,Object> data = new HashMap();
        if(user.getId() == null || "".equals(user.getId())){
            data = tableService.addTableExplain(user);
        }else{
            data = tableService.updateTableExplain(user);
        }
        return data;
    }



}
