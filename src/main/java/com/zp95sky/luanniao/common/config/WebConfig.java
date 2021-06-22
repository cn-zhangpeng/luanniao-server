package com.zp95sky.luanniao.common.config;

import com.zp95sky.luanniao.common.interceptor.LogInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web 配置
 * @author 山海散客
 * @date 2021年06月22日 13:51
 */
@Configuration
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class WebConfig implements WebMvcConfigurer {

    private final LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
    }

}
