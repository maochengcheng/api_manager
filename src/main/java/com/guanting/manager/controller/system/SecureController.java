package com.guanting.manager.controller.system;

import com.guanting.manager.common.catche.BaseConfigCache;
import com.guanting.manager.dao.system.BaseSecretSecureMapper;
import com.guanting.manager.response.PageDataResult;
import com.guanting.manager.pojo.system.BaseSecretSecure;
import com.guanting.manager.service.system.SecureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Title: public class SecureController {
 * @Description: 系统用户管理
 * @author: maochengcheng
 * @version: 1.0
 * @date: 2020/11/20 15:17
 */
@Controller
@RequestMapping("secure")
public class SecureController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecureService secureService;
    @Autowired
    private BaseSecretSecureMapper secureMapper;
    /**
     * 功能描述: 跳到权限列表
     * @param:
     * @return:
     * @auther: maochengcheng
     * @date: 2020/02/28 13:50
     */
    @RequestMapping("/secretSecure")
    public String userManage() {
        return "base/secretSecure";
    }

    /**
     *
     * 功能描述: 分页查询用户列表
     *
     * @param:
     * @return:
     * @auther: maochengcheng
     */
    @RequestMapping(value = "/getSecretSecureList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getSecretSecureList(@RequestParam("pageNum") Integer pageNum,
                                              @RequestParam("pageSize") Integer pageSize, BaseSecretSecure SecretSecureSearch) {
        PageDataResult pdr = new PageDataResult();
        try {
            if(null == pageNum) {
                pageNum = 1;
            }
            if(null == pageSize) {
                pageSize = 10;
            }
            // 获取用户列表
            pdr = secureService.getSecretSecurePage(SecretSecureSearch, pageNum ,pageSize);
            logger.info("用户列表查询=pdr:" + pdr);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户列表查询异常！", e);
        }
        return pdr;
    }


    /**
     * 功能描述: 新增和更新系统用户
     * @param:
     * @return:
     * @auther: maochengcheng
     * @date: 2018/11/22 10:14
     */
    @RequestMapping(value = "/addSecretSercure", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addSecretSercure(BaseSecretSecure bean) {
        logger.info("设置用户[新增或更新]！user:" + bean);
        Map<String,Object> data = new HashMap();
        if(bean.getId() == null || "".equals(bean.getId())){
            bean.setCreateTime(new Date());
            bean.setStatus("1");
            bean.setUserName("mcc");
            bean.setId(UUID.randomUUID().toString());
            data =   secureService.addSecretSercure(bean);
        }else{
            data= secureService.updateSecretSercure(bean);

        }
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
    @RequestMapping(value = "/updateSecretSecureStatus", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateSecretSecureStatus(@RequestParam("id") String id,@RequestParam("status") Integer status) {
        logger.info("删除/恢复用户！id:" + id+" status:"+status);
        Map<String, Object> data = new HashMap<>();
        if(status == 0){
            //删除用户
            data = secureService.delSecretSecure(id,status);
        }else{
            //恢复用户
            data = secureService.recoverSecretSecure(id,status);
        }
        return data;
    }
    /**
     *
     * 功能描述:同步缓存
     * @param:
     * @return:
     * @auther: maochengcheng
     * @date: 2018/11/22 11:59
     */
    @RequestMapping(value = "/synchSecretSecure", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> synchSecretSecure(HttpServletResponse response, HttpServletRequest request) {
        Map<String, Object> data = new HashMap<>();
        List<BaseSecretSecure> list = secureService.getBaseSecretSecureList(new BaseSecretSecure());
        BaseConfigCache.clearSecretSecureMap();
        for(int i = 0;i<list.size();i++){
            BaseConfigCache.addSecretSecureMap(list.get(i).getUserKey(),list.get(i));
        }
        System.out.println(BaseConfigCache.getBaseSecretSecureMap());
        data.put("code","1");
        data.put("msg","同步数据成功");
        System.err.println("缓存中数据----"+BaseConfigCache.getBaseSecretSecureMap().size());
        return data;
    }


}
