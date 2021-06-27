package com.guanting.manager.dao.system;


import com.guanting.manager.pojo.system.TableExplain;
import org.apache.ibatis.annotations.Mapper;
import tk.mapper.MyMapper;

import java.util.List;

@Mapper
public interface TableMapper extends MyMapper<TableExplain> {

    List<TableExplain> getTableList(TableExplain tableExplain);

    int updateTableExplain(TableExplain tableExplain);

}