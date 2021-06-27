package com.guanting.manager.common.stater;


import com.guanting.manager.common.catche.BaseConfigCache;
import com.guanting.manager.pojo.system.BaseSecretSecure;
import com.guanting.manager.service.system.SecureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author maochengcheng
 */
@Component
public class MyApplicationRunner  implements ApplicationRunner {
    @Autowired
    SecureService secureService;
    @Override
    public void run(ApplicationArguments var1) throws Exception{
        List<BaseSecretSecure> list = secureService.getBaseSecretSecureList(new BaseSecretSecure());
        System.out.println("------------冠霆数据接口平台系统初始化成功-------------------");
        System.out.println(list);
       for(int i = 0;i<list.size();i++){
           BaseConfigCache.addSecretSecureMap(list.get(i).getUserKey(),list.get(i));
       }

        System.out.println(BaseConfigCache.getBaseSecretSecureMap());
        System.out.println("MyApplicationRunner class will be execute when the project was started!");
    }

}
