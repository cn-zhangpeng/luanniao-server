package com.zp95sky.luanniao.auth.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.zp95sky.luanniao.common.constants.CommonConstant;
import com.zp95sky.luanniao.common.constants.RedisConstant;
import com.zp95sky.luanniao.auth.dto.LoginDto;
import com.zp95sky.luanniao.common.constants.ResponseConstant;
import com.zp95sky.luanniao.common.utils.EncryptUtil;
import com.zp95sky.luanniao.user.entity.User;
import com.zp95sky.luanniao.auth.service.LoginService;
import com.zp95sky.luanniao.user.service.UserService;
import com.zp95sky.luanniao.common.utils.RedisUtil;
import io.jsonwebtoken.lang.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author 山海紫穹
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class LoginServiceImpl implements LoginService {

    private final HttpServletRequest request;
    private final Snowflake snowflake;
    private final RedisUtil redisUtil;

    private final UserService userService;

    /** 过期时间，单位：分钟 */
    @Value("${token.expire}")
    private long TOKEN_EXPIRE;

    @Override
    public User getLoginUser() {
        Long userId = getCurrentUserId();
        return userService.getById(userId);
    }

    @Override
    public String login(LoginDto loginDto) {
        // 查询用户
        User user = userService.getByUsername(loginDto.getUsername());
        Assert.notNull(user, ResponseConstant.USER_NOT_EXIST);

        // 检测密码是否匹配
        Assert.isTrue(EncryptUtil.passwordEncrypt(loginDto.getPassword()).equals(user.getPassword()),
                ResponseConstant.PASSWORD_ERROR);

        // 生成token
        String token = snowflake.nextIdStr();

        // 将token保存到redis中
        saveAuthTokenToRedis(user.getUserId(), token);
        return token;
    }

    @Override
    public Long getCurrentUserId() {
        String token = request.getHeader(CommonConstant.TOKEN_HEADER_NAME);
        if (ObjectUtils.isEmpty(token)) { return null; }

        Object user = redisUtil.get(RedisConstant.USER_AUTH_TOKEN_PRE + token);
        return Long.valueOf(String.valueOf(user));
    }

    private void saveAuthTokenToRedis(Long userId, String token) {
        redisUtil.set(RedisConstant.USER_AUTH_TOKEN_PRE + token, userId, TOKEN_EXPIRE, TimeUnit.MINUTES);
    }

}
