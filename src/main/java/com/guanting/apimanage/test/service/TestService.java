package com.guanting.apimanage.test.service;

import com.guanting.apimanage.test.domain.TestBean;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: TestService
 * @Author: maochengcheng
 * @Description:
 * @Date: 2021/2/23 14:00
 * @Version: 1.0
 * @Modified By:
 */
public interface TestService {
    List<TestBean> getTestList(Map map);


}
