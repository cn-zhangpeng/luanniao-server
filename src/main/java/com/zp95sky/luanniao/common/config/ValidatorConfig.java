package com.zp95sky.luanniao.common.config;

import lombok.RequiredArgsConstructor;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * 配置校验快速失败
 * @author 山海紫穹
 */
@Configuration
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ValidatorConfig {

    @Bean
    public Validator validator() {
        return Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast( true )
                .buildValidatorFactory()
                .getValidator();
    }

}
