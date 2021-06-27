package com.guanting.manager.pojo.system;

public class ModuleConfig {
    private Integer id;
    private String moduleCode;
    private String moduleName;


    public ModuleConfig( Integer id,String moduleCode,String moduleName) {
        this.id = id;
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
