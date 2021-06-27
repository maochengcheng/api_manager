package com.guanting.apimanage.test.controller;

import com.guanting.apimanage.test.domain.TestBean;
import com.guanting.apimanage.test.service.TestService;
import com.guanting.common.utils.DataGridResult;
import com.guanting.manager.common.annotation.SecureCode;
import com.guanting.manager.pojo.system.UserAccess;
import com.guanting.manager.service.system.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TestController
 * @Author: maochengcheng
 * @Description:
 * @Date: 2021/2/23 13:46
 * @Version: 1.0
 * @Modified By:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    HttpClient httpClient;
    @Autowired
    TestService testService;


    @ResponseBody
    @RequestMapping("/testSearch")
    public DataGridResult testSearch(HttpServletRequest request, HttpServletResponse response){
        Map map = new HashMap<String,String>();
        List<TestBean> testList = testService.getTestList(map);
        return DataGridResult.build(200,"查询成功",0L,testList);
    }

    @RequestMapping("/testAop")
    public DataGridResult testAop(HttpServletRequest request, HttpServletResponse response){
        String id = "";
        return DataGridResult.success(1L,id);
    }

    @RequestMapping("/testHttp")
    public String testHttp(HttpServletRequest request, HttpServletResponse response){
        String url = "rysy/addRyInfo";
        HttpMethod method = HttpMethod.GET;
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        String resultStr=httpClient.client(url,method,params);
        return resultStr;
    }

    @RequestMapping("/demo")
    @ResponseBody
    @SecureCode(moduleCode = "base",methodType = "R",methodName="demo接口",url="demo",paramKey = "test/demo",interfaceType="http",descInfo = "demo接口")
    public DataGridResult testService(HttpServletRequest request, HttpServletResponse response){

        Integer jsbh = Integer.parseInt(request.getParameter("jsbh"));
        String mjbh = request.getParameter("mjbh");
        String mjxm = request.getParameter("mjxm");
        String userid = request.getParameter("userid");
        String mjsfzh = request.getParameter("mjsfzh");
        String userName = request.getParameter("userName");
        String userKey = request.getParameter("userKey");

        UserAccess userAccess= new UserAccess(jsbh,mjbh,mjxm,userid,mjsfzh,userName,userKey);
        return DataGridResult.build(200, "demo访问成功！", 0L, userAccess);
    }



}
