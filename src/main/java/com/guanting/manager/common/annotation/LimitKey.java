package com.guanting.manager.common.annotation;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LimitKey {
    //方法名称
    String methodName() default "";
    //接口类型
    String methodType() default "";
    //访问次数
    int frequency() default 2;
    //业务Key区分
    String paramKey() default "";
    //方法请求地址
    String url() default "";
    //过期时间
    long timeout() default 10000;

}
