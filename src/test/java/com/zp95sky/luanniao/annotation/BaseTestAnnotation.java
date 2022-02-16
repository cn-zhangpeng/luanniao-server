package com.zp95sky.luanniao.annotation;

import com.zp95sky.luanniao.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.*;

/**
 * @author 山海紫穹
 * @date 2021年06月22日 14:09
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@SpringBootTest(classes = {Application.class})
@ActiveProfiles({"prod"})
@interface BaseTestAnnotation {
}
