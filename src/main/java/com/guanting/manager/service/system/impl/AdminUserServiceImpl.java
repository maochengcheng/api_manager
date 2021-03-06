package com.guanting.manager.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guanting.manager.common.utils.DateUtils;
import com.guanting.manager.common.utils.DigestUtils;
import com.guanting.manager.dao.system.BaseAdminUserMapper;
import com.guanting.manager.dto.AdminUserDTO;
import com.guanting.manager.dto.UserSearchDTO;
import com.guanting.manager.pojo.system.BaseAdminUser;
import com.guanting.manager.response.PageDataResult;
import com.guanting.manager.service.system.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Title: AdminUserServiceImpl
 * @Description:
 * @author: maochengcheng
 * @version: 1.0
 * @date:
 */
@Service
public class AdminUserServiceImpl implements AdminUserService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseAdminUserMapper baseAdminUserMapper;

    @Override
    public PageDataResult getUserList(UserSearchDTO userSearch, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        PageHelper.startPage(pageNum, pageSize);
        List<AdminUserDTO> baseAdminUsers = baseAdminUserMapper.getUserList(userSearch);
        if(baseAdminUsers.size() != 0){
            PageInfo<AdminUserDTO> pageInfo = new PageInfo<>(baseAdminUsers);
            pageDataResult.setList(baseAdminUsers);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }

        return pageDataResult;
    }


    @Override
    public Map<String,Object> addUser(BaseAdminUser user) {
        Map<String,Object> data = new HashMap();
        try {
            BaseAdminUser old = baseAdminUserMapper.getUserByUserName(user.getSysUserName(),null);
            if(old != null){
                data.put("code",0);
                data.put("msg","?????????????????????");
                logger.error("??????[??????]?????????=?????????????????????");
                return data;
            }
            String phone = user.getUserPhone();
            if(phone.length() != 11){
                data.put("code",0);
                data.put("msg","????????????????????????");
                logger.error("?????????[???????????????]?????????=????????????????????????");
                return data;
            }
            String username = user.getSysUserName();
            if(user.getSysUserPwd() == null){
                String password = DigestUtils.Md5(username,"123456");
                user.setSysUserPwd(password);
            }else{
                String password = DigestUtils.Md5(username,user.getSysUserPwd());
                user.setSysUserPwd(password);
            }
            user.setRegTime(DateUtils.getCurrentDate());
            user.setUserStatus(1);
            user.setId(UUID.randomUUID().toString());
            int result = baseAdminUserMapper.insert(user);
          //  int result = baseAdminUserMapper.saveUser(user);
            if(result == 0){
                data.put("code",0);
                data.put("msg","???????????????");
                logger.error("??????[??????]?????????=???????????????");
                return data;
            }
            data.put("code",1);
            data.put("msg","???????????????");
            logger.info("??????[??????]?????????=???????????????");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("??????[??????]?????????", e);
            return data;
        }
        return data;
    }


    @Override
    public Map <String, Object> updateUser(BaseAdminUser user) {
        Map<String,Object> data = new HashMap();
        String id = user.getId();
        BaseAdminUser old = baseAdminUserMapper.getUserByUserName(user.getSysUserName(),id);
        if(old != null){
            data.put("code",0);
            data.put("msg","?????????????????????");
            logger.error("??????[??????]?????????=?????????????????????");
            return data;
        }
        String username = user.getSysUserName();
        if(user.getSysUserPwd() != null){
            String password = DigestUtils.Md5(username,user.getSysUserPwd());
            user.setSysUserPwd(password);
        }

        int result = baseAdminUserMapper.updateUser(user);
        if(result == 0){
            data.put("code",0);
            data.put("msg","???????????????");
            logger.error("??????[??????]?????????=???????????????");
            return data;
        }
        data.put("code",1);
        data.put("msg","???????????????");
        logger.info("??????[??????]?????????=???????????????");
        return data;
    }

    @Override
    public BaseAdminUser getUserById(Integer id) {
        return baseAdminUserMapper.selectByPrimaryKey(id);
    }


    @Override
    public Map <String, Object> delUser(String id,Integer status) {
        Map<String, Object> data = new HashMap<>();
        try {
            // ????????????
            int result = baseAdminUserMapper.updateUserStatus(id,status);
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

    @Override
    public Map <String, Object> recoverUser(String id, Integer status) {
        Map<String, Object> data = new HashMap<>();
        try {
            int result = baseAdminUserMapper.updateUserStatus(id,status);
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
    public BaseAdminUser findByUserName(String userName) {
        return baseAdminUserMapper.findByUserName(userName);
    }


    @Override
    public int updatePwd(String userName, String password) {
        password = DigestUtils.Md5(userName,password);
        return baseAdminUserMapper.updatePwd(userName,password);
    }
}
