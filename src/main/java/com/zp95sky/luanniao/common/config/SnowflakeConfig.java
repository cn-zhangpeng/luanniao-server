package com.zp95sky.luanniao.common.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Snowflake 配置
 * @author 山海散客
 * @date 2021年06月22日 13:46
 */
@Configuration
public class SnowflakeConfig {

    @Value("${id-worker.worker-id}")
    private long workerId;

    @Value("${id-worker.data-center-id}")
    private long dataCenterId;

    @Bean
    public Snowflake snowflake() {
        return IdUtil.getSnowflake(workerId, dataCenterId);
    }

}
