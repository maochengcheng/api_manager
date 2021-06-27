package com.guanting.apimanage.test.mapper;

import com.guanting.apimanage.test.domain.TestBean;
import org.apache.ibatis.annotations.Mapper;
import tk.mapper.MyMapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: TestMapper
 * @Author: maochengcheng
 * @Description:
 * @Date: 2021/2/23 13:47
 * @Version: 1.0
 * @Modified By:
 */
@Mapper
public interface TestMapper extends MyMapper<TestBean> {
    List<TestBean> getTestList(Map map);


}
