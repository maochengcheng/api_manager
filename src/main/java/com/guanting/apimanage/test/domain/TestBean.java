package com.guanting.apimanage.test.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName: TestBean
 * @Author: maochengcheng
 * @Description:
 * @Date: 2021/2/23 13:46
 * @Version: 1.0
 * @Modified By:
 */
@Data
@Table(name = "test")
public class TestBean implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
}
