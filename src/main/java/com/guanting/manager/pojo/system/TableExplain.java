package com.guanting.manager.pojo.system;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @ClassName: TableEntity
 * @Author: maochengcheng
 * @Description:
 * @Date: 2021/2/24 11:11
 * @Version: 1.0
 * @Modified By:
 */
@Data
@Table(name = "table_explain")
public class TableExplain {
    @Id
    private String id;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "table_comment")
    private String tableComment;

    @Column(name = "table_type")
    private String tableType;

    @Column(name = "create_time")
    private Date createTime;

    private String flag;

    @Transient
    private String startTime;
    @Transient
    private String endTime;
}
