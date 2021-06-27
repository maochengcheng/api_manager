package com.guanting.manager.common.annotation;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SecureCode {
    //密钥
    String[] user_key() default "";
    //接口模块
    String moduleCode() default "";
    //接口类型
    String methodType() default "";
    //接口名称
    String methodName() default "";
    //访问次数
    int frequency() default 2;
    //接口类型
    String interfaceType() default "";
    //业务Key区分
    String paramKey() default "";
    //方法请求地址
    String url() default "";
    //过期时间
    long timeout() default 10000;
    //描述
    String descInfo() default "";
}
