package com.guanting.manager.common.catche;

import com.guanting.manager.pojo.system.ModuleConfig;
import com.github.pagehelper.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class BaseModuleCache {

     private static  Map<String,Object> configMap = new HashMap<>();
     private static List<ModuleConfig> moduleList = new ArrayList<ModuleConfig>(){{
        // add(new ModuleConfig(-1,"system","系统接口"));
         add(new ModuleConfig(0,"base","公共接口"));
         add(new ModuleConfig(1,"finance","财务接口"));

     }};

     static {
         for(ModuleConfig bean :moduleList){
             configMap.put(bean.getModuleCode(),bean.getModuleName());
         }
     }

     public static List<ModuleConfig>  getModuleList(){
        return moduleList;
     }

    public static String getModuleName(String moduleCode){
        if(StringUtil.isEmpty(moduleCode)){
            return "";
        }
        if(configMap.containsKey(moduleCode)){
            return configMap.get(moduleCode).toString();
        }else{
            return "";
        }
    }

}
