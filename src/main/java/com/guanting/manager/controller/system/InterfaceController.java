package com.guanting.manager.controller.system;

import com.guanting.manager.common.catche.BaseModuleCache;
import com.guanting.manager.dto.BaseInterfaceDTO;
import com.guanting.manager.pojo.system.BaseInterfaceInfo;
import com.guanting.manager.pojo.system.BaseOperationHistory;
import com.guanting.manager.pojo.system.ModuleConfig;
import com.guanting.manager.response.PageDataResult;
import com.guanting.manager.service.system.InterfaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: UserController
 * @Description: 系统用户管理
 * @author: maochengcheng
 * @version: 1.0
 * @date: 2020/11/20 15:17
 */
@Controller
@RequestMapping("base")
public class InterfaceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private InterfaceService interfaceService;

    /**
     * 功能描述: 跳到接口管理
     * @auther: maochengcheng
     * @date: 2020/03/11 13:50
     */
    @RequestMapping("/interfaceManage")
    public String interfaceManage() {
        return "base/interfaceManage";
    }
    /**
     * 功能描述: 跳到接口管理
     * @auther: maochengcheng
     * @date: 2020/03/11 13:50
     */
    @RequestMapping("/operationHistory")
    public String operationHistory() {
        return "base/operationHistory";
    }
    /**
     * 功能描述: 跳到接口管理
     * @auther: maochengcheng
     * @date: 2020/03/11 13:50
     */
    @RequestMapping("/interfaceSearch")
    public String interfaceSearch() {
        return "base/interfaceSearch";
    }

    /**
     * 功能描述: 分页查询接口列表
     * @param:
     * @return:
     * @auther: maochengcheng
     * @date: 2018/11/21 11:10
     */
    @RequestMapping(value = "/getInterfaceList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getInterfaceList(@RequestParam("pageNum") Integer pageNum,
                                      @RequestParam("pageSize") Integer pageSize, BaseInterfaceDTO interfaceSearch) {
        PageDataResult pdr = new PageDataResult();
        try {
            if(null == pageNum) {
                pageNum = 1;
            }
            if(null == pageSize) {
                pageSize = 10;
            }
            pdr=interfaceService.getBaseInterfaceInfoList(interfaceSearch,pageNum,pageSize);
            logger.info("接口列表查询=pdr:" + pdr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接口列表查询异常！", e);
        }
        return pdr;
    }
    /**
     * 功能描述: 分页查询接口列表
     * @param:
     * @return:
     * @auther: maochengcheng
     * @date: 2018/11/21 11:10
     */
    @RequestMapping(value = "/getInterfaceOperationHistoryList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getInterfaceOperationHistoryList(@RequestParam("pageNum") Integer pageNum,
                                           @RequestParam("pageSize") Integer pageSize, BaseOperationHistory interfaceHistorySearch) {
        PageDataResult pdr = new PageDataResult();
        try {
            if(null == pageNum) {
                pageNum = 1;
            }
            if(null == pageSize) {
                pageSize = 10;
            }
            pdr=interfaceService.getInterfaceOperationHistoryList(interfaceHistorySearch,pageNum,pageSize);
            logger.info("接口列表查询=pdr:" + pdr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("接口列表查询异常！", e);
        }
        return pdr;
    }

    /**
     *
     * 功能描述: 新增和更新系统用户
     * @param:
     * @return:
     * @auther: maochengcheng
     * @date: 2018/11/22 10:14
     */
    @RequestMapping(value = "/updateInterfaceInfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateInterfaceInfo(BaseInterfaceInfo bean) {
        logger.info("设置用户[新增或更新]！user:" + bean);
        Map<String,Object> data = new HashMap();
        data = interfaceService.updateInterfaceInfo(bean);
        return data;
    }
    /**
     *
     * 功能描述: 删除/恢复 用户
     * @param:
     * @return:
     * @auther: maochengcheng
     * @date: 2018/11/22 11:59
     */
    @RequestMapping(value = "/updateInterfaceStatus", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateInterfaceStatus(@RequestParam("id") String id,@RequestParam("status") String status) {
        logger.info("删除/恢复用户！id:" + id+" status:"+status);
        Map<String, Object> data = new HashMap<>();
        if(status == "0"){
            //删除用户
            data = interfaceService.delInterface(id,status);
        }else{
            //恢复用户
            data = interfaceService.recoverInterface(id,status);
        }
        return data;
    }
    /**
     * 功能描述: 获取接口模块列表
     * @param:
     * @return:
     * @auther: maochengcheng
     * @date: 2018/11/30 11:35
     */
    @GetMapping("getInterfaceModuleList")
    @ResponseBody
    public List<ModuleConfig> getInterfaceModuleList(){
        logger.info("获取接口模块列表");
        List<ModuleConfig> list =  BaseModuleCache.getModuleList();
        return list;
    }
}
