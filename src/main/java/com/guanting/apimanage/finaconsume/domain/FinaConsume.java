package com.guanting.apimanage.finaconsume.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with Intellij IDEA
 * User: WMQ
 * Date: 2021/2/7
 * Time: 14:50
 * Description: No Description
 */
@Data
public class FinaConsume {

    @Id
    private String zybh;

    @NotNull(message = "监所编号不能为空！")
    private Integer jsbh;


    @NotNull(message = "人员编号不能为空！")
    private String rybh;

    @NotNull(message = "消费金额不能为空！")
    private BigDecimal consumeSum;

    @NotNull(message = "消费内容不能为空！")
    private String consumeContent;

    @NotNull(message = "消费时间不能为空！")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "HH:mm:ss",timezone="GMT+8")
    private Date consumeTime;

    private String approved;

    @JsonFormat(pattern = "HH:mm:ss",timezone="GMT+8")
    private Date approvedTime;

    private String deductionPerson;

    @JsonFormat(pattern = "HH:mm:ss",timezone="GMT+8")
    private Date deductionTime;

    private Integer status;

    private String remarks;

    @JsonFormat(pattern = "HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @NotNull(message = "支出方式不能为空！")
    private String expenditureType;

    @NotNull(message = "支出方式名称不能为空！")
    private String expenditureName;

    private String sczt;
    @NotNull(message = "订单号不能为空！")
    private String billNo;


}
