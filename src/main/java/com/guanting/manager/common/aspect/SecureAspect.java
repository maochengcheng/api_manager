package com.guanting.manager.common.aspect;

import com.guanting.common.constant.UserConstants;
import com.guanting.common.utils.DataGridResult;
import com.guanting.manager.common.annotation.SecureCode;
import com.guanting.manager.common.catche.BaseConfigCache;
import com.guanting.manager.common.utils.DateFormat;
import com.guanting.manager.dao.system.BaseOperationHistoryMapper;
import com.guanting.manager.pojo.system.BaseOperationHistory;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
 * @ClassName: SecureAspect
 * @Author: maochengcheng
 * @Description:
 * @Date: 2020/2/23 13:46
 * @Version: 1.0
 * @Modified By:
 */
@Aspect
@Component
public class SecureAspect {
    @Autowired
    private BaseOperationHistoryMapper baseOperationHistoryMapper;
    static String level = "1";
    private Map limitMap = new HashMap();
    private Map timeMap = new HashMap();
    private final Boolean  auto = true;
    /**
     * Spring中使用@Pointcut注解来定义方法切入点
     *
     * @Pointcut 用来定义切点，针对方法
     * @Aspect 用来定义切面，针对类 后面的增强均是围绕此切入点来完成的
     * 此处仅配置被我们刚才定义的注解：AuthToken修饰的方法即可
     *
     */
    @Pointcut("@annotation(secureCode)")
    public void doSecureCode(SecureCode secureCode) {
    }

    /**
     * 此处我使用环绕增强，在方法执行之前或者执行之后均会执行。
     */
    @Around("doSecureCode(secureCode)")
    public Object deBefore(ProceedingJoinPoint pjp, SecureCode secureCode) throws Throwable {
        long  methodBeginTime  =System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String addressUrl = request.getRequestURI();
        // 获取访问该方法所需的接口信息
        String operation = secureCode.methodType();
        int frequency = secureCode.frequency();
        String methodName = secureCode.methodName();
        String paramKey = secureCode.paramKey();
        String moduleCode =secureCode.moduleCode();
        String url = secureCode.url();
        long timeout = secureCode.timeout();
        //入参
        Object[] args = pjp.getArgs();

        Map map = request.getParameterMap();


//        String userKey = request.getHeader("userKey");
//        String jsbh = request.getHeader("jsbh");
//        String userId = request.getHeader("userId");
//        String userName = request.getHeader("userName");

        String userKey = request.getParameter("userKey");
        String jsbh = request.getParameter("jsbh");
        String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");


        StringBuffer sb = new StringBuffer();
        sb.append(paramKey);

        if(StringUtils.isEmpty(jsbh)){
            return DataGridResult.aspect("权限校验失败，jsbh未识别到",jsbh);
        }
        if(StringUtils.isEmpty(userKey)){
            return DataGridResult.aspect("权限校验失败，userKey未识别到",userKey);
        }
        if(StringUtils.isEmpty(userId)){
            return DataGridResult.aspect("权限校验失败,userId未识别到",userId);
        }
        if(StringUtils.isEmpty(userName)){
            return DataGridResult.aspect("权限校验失败,userName未识别到",userName);
        }

        writeSession(request,Integer.parseInt(jsbh));
       if(BaseConfigCache.isHaveBaseSecretSecureMap(userKey,moduleCode)){
           //进入二层校验
           if(limitMap.get(sb.toString()) == null ) {
               limitMap.put(sb.toString(),frequency-1);
               timeMap.put(sb.toString(),System.currentTimeMillis());
           } else {
               long  startTime  = (long) timeMap.get(sb.toString());
               long endTime = System.currentTimeMillis();    //获取结束时间
               long av = endTime -startTime;
               if(av>=timeout){
                   limitMap.put(sb.toString(),frequency-1);
                   timeMap.put(sb.toString(),System.currentTimeMillis());
               }else{
                   int l = (int) limitMap.get(sb.toString());
                   if(l > 0){
                       limitMap.put(sb.toString(), --l);
                   } else {
                       return DataGridResult.aspect("系统繁忙，请稍后重试！",null);
                   }
               }
           }
           //reids 代替map  redis.set(sb.toString(),frequency,limitKey.timeout());
           System.err.println(DateFormat.getDataStrFormats(new Date())+" -----调用paramKey:  "+sb.toString()+"   剩余次数："+limitMap.get(sb.toString()));
           long methodEndTime = System.currentTimeMillis();    //获取方法结束时间
           DataGridResult data = (DataGridResult)pjp.proceed();
           BaseOperationHistory bean = new BaseOperationHistory();
           bean.setId(UUID.randomUUID().toString());
           bean.setCreateTime(new Date());
           bean.setAddressUrl(addressUrl);
           //bean.setArgs(JSONObject.fromObject(args[0]).toString());
           bean.setCode(data.getCode().toString());
           bean.setJsbh(jsbh);
           bean.setParamKey(paramKey);
           bean.setMethodName(methodName);
           bean.setZybh(data.getId());
           bean.setUserKey(userKey);
           bean.setResponseTime(methodEndTime-methodBeginTime);
           bean.setResponseObject(data.toString());
           bean.setUserId(userId);
           bean.setUserName(userName);
           bean.setMessage(data.getMsg());
           baseOperationHistoryMapper.insert(bean);
           data.setResponseTime(methodEndTime-methodBeginTime);
           return data;
       }else{
           return DataGridResult.aspect("权限校验失败，您没有该接口权限，请申请",null);
       }
    }

    public static void writeSession(HttpServletRequest request,Integer jsbh){
        HttpSession session = request.getSession();
        session.setAttribute(UserConstants.SESSION_JSBH, jsbh);
        session.setAttribute(UserConstants.SESSION_USER_KEY, request.getParameter("userKey"));
    }

}
