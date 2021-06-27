package com.guanting.manager.controller.system;

import com.guanting.manager.dto.LoginDTO;
import com.guanting.manager.pojo.system.BaseAdminUser;
import com.guanting.manager.service.system.AdminUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: UserController
 * @Description: 系统用户管理
 * @author: maochengcheng
 * @version: 1.0
 * @date: 2020/03/15 15:17
 */
@Controller
@RequestMapping("apiUser")
public class ApiUserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminUserService adminUserService;


    /**
     *
     * 功能描述: 登入系统
     *
     * @param:
     * @return:
     * @auther: maochengcheng
     * @date: 20200315
     */
    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, LoginDTO loginDTO, HttpSession session){
        logger.info("进行登陆");
        Map<String,Object> data = new HashMap();
        // 使用 shiro 进行登录
        Subject subject = SecurityUtils.getSubject();

        String userName = loginDTO.getUsername().trim();
        String password = loginDTO.getPassword().trim();
        String rememberMe = loginDTO.getRememberMe();
        String host = request.getRemoteAddr();

        //获取token
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password,host);

        // 设置 remenmberMe 的功能
        if (rememberMe != null && rememberMe.equals("on")) {
            token.setRememberMe(true);
        }

        try {
            subject.login(token);
            // 登录成功
            BaseAdminUser user = (BaseAdminUser) subject.getPrincipal();

            session.setAttribute("user", user.getSysUserName());
            data.put("code",1);
            data.put("url","/home");
            data.put("user",user);
            data.put("message","登陆成功");
            logger.info(user.getSysUserName()+"登陆成功");

            } catch (UnknownAccountException e) {
            data.put("code",0);
            data.put("message",userName+"账号不存在");
            logger.error(userName+"账号不存在");
            return data;
        }catch (DisabledAccountException e){
            data.put("code",0);
            data.put("message",userName+"账号异常");
            logger.error(userName+"账号异常");
            return data;
        }
        catch (AuthenticationException e){
            data.put("code",0);
            data.put("message",userName+"密码错误");
            logger.error(userName+"密码错误");
            return data;
        }

        return data;
    }

}
