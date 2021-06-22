package com.zp95sky.luanniao.annotation;

import java.lang.annotation.*;

/**
 * 通用测试注解
 * @author 山海散客
 * @date 2021年06月22日 14:09
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@BaseTestAnnotation
public @interface CommonTestAnnotation {
}
