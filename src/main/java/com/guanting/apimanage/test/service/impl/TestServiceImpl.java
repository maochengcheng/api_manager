package com.guanting.apimanage.test.service.impl;


import com.guanting.apimanage.test.domain.TestBean;
import com.guanting.apimanage.test.mapper.TestMapper;
import com.guanting.apimanage.test.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TestServiceImpl
 * @Author: maochengcheng
 * @Description:
 * @Date: 2021/2/23 14:00
 * @Version: 1.0
 * @Modified By:
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testmapper;

    @Override
    public List<TestBean> getTestList(Map map){
        List<TestBean> testList= testmapper.getTestList(map);
        return testList;
    }



}
