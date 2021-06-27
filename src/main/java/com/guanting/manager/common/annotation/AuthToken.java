package com.guanting.manager.common.annotation;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthToken {
    /**
     * 访问所需的身份，默认为空，为登录即可访问，可以多个定义
     *
     * @return
     * @data 2020年02月24日
     * @version v1.0.0.0
     */
    String[] role_name() default "";

}
