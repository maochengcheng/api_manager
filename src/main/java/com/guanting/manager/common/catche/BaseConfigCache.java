package com.guanting.manager.common.catche;



import com.guanting.manager.pojo.system.BaseSecretSecure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maochengcheng
 */
public class BaseConfigCache {

    //设置userkey全局
    public static Map<String, BaseSecretSecure> BaseSecretSecureMap= new HashMap<>();

    public static Map<String, BaseSecretSecure> getBaseSecretSecureMap() {
        return BaseSecretSecureMap;
    }

    public static void addSecretSecureMap(String key, BaseSecretSecure secure){
        BaseSecretSecureMap.put(key,secure);
    }

    public static BaseSecretSecure getBaseSecretSecure(String key){
        if(BaseSecretSecureMap.isEmpty()){
            return new BaseSecretSecure();
        }
        if(!BaseSecretSecureMap.containsKey(key)){
            return new BaseSecretSecure();
        }
        return BaseSecretSecureMap.get(key);
    }

/*    public static boolean isHaveBaseSecretSecureMap(String key){
        if(key ==null ){
            return false;
        }
        if(BaseSecretSecureMap.isEmpty()){
            return false;
        }
        if(BaseSecretSecureMap.containsKey(key)){
            return true;
        }else{
            return false;
        }
    }*/

    public static boolean isHaveBaseSecretSecureMap(String key,String paramKey){
        if(key ==null ){
            return false;
        }
        if(BaseSecretSecureMap.isEmpty()){
            return false;
        }
        if(BaseSecretSecureMap.containsKey(key)){
            BaseSecretSecure bean = BaseSecretSecureMap.get(key);
            if(bean.getInterfacePermissions().contains(paramKey)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    public static void clearSecretSecureMap(){
        BaseSecretSecureMap.clear();
    }

}
