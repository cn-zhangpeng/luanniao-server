package com.zp95sky.luanniao.auth.jwt;


import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * jwt 配置
 * @author 山海散客
 * @date 2021年06月25日 12:49
 */
@Data
@Component
@ConfigurationProperties("token.jwt")
public class JwtConfiguration {


    /** 计算 token 用的 key */
    private String key;

    /** 在哪里生成的这个token */
    private String iss;

    /** 有效期：分钟 */
    private int expm;

    public SecretKeySpec getSecretKeySpec() {
        return new SecretKeySpec(this.getKey()
                .getBytes(StandardCharsets.UTF_8), SignatureAlgorithm.HS512.getJcaName());
    }
}
