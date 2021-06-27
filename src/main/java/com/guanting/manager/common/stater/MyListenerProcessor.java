package com.guanting.manager.common.stater;

import com.guanting.manager.common.annotation.SecureCode;
import com.guanting.manager.dao.system.BaseInterfaceInfoMapper;
import com.guanting.manager.pojo.system.BaseInterfaceInfo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author maochengcheng
 */
@Component
public class MyListenerProcessor  implements BeanPostProcessor {
    @Autowired
    private BaseInterfaceInfoMapper baseInterfaceInfoMapper;
    private Map map = new HashMap();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
        if (methods != null) {
            for (Method method : methods) {
                SecureCode secureCode = AnnotationUtils.findAnnotation(method, SecureCode.class);
                if (null != secureCode) {
                    Map map = new HashMap();
                    map.put("paramKey",secureCode.paramKey());
                    List<BaseInterfaceInfo> list = baseInterfaceInfoMapper.getBaseInterfaceInfoListbyMap(map);
                    if(list ==null || list.isEmpty()){
                        System.out.println("-------------------初始化新接口-------------------   "+secureCode.paramKey());
                        //插入到数据中
                        BaseInterfaceInfo interfaceInfo = new BaseInterfaceInfo();
                        interfaceInfo.setCreateTime(new Date());
                        interfaceInfo.setModuleCode(secureCode.moduleCode());
                        interfaceInfo.setId(UUID.randomUUID().toString());
                        interfaceInfo.setMethodName(secureCode.methodName());
                        interfaceInfo.setMethodType(secureCode.methodType());
                        interfaceInfo.setFrequency(secureCode.frequency());
                        interfaceInfo.setParamKey(secureCode.paramKey());
                        interfaceInfo.setStatus("1");
                        interfaceInfo.setUrl(secureCode.url());
                        interfaceInfo.setTimeout(secureCode.timeout());
                        interfaceInfo.setDescInfo(secureCode.descInfo());
                        interfaceInfo.setCreateUserName("system");
                        interfaceInfo.setInterfaceType(secureCode.interfaceType());
                        baseInterfaceInfoMapper.insert(interfaceInfo);
                    }


                }
            }
        }
        return bean;
    }

}
