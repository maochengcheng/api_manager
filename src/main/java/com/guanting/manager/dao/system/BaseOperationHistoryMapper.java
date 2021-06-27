package com.guanting.manager.dao.system;

import com.guanting.manager.pojo.system.BaseOperationHistory;
import org.apache.ibatis.annotations.Mapper;
import tk.mapper.MyMapper;

import java.util.List;

@Mapper
public interface BaseOperationHistoryMapper extends MyMapper<BaseOperationHistory> {
    int insert(BaseOperationHistory record);

    int insertSelective(BaseOperationHistory record);

    List<BaseOperationHistory> getBaseOperationHistoryList(BaseOperationHistory baseOperationHistorySearch);
}