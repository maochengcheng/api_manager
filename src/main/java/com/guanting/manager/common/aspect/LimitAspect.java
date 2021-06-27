package com.guanting.manager.common.aspect;

import com.guanting.manager.common.annotation.LimitKey;

import com.guanting.manager.common.utils.DateFormat;
import com.guanting.manager.response.DataResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
@Order
@Aspect
public class LimitAspect {
    private Map limitMap = new HashMap();
    private Map timeMap = new HashMap();

    private static final Logger log = LoggerFactory.getLogger(LimitAspect.class);

    @Pointcut("@annotation(limitKey)")
    public void limit(LimitKey limitKey) {
    }

    @Around("limit(limitKey)")
    public Object aroundLog(ProceedingJoinPoint pjp,LimitKey limitKey) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url2 = request.getRequestURI();
        int frequency = limitKey.frequency();
        String methodName = limitKey.methodName();
        String paramKey = limitKey.paramKey();
        String url = limitKey.url();
        long timeout = limitKey.timeout();
        //入参
        Object[] args = pjp.getArgs();
        System.err.println("url2 : "+url2);
        System.err.println("args : "+Arrays.toString(args));

        StringBuffer sb = new StringBuffer();
        sb.append(url).append("/_").append(methodName).append("_").append(paramKey).append("_key");
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
                return DataResult.aspect("系统繁忙，请稍后重试！",null);
            }
            }
        }
        //reids 代替map  redis.set(sb.toString(),frequency,limitKey.timeout());
        System.err.println(DateFormat.getDataStrFormats(new Date())+"  剩余次数："+limitMap.get(sb.toString())+" ----->key:"+sb.toString());
        return pjp.proceed();
    }


}
