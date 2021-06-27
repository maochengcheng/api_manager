package com.guanting.apimanage.finaconsume.controller;

import com.guanting.apimanage.finaconsume.domain.FinaConsume;
import com.guanting.apimanage.finaconsume.service.FinaConsumeService;
import com.guanting.common.utils.DataGridResult;
import com.guanting.manager.common.annotation.SecureCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("finaConsume")
public class FinaConsumeController{

    @Autowired
    private FinaConsumeService finaConsumeService;
    // 新增
    @PostMapping("/insertFinaConsume")
    @SecureCode(moduleCode = "finance",methodType = "C",methodName="财务数据新增",url="insertFinaConsume",paramKey = "finaConsume/insertFinaConsume",interfaceType="http",descInfo = "财务消费新增")
    public DataGridResult insertFinaConsume(@Valid FinaConsume finaConsume){

        return finaConsumeService.insertFinaConsume(finaConsume);

    }

}
