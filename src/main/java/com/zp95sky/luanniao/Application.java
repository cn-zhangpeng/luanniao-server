package com.zp95sky.luanniao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 山海紫穹
 * @date 2021年06月22日 13:30
 */
@SpringBootApplication
@MapperScan("com.zp95sky.luanniao.*.mapper")
public class Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
