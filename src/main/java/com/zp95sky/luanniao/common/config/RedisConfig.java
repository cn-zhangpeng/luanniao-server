package com.zp95sky.luanniao.common.config;

import com.zp95sky.luanniao.common.settings.RedisSettings;
import com.zp95sky.luanniao.common.utils.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Redis 配置
 * @author 山海紫穹
 */
@Configuration
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class RedisConfig {

    private final RedisSettings settings;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(settings.getAddress())
                .setDatabase(settings.getDatabase())
                .setIdleConnectionTimeout(settings.getIdleConnectionTimeout())
                .setConnectTimeout(settings.getConnectTimeout())
                .setTimeout(settings.getTimeout())
                .setRetryAttempts(settings.getRetryAttempts())
                .setRetryInterval(settings.getRetryInterval())
                .setPassword(settings.getPassword())
                .setSubscriptionsPerConnection(settings.getSubscriptionsPerConnection())
                .setClientName(settings.getClientName())
                .setConnectionMinimumIdleSize(settings.getConnectionMinimumIdleSize())
                .setConnectionPoolSize(settings.getConnectionPoolSize());
        return Redisson.create(config);
    }

    /**
     * redisson bean
     */
    @Bean
    public RedisUtil redisUtil(RedissonClient redissonClient) {
        return new RedisUtil(redissonClient);
    }

}
